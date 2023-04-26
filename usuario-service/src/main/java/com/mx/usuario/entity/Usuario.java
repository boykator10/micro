package com.mx.usuario.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	
	@Id
	@Column(name = "id")
	private String usuarioId;
	
	@Column(name = "nombre", length = 20)
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "informacion")
	private String informacion;	
	
	@Transient
	private List<Calificacion> calificaciones = new ArrayList<>();

}
