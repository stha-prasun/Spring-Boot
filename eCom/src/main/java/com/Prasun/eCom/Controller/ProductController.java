package com.Prasun.eCom.Controller;

import com.Prasun.eCom.DTO.ProductRequestDTO;
import com.Prasun.eCom.DTO.ProductResponseDTO;
import com.Prasun.eCom.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ProductResponseDTO createProduct(@Valid @RequestBody ProductRequestDTO dto) {

        return service.createProduct(dto);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequestDTO dto) {
        return service.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {

        service.deleteProduct(id);

        return "Product deleted successfully";
    }
}
