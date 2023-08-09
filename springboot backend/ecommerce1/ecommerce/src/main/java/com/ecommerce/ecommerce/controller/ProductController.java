package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductDTO;
import com.ecommerce.ecommerce.dto.request.RequestProductSaveDTO;
import com.ecommerce.ecommerce.repositoy.ProductCategoryRepo;
import com.ecommerce.ecommerce.service.ProductService;
import com.ecommerce.ecommerce.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "get_all_products")
    public ResponseEntity<StandardResponse> getAllProducts(){
        List<ProductDTO> productList = productService.getAllProducts();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Product List",productList), HttpStatus.ACCEPTED
        );
    }
    @PostMapping(value = "product_save")
    public void saveProduct(@RequestBody RequestProductSaveDTO requestProductSaveDTO){
        productService.productSave(requestProductSaveDTO);
    }
}
