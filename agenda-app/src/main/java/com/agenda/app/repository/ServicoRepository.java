package com.agenda.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.app.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
