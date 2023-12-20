package com.k2rodri.MS_Product_1.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.k2rodri.MS_Product_1.domain.Producto;
import com.k2rodri.MS_Product_1.dto.ProductoRequestDTO;
import com.k2rodri.MS_Product_1.dto.ProductoResponseDTO;

public class converterTest {
	
	private Producto producto;
	
	@BeforeEach
	void setUp() {
		producto = Producto.builder().id(1L).nombre("Producto1").descripcion("Descripcion del producto 1").precio(5.5).customerId(100L).build();
	}
	
	@Test
	void testingProductRequestDTO_to_producto() {
		ProductoRequestDTO productoRequestDTO = ProductoRequestDTO.builder().id(1L).nombre("Producto1").descripcion("Descripcion del producto 1")
				.precio(5.5).customerId(100L).build();
		assertEquals(producto, converter.converter_productoRequestDTO_to_producto(productoRequestDTO));
	}
	
	@Test
	void testingProduct_to_ProductoResponseDTO() {
		ProductoResponseDTO productoResponseDTO = ProductoResponseDTO.builder().id(1L).nombre("Producto1").descripcion("Descripcion del producto 1")
				.precio(5.5).customerId(100L).build();
		assertEquals(productoResponseDTO, converter.converter_product_to_productoResponseDTO(producto));
	}

}
