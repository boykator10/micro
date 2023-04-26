package com.mx.usuario.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mx.usuario.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionController {
	
	@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<ApiResponse> handlerResourceNotFoundException
(ResourceNotFoundException resourcenotFoundException){
		String mensaje = resourcenotFoundException.getMessage();
		
		ApiResponse response = new ApiResponse().builder()
				.message(mensaje)
				.success(true)
				.status(HttpStatus.NOT_FOUND)
				.build();
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);	
	
}
}
