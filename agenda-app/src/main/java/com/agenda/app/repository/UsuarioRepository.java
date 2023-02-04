package com.agenda.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agenda.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM tb_usuario u WHERE u.tipoUsuario.idTipoUsuario = :idTipoUsuario")
    List<Usuario> findByTipoUsuario(@Param("idTipoUsuario") int id);

}
