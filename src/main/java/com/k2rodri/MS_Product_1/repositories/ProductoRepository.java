package com.k2rodri.MS_Product_1.repositories;

import org.springframework.stereotype.Repository;

import com.k2rodri.MS_Product_1.domain.Producto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
	
	List<Producto> findByCustomerId(Long customerId);

}
