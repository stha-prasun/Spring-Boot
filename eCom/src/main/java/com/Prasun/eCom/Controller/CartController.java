package com.Prasun.eCom.Controller;

import com.Prasun.eCom.DTO.AddToCartRequestDTO;
import com.Prasun.eCom.DTO.CartResponseDTO;
import com.Prasun.eCom.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private CartService cartService;

    public CartResponseDTO addToCart(@RequestBody AddToCartRequestDTO dto) {

        return cartService.addToCart(dto);
    }
}
