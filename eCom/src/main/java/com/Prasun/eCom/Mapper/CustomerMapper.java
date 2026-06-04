package com.Prasun.eCom.Mapper;

import com.Prasun.eCom.DTO.AddressResponseDTO;
import com.Prasun.eCom.DTO.CustomerRequestDTO;
import com.Prasun.eCom.DTO.CustomerResponseDTO;
import com.Prasun.eCom.Entity.Address;
import com.Prasun.eCom.Entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer toEntity(CustomerRequestDTO dto) {

        Address address = new Address();

        address.setStreet(dto.getAddress().getStreet());

        address.setCity(dto.getAddress().getCity());

        address.setCountry(dto.getAddress().getCountry());

        Customer customer = new Customer();

        customer.setName(dto.getName());

        customer.setEmail(dto.getEmail());

        customer.setAddress(address);

        return customer;
    }

    public CustomerResponseDTO toDTO(Customer customer) {

        AddressResponseDTO addressDTO = new AddressResponseDTO(
                        customer.getAddress().getId(),
                        customer.getAddress().getStreet(),
                        customer.getAddress().getCity(),
                        customer.getAddress().getCountry()
                );

        return new CustomerResponseDTO(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                addressDTO
        );
    }
}
