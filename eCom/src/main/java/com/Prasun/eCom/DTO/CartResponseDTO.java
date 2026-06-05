package com.Prasun.eCom.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDTO {
    private Long cartId;

    private Long customerId;

    private List<CartItemResponseDTO> items;

    private Double totalAmount;
}
