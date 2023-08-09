package com.ecommerce.ecommerce.repositoy;

import com.ecommerce.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "select id,sku,name,description,unit_price,image_url,category_id from product",nativeQuery = true)
    List<Product> findAllProducts();
}
