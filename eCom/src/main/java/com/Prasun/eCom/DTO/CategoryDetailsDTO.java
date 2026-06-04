package com.Prasun.eCom.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetailsDTO {
    private Long id;
    private String name;

    private List<ProductSummaryDTO> products;
}
