package chdtu.Test.Project.controller;

import chdtu.Test.Project.dto.CustomerDTO;
import chdtu.Test.Project.repositories.CustomerRepository;
import chdtu.Test.Project.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("${end.points.customer}")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("${end.points.create}")
    ResponseEntity<CustomerDTO> createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO createCustomerDTO = customerService.createCustomer(customerDTO);
        return ResponseEntity.ok().body(createCustomerDTO);
    }

    @PatchMapping("${end.points.id}")
    ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO updateCustomerDTO = customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.ok().body(updateCustomerDTO);
    }

    @DeleteMapping("${end.points.id}")
    ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("${end.points.id}")
    ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        CustomerDTO getCustomerDTO = customerService.getCustomer(id);
        return ResponseEntity.ok().body(getCustomerDTO);
    }

    @GetMapping("${end.points.all}")
    ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> getAllCustomerDTO = customerService.getAllCustomers();
        return ResponseEntity.ok().body(getAllCustomerDTO);
    }
}
