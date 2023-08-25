package com.taskify.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskify.api.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("SELECT p FROM tb_projetos p WHERE p.usuario.idUsuario = :id")
    Optional<Page<Projeto>> findByUsuario(@Param("id") Long idUsuario, Pageable pageable);
    
}
