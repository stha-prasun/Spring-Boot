package com.Prasun.eCom.Service.impl;

import com.Prasun.eCom.DTO.CategoryDetailsDTO;
import com.Prasun.eCom.DTO.CategoryRequestDTO;
import com.Prasun.eCom.DTO.CategoryResponseDTO;
import com.Prasun.eCom.Entity.Category;
import com.Prasun.eCom.Exception.ResourceNotFoundException;
import com.Prasun.eCom.Mapper.CategoryMapper;
import com.Prasun.eCom.Repository.CategoryRepository;
import com.Prasun.eCom.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;


    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO dto){
        Category category = mapper.toEntity(dto);

        Category saved = repository.save(category);

        return mapper.toDTO(saved);

    }

    @Override
    public List<CategoryResponseDTO> getAllCategories(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id){
        Category category = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));

        return mapper.toDTO(category);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO dto){
        Category category = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " + id));

        category.setName(dto.getName());

        Category updated = repository.save(category);

        return mapper.toDTO(updated);
    }

    @Override
    public void deleteCategory(Long id){
        Category category = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                        "Category not found with id: " + id));
        repository.delete(category);
    }

    @Override
    public CategoryDetailsDTO getCategoryDetails(Long id) {

        Category category = repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(
                                        "Category not found with id: " + id
                        ));

        return mapper.toDetailsDTO(category);
    }
}
