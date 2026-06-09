package com.Prasun.eCom.Mapper;

import com.Prasun.eCom.DTO.CartItemResponseDTO;
import com.Prasun.eCom.DTO.CartResponseDTO;
import com.Prasun.eCom.Entity.Cart;
import com.Prasun.eCom.Entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartMapper {
    public CartResponseDTO toDTO(Cart cart) {

        List<CartItemResponseDTO> items = cart.getCartItems()
                        .stream()
                        .map(this::toItemDTO)
                        .toList();

        double totalAmount = items.stream()
                        .mapToDouble(CartItemResponseDTO::getSubtotal)
                        .sum();

        return new CartResponseDTO(
                cart.getId(),
                cart.getCustomer().getId(),
                items,
                totalAmount
        );
    }

    private CartItemResponseDTO toItemDTO(CartItem item) {

        double subtotal = item.getQuantity() * item.getProduct().getPrice();

        return new CartItemResponseDTO(
                item.getId(),
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getProduct().getPrice(),
                item.getQuantity(),
                subtotal
        );
    }
}
