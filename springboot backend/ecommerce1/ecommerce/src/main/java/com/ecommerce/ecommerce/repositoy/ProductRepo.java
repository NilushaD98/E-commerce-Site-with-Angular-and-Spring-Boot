package com.ecommerce.ecommerce.repositoy;

import com.ecommerce.ecommerce.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "select id,sku,name,description,unit_price,image_url,category_id from product",nativeQuery = true)
    List<Product> findAllProducts();
    @Query(value = "SELECT id, sku, name, description, unit_price, image_url, active, units_in_stock, date_created, last_updated, category_id FROM product WHERE category_id = ?1", nativeQuery = true)
    List<Product> getProductByCategoryId(Long categoryId,PageRequest of);
    @Query(value = "select * from product p where p.name like concat('%',?1,'%')",nativeQuery = true)
    List<Product> searchProductByName(String name, PageRequest of);

    @Query(value = "SELECT count(*) FROM product WHERE category_id = ?1", nativeQuery = true)
    long countItems(Long categoryId);

    @Query(value = "select COUNT(*) from product p where p.name like concat('%',?1,'%')",nativeQuery = true)
    long countSearchedItems(String name);
}
