package com.mx.usuario.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.usuario.entity.Calificacion;
import com.mx.usuario.entity.Hotel;
import com.mx.usuario.entity.Usuario;
import com.mx.usuario.exceptions.ResourceNotFoundException;
import com.mx.usuario.external.services.HotelService;
import com.mx.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServImpl implements UsuarioService {

	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private HotelService hotelService;

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		String randomUsuarioId = UUID.randomUUID().toString();
		usuario.setUsuarioId(randomUsuarioId);
		return usuarioRepository.save(usuario);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}
	/*
	 * Antes de rest template
	 * 
	 * @Override public Usuario getUsuario(String usuarioId) { return
	 * usuarioRepository.findById(usuarioId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Usuario no encontrado con el ID: " + usuarioId));
	 * }
	 */

	/*
	 * //Configuracion RestTemplate.
	 * 
	 * @Override public Usuario getUsuario(String usuarioId) { Usuario usuario =
	 * usuarioRepository.findById(usuarioId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Usuario no encontrado con el ID: " + usuarioId));
	 * 
	 * Calificacion[] calificacionesDelUsuario = restTemplate.getForObject
	 * ("http://localhost:8083/calificaciones/usuarios/"+usuario.getUsuarioId(),
	 * Calificacion[].class); logger.info("{}",calificacionesDelUsuario);
	 * 
	 * List<Calificacion> calificaciones =
	 * Arrays.stream(calificacionesDelUsuario).collect(Collectors.toList());
	 * 
	 * List<Calificacion> listaCalificaciones =
	 * calificaciones.stream().map(calificacion ->{
	 * System.out.println(calificacion.getHotelId()); ResponseEntity<Hotel>
	 * forEntity = restTemplate.getForEntity
	 * ("http://localhost:8082/hoteles/"+calificacion.getHotelId(), Hotel.class);
	 * Hotel hotel = forEntity.getBody();
	 * logger.info("Respuesta con codigo de estados : {} ",
	 * forEntity.getStatusCode());
	 * 
	 * calificacion.setHotel(hotel); return calificacion;
	 * }).collect(Collectors.toList());
	 * 
	 * 
	 * usuario.setCalificaciones(listaCalificaciones); return usuario; }
	 */

	// INICIA OPENFEING
	@Override
    public Usuario getUsuario(String usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con el ID : " + usuarioId));

        Calificacion[] calificacionesDelUsuario = restTemplate.getForObject("http://localhost:8083/calificaciones/usuarios/"+usuario.getUsuarioId(),Calificacion[].class);
        logger.info("{}",calificacionesDelUsuario);

        List<Calificacion> calificaciones = Arrays.stream(calificacionesDelUsuario).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones = calificaciones.stream().map(calificacion -> {
            System.out.println(calificacion.getHotelId());
            
            Hotel hotel = hotelService.getHotel(calificacion.getHotelId());

         

            calificacion.setHotel(hotel);

            return calificacion;
        }).collect(Collectors.toList());

        usuario.setCalificaciones(listaCalificaciones);

        return usuario;
    }
}
