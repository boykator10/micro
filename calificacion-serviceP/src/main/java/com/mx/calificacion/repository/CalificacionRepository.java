package com.mx.calificacion.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mx.calificacion.entity.Calificacion;

public interface CalificacionRepository extends MongoRepository
<Calificacion, Long>{
	
	List<Calificacion> findByUsuarioId(String usuarioId);
	List<Calificacion> findByHotelId(String hotelId);

}
