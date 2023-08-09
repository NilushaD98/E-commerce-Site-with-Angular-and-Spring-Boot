package com.ecommerce.ecommerce.util.mapper;

import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductCategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    List<ProductCategoryDTO> EntityListTODTOList(List<ProductCategory> productCategoryList);
}
