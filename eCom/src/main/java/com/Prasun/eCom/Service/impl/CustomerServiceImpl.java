package com.Prasun.eCom.Service.impl;

import com.Prasun.eCom.DTO.CustomerRequestDTO;
import com.Prasun.eCom.DTO.CustomerResponseDTO;
import com.Prasun.eCom.Entity.Address;
import com.Prasun.eCom.Entity.Customer;
import com.Prasun.eCom.Exception.ResourceNotFoundException;
import com.Prasun.eCom.Mapper.CustomerMapper;
import com.Prasun.eCom.Repository.CustomerRepository;
import com.Prasun.eCom.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper mapper;
    private final CustomerRepository repository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto){
        Customer customer = mapper.toEntity(dto);

        Customer saved = repository.save(customer);

        return mapper.toDTO(saved);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Customer not found with id:" + id
                ));

        return mapper.toDTO(customer);
    }

    @Override
    public void deleteCustomer(Long id){
        Customer customer = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(
                        "Customer not found with id:" + id
                ));

        repository.delete(customer);
    }
}
