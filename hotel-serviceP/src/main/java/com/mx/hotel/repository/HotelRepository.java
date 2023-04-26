package com.mx.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
