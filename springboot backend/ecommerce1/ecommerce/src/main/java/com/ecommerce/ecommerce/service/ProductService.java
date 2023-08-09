package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.dto.ProductDTO;
import com.ecommerce.ecommerce.dto.request.RequestProductSaveDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    void productSave(RequestProductSaveDTO requestProductSaveDTO);
}
