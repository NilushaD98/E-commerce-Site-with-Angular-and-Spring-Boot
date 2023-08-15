package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.Entity.Product;
import com.ecommerce.ecommerce.Entity.ProductCategory;
import com.ecommerce.ecommerce.dto.ProductDTO;
import com.ecommerce.ecommerce.dto.request.RequestProductSaveDTO;
import com.ecommerce.ecommerce.repositoy.ProductCategoryRepo;
import com.ecommerce.ecommerce.repositoy.ProductRepo;
import com.ecommerce.ecommerce.service.ProductService;
import com.ecommerce.ecommerce.util.StandardResponse;
import javassist.NotFoundException;
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
    @Autowired
    private ProductRepo productRepo;

    @GetMapping(value = "get_all_products")
    public ResponseEntity<StandardResponse> getAllProducts(){
        List<ProductDTO> productList = productService.getAllProducts();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Product List",productList,productList.size()), HttpStatus.ACCEPTED
        );
    }
    @PostMapping(value = "product_save")
    public void saveProduct(@RequestBody RequestProductSaveDTO requestProductSaveDTO){
        productService.productSave(requestProductSaveDTO);
    }
    @GetMapping(
            value = {"get_products_category_vice"},
            params = {"id","page","size"}
    )
    public ResponseEntity<StandardResponse> getProductsCategoryVice(
            @RequestParam(value = "id")Long categoryId,
            @RequestParam(value = "page")int page,
            @RequestParam(value = "size")int size
    ){
        List<ProductDTO> productDTOList = productService.getProcuctsCategoryVice(categoryId,page,size);
        long count = productRepo.countItems(categoryId);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Prduct List: ",productDTOList,count),HttpStatus.ACCEPTED
        );
    }
    @GetMapping(
            value = {"search_product_by_name"},
            params = {"name","page","size"}
    )
    public ResponseEntity<StandardResponse> searchProductByName(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        List<ProductDTO> productDTOList = productService.searchProductByName(name,page,size);
        long count = productRepo.countSearchedItems(name);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Product List of "+name+":",productDTOList,count),HttpStatus.ACCEPTED
        );
    }
    @GetMapping(
            value = {"get_product_by_id"},
            params = {"id"}
    )
    public ResponseEntity<StandardResponse> getProductByID(@RequestParam(value = "id")Long id) throws NotFoundException {
        ProductDTO productDTO = productService.getProductbyID(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Product Details : ",productDTO,0),HttpStatus.ACCEPTED
        );
    }
}
