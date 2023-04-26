package com.mx.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.hotel.entity.Hotel;
import com.mx.hotel.service.HotelServ;


@RestController
@RequestMapping("/hoteles")
@CrossOrigin
public class HotelController {
	
	@Autowired
	HotelServ hotelServ;
	
	@PostMapping
	public ResponseEntity<Hotel> guardarHotel(@RequestBody
			Hotel hotel){		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(hotelServ.create(hotel));
		
	}
	
	@GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> obtenerHotel(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelServ.get(hotelId));
    }
	
	@GetMapping
    public ResponseEntity<List<Hotel>> listarHoteles(){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelServ.getAll());
    }

}
