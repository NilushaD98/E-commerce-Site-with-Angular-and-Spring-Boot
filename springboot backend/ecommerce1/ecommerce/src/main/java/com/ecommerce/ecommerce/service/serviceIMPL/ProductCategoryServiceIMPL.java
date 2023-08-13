package com.ecommerce.ecommerce.service.serviceIMPL;

import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductCategoryDTO;
import com.ecommerce.ecommerce.dto.request.RequestNewCategorySaveDTO;
import com.ecommerce.ecommerce.repositoy.ProductCategoryRepo;
import com.ecommerce.ecommerce.service.ProductCategoryService;
import com.ecommerce.ecommerce.util.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryServiceIMPL implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Autowired
    private ProductCategoryMapper productCategoryMapper;
    @Override
    public List<ProductCategoryDTO> getAllCategories() {
        List<ProductCategory> productCategoryList = productCategoryRepo.findAll();

        return productCategoryList.stream()
                .map(this::convertEntityToDTOList)
                .collect(Collectors.toList());
    }

    @Override
    public void saveNewCategory(RequestNewCategorySaveDTO requestNewCategorySaveDTO) {
        ProductCategory productCategory = new ProductCategory(
                requestNewCategorySaveDTO.getCategoryName()
        );
        productCategoryRepo.save(productCategory);
    }

    private ProductCategoryDTO convertEntityToDTOList(ProductCategory productCategory){
        ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();
        productCategoryDTO.setProductCategoryID(productCategory.getProductCategoryID());
        productCategoryDTO.setCategoryName(productCategory.getCategoryName());
        return  productCategoryDTO;
    }
}
