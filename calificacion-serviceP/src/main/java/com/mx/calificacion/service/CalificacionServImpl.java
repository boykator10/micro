package com.mx.calificacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.calificacion.entity.Calificacion;
import com.mx.calificacion.repository.CalificacionRepository;

@Service
public class CalificacionServImpl implements CalificacionService{
	
	@Autowired
	private CalificacionRepository calificacionRepository;

	@Override
	public Calificacion create(Calificacion calificacion) {
		return calificacionRepository.save(calificacion);
	}

	@Override
	public List<Calificacion> getCalificaciones() {
		return calificacionRepository.findAll();
	}

	@Override
	public List<Calificacion> getCalificacionesByUsuarioId(String usuarioId) {
		return calificacionRepository.findByUsuarioId(usuarioId);
	}

	@Override
	public List<Calificacion> getCalificacionesByHotelId(String hotelId) {
		return calificacionRepository.findByHotelId(hotelId);
	}

}
