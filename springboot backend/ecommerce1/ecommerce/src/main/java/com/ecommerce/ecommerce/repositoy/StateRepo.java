package com.ecommerce.ecommerce.repositoy;

import com.ecommerce.ecommerce.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StateRepo extends JpaRepository<State,Integer> {
    @Query(value = "select * from state where country_id=?1",nativeQuery = true)
    List<State> findAllByCountry_Id(int id);
}
