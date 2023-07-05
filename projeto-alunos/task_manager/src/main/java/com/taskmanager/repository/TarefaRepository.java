package com.taskmanager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanager.model.Tarefa;
import com.taskmanager.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
  Page<Tarefa> findByUsuario(Usuario usuario, org.springframework.data.domain.Pageable pageable);
}
