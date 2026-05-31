package com.Prasun.eCom.Controller;

import com.Prasun.eCom.DTO.CategoryRequestDTO;
import com.Prasun.eCom.DTO.CategoryResponseDTO;
import com.Prasun.eCom.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public CategoryResponseDTO createCategory(@Valid @RequestBody CategoryRequestDTO dto){
        return service.createCategory(dto);
    }

    @GetMapping
    public List<CategoryResponseDTO> getAllCategories(){
        return service.getAllCategories();
    }
}
