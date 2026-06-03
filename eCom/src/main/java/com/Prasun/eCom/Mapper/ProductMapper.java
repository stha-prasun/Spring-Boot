package com.Prasun.eCom.Mapper;

import com.Prasun.eCom.DTO.CategorySummaryDTO;
import com.Prasun.eCom.DTO.ProductRequestDTO;
import com.Prasun.eCom.DTO.ProductResponseDTO;
import com.Prasun.eCom.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDTO dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());

        return product;
    }

    public ProductResponseDTO toDTO(Product product) {

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());

        CategorySummaryDTO categoryDTO = new CategorySummaryDTO(
                        product.getCategory().getId(),
                        product.getCategory().getName()
                );

        dto.setCategory(categoryDTO);

        return dto;
    }
}
