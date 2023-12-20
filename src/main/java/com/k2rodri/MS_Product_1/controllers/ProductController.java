package com.k2rodri.MS_Product_1.controllers;

import com.k2rodri.MS_Product_1.dto.ProductoRequestDTO;
import com.k2rodri.MS_Product_1.dto.ProductoResponseDTO;
import com.k2rodri.MS_Product_1.exceptions.ProductException;
import com.k2rodri.MS_Product_1.services.ProductSpringDataService;
import com.k2rodri.MS_Product_1.services.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class ProductController {

    private ProductSpringDataService productSpringDataService;

    public ProductController(ProductSpringDataService productSpringDataService) {
        this.productSpringDataService = productSpringDataService;
    }

    @PostMapping("/product")
    public ProductoResponseDTO addProduct(@RequestBody ProductoRequestDTO productoRequestDTO) throws ProductException {
        return productSpringDataService.save(productoRequestDTO);
    }

    @GetMapping("/product")
    public Set<ProductoResponseDTO> getAllProducts() throws ProductException {
        return productSpringDataService.findAll();
    }

    @GetMapping("/product/customerId")
    public Set<ProductoResponseDTO> getAllProductsByCustomerId(@RequestParam("customerId") Long customerId) throws ProductException {
        return productSpringDataService.findByCustomerId(customerId);
    }
}
