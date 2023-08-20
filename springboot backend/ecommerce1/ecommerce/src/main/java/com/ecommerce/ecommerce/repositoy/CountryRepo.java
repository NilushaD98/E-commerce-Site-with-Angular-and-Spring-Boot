package com.ecommerce.ecommerce.repositoy;

import com.ecommerce.ecommerce.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {

    @Query(value = "select id,code,name from country where code=?1",nativeQuery = true)
    List<Country> findByCode(String code);
}
