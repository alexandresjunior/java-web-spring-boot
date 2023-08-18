package com.taskify.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskify.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Método finder
    Optional<Usuario> findByEmail(String email);
    Optional<List<Usuario>> findByNome(String nome);
    // TODO: findByNomeLike e findByNomeAndEmail

}
