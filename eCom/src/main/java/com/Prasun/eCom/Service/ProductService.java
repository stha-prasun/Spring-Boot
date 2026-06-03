package com.Prasun.eCom.Service;

import com.Prasun.eCom.DTO.ProductRequestDTO;
import com.Prasun.eCom.DTO.ProductResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO dto);

    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO dto);

    void deleteProduct(Long id);

    List<ProductResponseDTO> findByCategoryId(Long categoryId);

    List<ProductResponseDTO> searchProducts(String keyword);

    Page<ProductResponseDTO> getProducts(int page, int size, String sortBy, String direction);
}
