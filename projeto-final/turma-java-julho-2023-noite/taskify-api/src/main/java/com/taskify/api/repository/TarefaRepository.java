package com.taskify.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taskify.api.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    @Query("SELECT t FROM tb_tarefas t WHERE t.projeto.idProjeto = :idProjeto")
    Optional<List<Tarefa>> findByProjeto(Long idProjeto);

    @Query("SELECT t FROM tb_tarefas t WHERE t.usuario.idUsuario = :idUsuario")
    Optional<List<Tarefa>> findByUsuario(Long idUsuario);

}
