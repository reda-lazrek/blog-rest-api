package com.rean.blogrest.dto;

import lombok.Data;

@Data
public class AddCategoryRequest {
    private String name;
    private String description;
}
