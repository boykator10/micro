package com.mx.usuario.service;

import java.util.List;

import com.mx.usuario.entity.Usuario;

public interface UsuarioService {
	
	Usuario saveUsuario(Usuario usuario);
	
	List<Usuario> getAllUsuarios();
	
	Usuario getUsuario(String usuarioId);
}
