package com.mx.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.hotel.entity.Hotel;
import com.mx.hotel.exceptions.ResourceNotFoundException;
import com.mx.hotel.repository.HotelRepository;

@Service
public class HotelServImpl implements HotelServ {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		String randomUsuarioId = UUID.randomUUID().toString();
		hotel.setId(randomUsuarioId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID: " + id));
	}

}
