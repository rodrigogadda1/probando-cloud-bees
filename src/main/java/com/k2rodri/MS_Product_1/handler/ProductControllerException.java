package com.k2rodri.MS_Product_1.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.k2rodri.MS_Product_1.dto.ErrorDTO;

import io.micrometer.common.lang.Nullable;

@ControllerAdvice
public class ProductControllerException {
	
	@ExceptionHandler({ Exception.class})
	@Nullable
	public ResponseEntity<ErrorDTO> handlerException (final Exception exception, final WebRequest request) {
		String message = exception.getMessage();
		return new ResponseEntity<>(ErrorDTO.builder().code("0001").detail(message).build()
				,HttpStatus.INTERNAL_SERVER_ERROR);			
	}


}
