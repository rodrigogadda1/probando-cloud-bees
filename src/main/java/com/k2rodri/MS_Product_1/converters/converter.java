package com.k2rodri.MS_Product_1.converters;

import com.k2rodri.MS_Product_1.domain.Producto;
import com.k2rodri.MS_Product_1.dto.ProductoRequestDTO;
import com.k2rodri.MS_Product_1.dto.ProductoResponseDTO;

public class converter {
	
	public static Producto converter_productoRequestDTO_to_producto (ProductoRequestDTO productoRequestDTO) {
		Producto producto = Producto.builder().nombre(productoRequestDTO.getNombre()).descripcion(productoRequestDTO.getDescripcion())
				.precio(productoRequestDTO.getPrecio()).customerId(productoRequestDTO.getCustomerId()).build();
		if (productoRequestDTO.getId() != null) {
			producto.setId(productoRequestDTO.getId());
		}
		return producto;
	}
	
	public static ProductoResponseDTO converter_product_to_productoResponseDTO (Producto producto) {
		ProductoResponseDTO productoResponseDTO = ProductoResponseDTO.builder().id(producto.getId())
													.nombre(producto.getNombre())
													.descripcion(producto.getDescripcion())
													.precio(producto.getPrecio())
													.customerId(producto.getCustomerId()).build();
		return productoResponseDTO;
	}

}
