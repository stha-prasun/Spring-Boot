package com.Prasun.eCom.Service;

import com.Prasun.eCom.DTO.CategoryDetailsDTO;
import com.Prasun.eCom.DTO.CategoryRequestDTO;
import com.Prasun.eCom.DTO.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO dto);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Long id);

    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto);

    void deleteCategory(Long id);

    CategoryDetailsDTO getCategoryDetails(Long id);
}
