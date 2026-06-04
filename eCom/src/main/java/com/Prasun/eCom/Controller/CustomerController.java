package com.Prasun.eCom.Controller;

import com.Prasun.eCom.DTO.CustomerRequestDTO;
import com.Prasun.eCom.DTO.CustomerResponseDTO;
import com.Prasun.eCom.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public CustomerResponseDTO createCustomer(@Valid @RequestBody CustomerRequestDTO dto) {

        return service.createCustomer(dto);
    }
}
