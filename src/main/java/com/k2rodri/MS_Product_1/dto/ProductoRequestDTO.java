package com.k2rodri.MS_Product_1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoRequestDTO {
	
	private Long id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Long customerId;

}
