package com.Prasun.eCom.Service;

import com.Prasun.eCom.DTO.ProductRequestDTO;
import com.Prasun.eCom.DTO.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO dto);

//    List<ProductResponseDTO> getAllProducts();
//
//    ProductResponseDTO getProductById(Long id);
//
//    ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);
//
//    void deleteProduct(Long id);
}
