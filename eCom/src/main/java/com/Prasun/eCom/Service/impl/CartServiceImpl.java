package com.Prasun.eCom.Service.impl;

import com.Prasun.eCom.DTO.AddToCartRequestDTO;
import com.Prasun.eCom.DTO.CartResponseDTO;
import com.Prasun.eCom.Entity.Cart;
import com.Prasun.eCom.Entity.CartItem;
import com.Prasun.eCom.Entity.Customer;
import com.Prasun.eCom.Entity.Product;
import com.Prasun.eCom.Exception.ResourceNotFoundException;
import com.Prasun.eCom.Mapper.CartMapper;
import com.Prasun.eCom.Repository.CartItemRepository;
import com.Prasun.eCom.Repository.CartRepository;
import com.Prasun.eCom.Repository.CustomerRepository;
import com.Prasun.eCom.Repository.ProductRepository;
import com.Prasun.eCom.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartMapper cartMapper;

    @Override
    public CartResponseDTO addToCart(AddToCartRequestDTO dto) {

        Customer customer = customerRepository.findById(
                                dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        Product product = productRepository.findById(
                                dto.getProductId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Product not found"));

        Cart cart = cartRepository.findByCustomerId(
                                customer.getId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Cart not found"));

        CartItem cartItem = cartItemRepository
                        .findByCartIdAndProductId(
                                cart.getId(),
                                product.getId()
                        )
                        .orElse(null);

        if (cartItem != null) {

            cartItem.setQuantity(cartItem.getQuantity() + dto.getQuantity());

        } else {

            cartItem = new CartItem();

            cartItem.setCart(cart);

            cartItem.setProduct(product);

            cartItem.setQuantity(dto.getQuantity());
        }

        cartItemRepository.save(cartItem);

        return cartMapper.toDTO(cart);
    }
}
