package com.Prasun.eCom.Repository;

import com.Prasun.eCom.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}