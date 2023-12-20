package com.k2rodri.MS_Product_1.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProductException extends Exception{
	
	private static final long serialVersionUID = -4472904049226415149L;

	protected final String code;
	protected final String message;
	protected transient final Object source;	
	
}
