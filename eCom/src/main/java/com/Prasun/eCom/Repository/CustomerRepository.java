package com.Prasun.eCom.Repository;

import com.Prasun.eCom.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}