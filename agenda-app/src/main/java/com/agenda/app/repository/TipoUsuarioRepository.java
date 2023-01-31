package com.agenda.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agenda.app.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {

    TipoUsuario findByNomeLike(String nome);
    TipoUsuario findByIdTipoUsuarioAndNome(int id, String nome);
    TipoUsuario findByNome(String nome);

}
