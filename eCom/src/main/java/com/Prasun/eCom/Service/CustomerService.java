package com.Prasun.eCom.Service;

import com.Prasun.eCom.DTO.CustomerRequestDTO;
import com.Prasun.eCom.DTO.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO createCustomer(CustomerRequestDTO dto);

//    List<CustomerResponseDTO> getAllCustomers();
//
//    CustomerResponseDTO getCustomerById(Long id);
//
//    void deleteCustomer(Long id);
}
