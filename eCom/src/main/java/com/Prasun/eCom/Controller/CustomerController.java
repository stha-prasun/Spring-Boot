package com.Prasun.eCom.Controller;

import com.Prasun.eCom.DTO.CustomerRequestDTO;
import com.Prasun.eCom.DTO.CustomerResponseDTO;
import com.Prasun.eCom.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerRequestDTO dto) {

        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDTO> getAllCustomers() {

        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerResponseDTO getCustomerById(@PathVariable Long id) {

        return service.getCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        service.deleteCustomer(id);

        return "Customer deleted successfully";
    }

}
