package com.mx.hotel.service;

import java.util.List;

import com.mx.hotel.entity.Hotel;

public interface HotelServ {
	
	Hotel create(Hotel hotel);
	List<Hotel> getAll();
	Hotel get(String id);
	

}
