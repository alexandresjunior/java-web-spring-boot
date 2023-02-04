package com.agenda.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agenda.app.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {

    @Query("SELECT s FROM tb_servico s WHERE s.prestador.idUsuario = :idPrestador")
    List<Servico> findByPrestador(@Param("idPrestador") int id);

}
