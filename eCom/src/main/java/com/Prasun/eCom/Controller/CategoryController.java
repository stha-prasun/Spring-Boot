package com.Prasun.eCom.Controller;

import com.Prasun.eCom.DTO.CategoryDetailsDTO;
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

    @GetMapping("/{id}")
    public CategoryResponseDTO getCategoryById(@PathVariable Long id){
        return service.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDTO updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO dto){
        return service.updateCategory(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
    }

    @GetMapping("/{id}/details")
    public CategoryDetailsDTO getCategoryDetails(@PathVariable Long id) {

        return service.getCategoryDetails(id);
    }
}
