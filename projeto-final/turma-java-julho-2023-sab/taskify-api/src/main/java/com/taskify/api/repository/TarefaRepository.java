package com.taskify.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskify.api.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
