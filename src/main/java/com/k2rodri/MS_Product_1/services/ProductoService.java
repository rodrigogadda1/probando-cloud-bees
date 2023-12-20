package com.k2rodri.MS_Product_1.services;

import java.util.Set;

import com.k2rodri.MS_Product_1.dto.ProductoRequestDTO;
import com.k2rodri.MS_Product_1.dto.ProductoResponseDTO;
import com.k2rodri.MS_Product_1.exceptions.ProductException;

public interface ProductoService {
	
	Set<ProductoResponseDTO> findAll() throws ProductException;
	
	ProductoResponseDTO findById (Long id) throws ProductException;
	
	ProductoResponseDTO save (ProductoRequestDTO productoRequestDTO) throws ProductException;
	
	void delete(ProductoRequestDTO productoRequestDTO) throws ProductException;
	
	void deleteById(Long id) throws ProductException;
	
	Set<ProductoResponseDTO> findByCustomerId (Long idCustomer) throws ProductException;
}
