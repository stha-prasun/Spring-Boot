package com.Prasun.eCom.Repository;

import com.Prasun.eCom.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}