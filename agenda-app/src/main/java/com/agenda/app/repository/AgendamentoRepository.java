package com.agenda.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.app.model.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    
}
