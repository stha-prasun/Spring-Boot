package com.Prasun.eCom.Repository;

import com.Prasun.eCom.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}