package com.mx.calificacion.service;

import java.util.List;

import com.mx.calificacion.entity.Calificacion;

public interface CalificacionService {
	
	Calificacion create(Calificacion calificacion);
	
	List<Calificacion> getCalificaciones();
	
	List<Calificacion> getCalificacionesByUsuarioId(String usuarioId);
	
	List<Calificacion> getCalificacionesByHotelId(String hotelId);

}
