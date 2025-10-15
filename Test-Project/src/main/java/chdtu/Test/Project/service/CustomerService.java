package chdtu.Test.Project.service;

import chdtu.Test.Project.dto.CustomerDTO;
import chdtu.Test.Project.dto.ProductDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    void deleteCustomer(Long id);
    CustomerDTO getCustomer(Long id);
    List<CustomerDTO> getAllCustomers();
}
