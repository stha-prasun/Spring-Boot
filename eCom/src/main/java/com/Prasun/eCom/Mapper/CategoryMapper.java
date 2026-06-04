package com.Prasun.eCom.Mapper;

import com.Prasun.eCom.DTO.CategoryDetailsDTO;
import com.Prasun.eCom.DTO.CategoryRequestDTO;
import com.Prasun.eCom.DTO.CategoryResponseDTO;
import com.Prasun.eCom.DTO.ProductSummaryDTO;
import com.Prasun.eCom.Entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {
    public Category toEntity(CategoryRequestDTO dto) {

        Category category = new Category();

        category.setName(dto.getName());

        return category;
    }

    public CategoryResponseDTO toDTO(Category category) {

        CategoryResponseDTO dto = new CategoryResponseDTO();

        dto.setId(category.getId());
        dto.setName(category.getName());

        return dto;
    }

    public CategoryDetailsDTO toDetailsDTO(Category category) {

        List<ProductSummaryDTO> products = category.getProducts()
                        .stream()
                        .map(product ->
                                new ProductSummaryDTO(
                                        product.getId(),
                                        product.getName()
                                ))
                        .toList();

        return new CategoryDetailsDTO(
                category.getId(),
                category.getName(),
                products
        );
    }
}
