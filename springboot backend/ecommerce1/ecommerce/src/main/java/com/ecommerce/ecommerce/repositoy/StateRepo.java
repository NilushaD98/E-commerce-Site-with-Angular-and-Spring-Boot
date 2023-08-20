package com.ecommerce.ecommerce.repositoy;

import com.ecommerce.ecommerce.Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface StateRepo extends JpaRepository<State,Integer> {
    List<State> findStatesByCountry_IdEquals(int id);
}
