package com.Prasun.eCom.Repository;

import com.Prasun.eCom.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}