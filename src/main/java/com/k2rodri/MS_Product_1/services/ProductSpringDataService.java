package com.k2rodri.MS_Product_1.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.k2rodri.MS_Product_1.converters.converter;
import com.k2rodri.MS_Product_1.domain.Producto;
import com.k2rodri.MS_Product_1.dto.ProductoRequestDTO;
import com.k2rodri.MS_Product_1.dto.ProductoResponseDTO;
import com.k2rodri.MS_Product_1.exceptions.ProductException;
import com.k2rodri.MS_Product_1.repositories.ProductoRepository;

@Service
public class ProductSpringDataService implements ProductoService{
	
	ProductoRepository productoRepository;
	
	public ProductSpringDataService(ProductoRepository productoRepository) {
		super();
		this.productoRepository = productoRepository;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<ProductoResponseDTO> findAll() throws ProductException{
		List<Producto> productos = productoRepository.findAll();
		Set<ProductoResponseDTO> productosResponseDTO = new HashSet<>();
		for (Iterator iterator = productos.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			productosResponseDTO.add(converter.converter_product_to_productoResponseDTO(producto));
		}
		return productosResponseDTO;
	}

	@Override
	public ProductoResponseDTO findById(Long id) throws ProductException {
		// TODO Auto-generated method stub
		ProductoResponseDTO productoOut = new ProductoResponseDTO();
		Optional<Producto> productoOptional = productoRepository.findById(id);
		if (!productoOptional.isEmpty()) {
			productoOut = converter.converter_product_to_productoResponseDTO(productoOptional.get());
		} else {
			throw new ProductException("001", "Producto no encontrado", productoOptional);
		}
		return productoOut;
	}

	@Override
	public ProductoResponseDTO save(ProductoRequestDTO productoRequestDTO) throws ProductException {
		// TODO Auto-generated method stub
		Producto producto = converter.converter_productoRequestDTO_to_producto(productoRequestDTO);
		producto = productoRepository.save(producto);
		return converter.converter_product_to_productoResponseDTO(producto);
	}

	@Override
	public void delete(ProductoRequestDTO productoRequestDTO) throws ProductException {
		Producto producto = converter.converter_productoRequestDTO_to_producto(productoRequestDTO);
		productoRepository.delete(producto);
	}

	@Override
	public void deleteById(Long id) throws ProductException {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

	@Override
	public Set<ProductoResponseDTO> findByCustomerId(Long idCustomer){
		// TODO Auto-generated method stub
		Set<ProductoResponseDTO> productosOut = new HashSet<>();
		List<Producto> productosOptionals = productoRepository.findByCustomerId(idCustomer);

		for (Iterator iterator = productosOptionals.iterator(); iterator.hasNext();) {
			Producto producto = (Producto) iterator.next();
			productosOut.add(converter.converter_product_to_productoResponseDTO(producto));
		}
		return productosOut;
	}

}
