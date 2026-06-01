package com.Prasun.eCom.Service.impl;

import com.Prasun.eCom.DTO.ProductRequestDTO;
import com.Prasun.eCom.DTO.ProductResponseDTO;
import com.Prasun.eCom.Entity.Category;
import com.Prasun.eCom.Entity.Product;
import com.Prasun.eCom.Exception.ResourceNotFoundException;
import com.Prasun.eCom.Mapper.ProductMapper;
import com.Prasun.eCom.Repository.CategoryRepository;
import com.Prasun.eCom.Repository.ProductRepository;
import com.Prasun.eCom.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO dto){

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(
                                        "Category not found with id: " + dto.getCategoryId()));

        Product product = mapper.toEntity(dto);
        product.setCategory(category);

        Product saved = productRepository.save(product);
        return mapper.toDTO(saved);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }
}
