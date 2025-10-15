package chdtu.Test.Project.service.impl;

import chdtu.Test.Project.constants.ApiErrorMessage;
import chdtu.Test.Project.dto.CustomerDTO;
import chdtu.Test.Project.entity.Customer;
import chdtu.Test.Project.entity.Product;
import chdtu.Test.Project.exception.DataExistException;
import chdtu.Test.Project.exception.NotFoundException;
import chdtu.Test.Project.mapper.CustomerMapper;
import chdtu.Test.Project.repositories.CustomerRepository;
import chdtu.Test.Project.repositories.ProductRepository;
import chdtu.Test.Project.service.CustomerService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsCustomerByFullName(customerDTO.getFullName())) {
            throw new DataExistException(ApiErrorMessage.CUSTOMER_ALREADY_EXISTS.getMessage(customerDTO.getFullName()));
        }

        validation(customerDTO);

        Customer customer = customerMapper.createCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.CUSTOMER_NOT_FOUND_BY_ID.getMessage(customerDTO.getFullName()))
        );

        validation(customerDTO);

        customerMapper.updateCustomer(customerDTO, customer);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    private void validation(CustomerDTO customerDTO) {
        if (customerDTO.getFullName() != null) {
            if (customerDTO.getFullName().trim().length() < 3) {
                throw new ValidationException("Ім’я повинно містити мінімум 3 символи");
            }
        }

        if (customerDTO.getEmail() != null && !customerDTO.getEmail().matches("^.+@.+\\..+$")) {
            throw new ValidationException("Email is invalid");
        }

        if (customerDTO.getPhoneNumber() != null && !customerDTO.getPhoneNumber().matches("\\+380\\d{9}")) {
            throw new ValidationException("Phone number must be in format +380XXXXXXXXX");
        }

        if (customerDTO.getDeliveryAddress() != null) {
            if (customerDTO.getDeliveryAddress().trim().isEmpty()) {
                throw new ValidationException("Адреса не може бути порожньою");
            }
            if (customerDTO.getDeliveryAddress().length() < 5) {
                throw new ValidationException("Адреса повинна містити мінімум 5 символів");
            }
        }
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.CUSTOMER_NOT_FOUND_BY_ID.getMessage(id))
        );
        customerRepository.delete(customer);
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new NotFoundException(ApiErrorMessage.CUSTOMER_NOT_FOUND_BY_ID.getMessage(id))
        );
        return customerMapper.toDto(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDto)
                .toList();
    }
}
