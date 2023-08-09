package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductCategoryDTO;
import com.ecommerce.ecommerce.service.ProductCategoryService;
import com.ecommerce.ecommerce.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/product_category/")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("get_all_categories")
    public ResponseEntity<StandardResponse> getAllCategories(){
        List<ProductCategoryDTO>productCategoryDTOList = productCategoryService.getAllCategories();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"All Categories: ",productCategoryDTOList), HttpStatus.ACCEPTED
        );
    }
}
