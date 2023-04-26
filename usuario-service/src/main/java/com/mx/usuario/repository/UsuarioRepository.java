package com.mx.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
