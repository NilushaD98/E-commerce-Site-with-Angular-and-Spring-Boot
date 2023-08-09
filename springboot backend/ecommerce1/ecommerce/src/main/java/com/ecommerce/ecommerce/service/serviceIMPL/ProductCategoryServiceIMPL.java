package com.ecommerce.ecommerce.service.serviceIMPL;

import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductCategoryDTO;
import com.ecommerce.ecommerce.repositoy.ProductCategoryRepo;
import com.ecommerce.ecommerce.service.ProductCategoryService;
import com.ecommerce.ecommerce.util.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceIMPL implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategoryDTO> getAllCategories() {
        List<ProductCategory> productCategoryList = productCategoryRepo.findAll();
        List<ProductCategoryDTO> productCategoryDTOList = productCategoryMapper.EntityListTODTOList(productCategoryList);
        return productCategoryDTOList;
    }
}
