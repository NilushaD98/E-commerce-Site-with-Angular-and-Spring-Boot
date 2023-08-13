package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.ProductCategoryDTO;
import com.ecommerce.ecommerce.dto.request.RequestNewCategorySaveDTO;

import java.util.List;

public interface ProductCategoryService {
    List<ProductCategoryDTO> getAllCategories();

    void saveNewCategory(RequestNewCategorySaveDTO requestNewCategorySaveDTO);
}
