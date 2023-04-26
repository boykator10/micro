package com.mx.usuario.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mx.usuario.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE", url="http://localhost:8082")
public interface HotelService {
	
	@GetMapping("/hoteles/{hotelId}")
	Hotel getHotel(@PathVariable String hotel);
	
	

}
