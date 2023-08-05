package com.taskify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskify.api.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
