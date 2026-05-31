package com.Prasun.eCom.Mapper;

import com.Prasun.eCom.DTO.CategoryRequestDTO;
import com.Prasun.eCom.DTO.CategoryResponseDTO;
import com.Prasun.eCom.Entity.Category;
import org.springframework.stereotype.Component;

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

    public void updateEntity(Category category, CategoryRequestDTO dto) {

        category.setName(dto.getName());
    }
}
