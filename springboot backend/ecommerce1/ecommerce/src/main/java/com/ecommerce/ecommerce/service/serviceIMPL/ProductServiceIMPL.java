package com.ecommerce.ecommerce.service.serviceIMPL;

import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductDTO;
import com.ecommerce.ecommerce.dto.request.RequestProductSaveDTO;
import com.ecommerce.ecommerce.repositoy.ProductCategoryRepo;
import com.ecommerce.ecommerce.repositoy.ProductRepo;
import com.ecommerce.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepo.findAll();
        return productList.stream()
                .map(this::convertEntityToDTO).
                collect(Collectors.toList());
    }

    private ProductDTO convertEntityToDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductID(product.getProductID());
        productDTO.setSku(productDTO.getSku());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setImageURL(product.getImageURL());
        productDTO.setLastUpdate(product.getLastUpdate());
        productDTO.setDateCreated(product.getDateCreated());
        productDTO.setActiveStatus(product.isActiveStatus());
        productDTO.setUnitPrice(product.getUnitPrice());
        productDTO.setUnitInStock(product.getUnitInStock());
        productDTO.setCategory(product.getCategory().getProductCategoryID());
        return productDTO;
    }

    @Override
    public void productSave(RequestProductSaveDTO requestProductSaveDTO) {
        ProductCategory productCategory = productCategoryRepo.getById(requestProductSaveDTO.getCategory());
        Product product = new Product(
                requestProductSaveDTO.getSku(),
                requestProductSaveDTO.getName(),
                requestProductSaveDTO.getDescription(),
                requestProductSaveDTO.getUnitPrice(),
                requestProductSaveDTO.getImageURL(),
                requestProductSaveDTO.isActiveStatus(),
                requestProductSaveDTO.getUnitInStock(),
                requestProductSaveDTO.getDateCreated(),
                requestProductSaveDTO.getLastUpdate(),
                productCategory
        );
        productRepo.save(product);
    }
}
