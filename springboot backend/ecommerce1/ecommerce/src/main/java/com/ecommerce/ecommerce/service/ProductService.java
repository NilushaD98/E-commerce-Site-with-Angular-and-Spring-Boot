package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.dto.ProductDTO;
import com.ecommerce.ecommerce.dto.request.RequestProductSaveDTO;
import javassist.NotFoundException;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();

    void productSave(RequestProductSaveDTO requestProductSaveDTO);
    List<ProductDTO> getProcuctsCategoryVice(Long categoryId, int page, int size);

    List<ProductDTO> searchProductByName(String name, int page, int size);

    ProductDTO getProductbyID(Long id) throws NotFoundException;
}
