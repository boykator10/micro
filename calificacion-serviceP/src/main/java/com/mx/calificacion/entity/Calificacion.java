package com.mx.calificacion.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("calificaciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Calificacion {
	
	@Id
	private String calificacionId;
	private String usuarioId;
	private String hotelId;
	private int calificacion;
	private String observaciones;
	

}
