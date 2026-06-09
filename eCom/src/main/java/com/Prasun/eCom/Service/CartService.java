package com.Prasun.eCom.Service;

import com.Prasun.eCom.DTO.AddToCartRequestDTO;
import com.Prasun.eCom.DTO.CartResponseDTO;

public interface CartService {
    CartResponseDTO addToCart(AddToCartRequestDTO dto);
}
