package com.agenda.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
