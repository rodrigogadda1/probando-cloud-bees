package com.k2rodri.MS_Product_1.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.k2rodri.MS_Product_1.domain.Producto;
import com.k2rodri.MS_Product_1.dto.ProductoRequestDTO;
import com.k2rodri.MS_Product_1.dto.ProductoResponseDTO;
import com.k2rodri.MS_Product_1.exceptions.ProductException;
import com.k2rodri.MS_Product_1.repositories.ProductoRepository;

public class ProductSpringDataServiceTest {
	
	@Autowired
	ProductSpringDataService productSpringDataService;
	
	@Mock
	ProductoRepository productoRepository;
	
	Producto producto;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		productSpringDataService = new ProductSpringDataService(productoRepository);
		
		producto = Producto.builder().nombre("nombreTest")
				.descripcion("descripcion test").precio(5.2)
				.customerId(1L).build();
	}
	
	@Test
	public void saveTest() throws ProductException {
		//given
		Producto productoOut = producto;
		productoOut.setId(1L);
		
		ProductoRequestDTO productoRequestDTO = ProductoRequestDTO.builder().nombre("nombreTest").descripcion("descripcion test")
													.precio(5.2).customerId(1L).build();
		ProductoResponseDTO productoResponseDTO = ProductoResponseDTO.builder().nombre("nombreTest").descripcion("descripcion test")
													.id(1L).precio(5.2).customerId(1L).build();
		//when
		when(productoRepository.save(Mockito.any(Producto.class))).thenReturn(productoOut);
		//assert
		assertEquals(productoResponseDTO, productSpringDataService.save(productoRequestDTO));
		verify(productoRepository,times(1)).save(Mockito.any(Producto.class));
	}
	
	@Test
	public void findByIdTest () throws ProductException {
		//given
		producto.setId(1L);
		Optional<Producto> productOptional = Optional.of(producto);
		ProductoResponseDTO productoResponseDTO = ProductoResponseDTO.builder().nombre("nombreTest").descripcion("descripcion test")
														.id(1L).precio(5.2).customerId(1L).build();
		//when
		when(productoRepository.findById(1L)).thenReturn(productOptional);
		//assert
		assertEquals(productoResponseDTO, productSpringDataService.findById(1L));
	}
	
	@Test
	public void findByCustomerIdTest(){
		//given
		List<Producto> repositoryOut = new ArrayList<>();
		producto.setId(1L);
		repositoryOut.add(producto);

		Producto producto2 = Producto.builder().id(2L).nombre("nombre2").descripcion("descripcion2")
				.precio(6.1).customerId(101L).build();
		repositoryOut.add(producto2);

		Producto producto3 = Producto.builder().id(3L).nombre("nombre3").descripcion("descripcion3")
				.precio(3.1).customerId(102L).build();
		repositoryOut.add(producto3);

		Set<ProductoResponseDTO> productoResponseDTOs = new HashSet<>();
		ProductoResponseDTO productoResponseDTO1 = ProductoResponseDTO.builder().id(1L).nombre("nombreTest")
				.descripcion("descripcion test").precio(5.2).customerId(1L).build();
		productoResponseDTOs.add(productoResponseDTO1);
		ProductoResponseDTO productoResponseDTO2 = ProductoResponseDTO.builder().id(2L).nombre("nombre2")
				.descripcion("descripcion2").precio(6.1).customerId(101L).build();
		productoResponseDTOs.add(productoResponseDTO2);
		ProductoResponseDTO productoResponseDTO3 = ProductoResponseDTO.builder().id(3L).nombre("nombre3")
				.descripcion("descripcion3").precio(3.1).customerId(102L).build();
		productoResponseDTOs.add(productoResponseDTO3);
		//when
		when(productoRepository.findByCustomerId(1L)).thenReturn(repositoryOut);
		//assert
		assertEquals(productoResponseDTOs,productSpringDataService.findByCustomerId(1L));
	}

	
}
