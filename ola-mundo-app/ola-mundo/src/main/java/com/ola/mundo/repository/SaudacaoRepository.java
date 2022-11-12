package com.ola.mundo.repository;

import org.springframework.data.repository.CrudRepository;

import com.ola.mundo.model.Saudacao;

public interface SaudacaoRepository extends CrudRepository<Saudacao, Integer> {
    
}
