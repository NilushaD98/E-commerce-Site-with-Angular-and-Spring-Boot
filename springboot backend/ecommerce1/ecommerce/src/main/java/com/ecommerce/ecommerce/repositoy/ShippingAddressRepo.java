package com.ecommerce.ecommerce.repositoy;

import com.ecommerce.ecommerce.Entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ShippingAddressRepo extends JpaRepository<ShippingAddress,Long> {
}
