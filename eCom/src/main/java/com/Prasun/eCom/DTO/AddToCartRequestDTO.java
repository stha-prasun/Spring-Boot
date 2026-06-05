package com.Prasun.eCom.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartRequestDTO {
    private Long customerId;

    private Long productId;

    private Integer quantity;
}
