package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ProductCategoryDTO;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDTO> getAllCategories();
}
