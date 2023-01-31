package com.agenda.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.app.model.TipoUsuario;
import com.agenda.app.repository.TipoUsuarioRepository;

@RestController
public class TipoUsuarioController {
    
    @PostMapping(value = "/tipousuarios")
    public TipoUsuario criarNovoTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @GetMapping(value = "/tipousuarios")
    public List<TipoUsuario> obterTipoDeUsuarios() {
        return tipoUsuarioRepository.findAll();
    }

    @GetMapping(value = "/tipousuarios/{id}")
    public Optional<TipoUsuario> obterTipoUsuarioPeloId(@PathVariable("id") int id) {
        return tipoUsuarioRepository.findById(id);
    }

    @GetMapping(value = "/tipousuarios/nome/{nome}")
    public TipoUsuario obterTipoUsuarioPeloNome(@PathVariable("nome") String nome) {
        return tipoUsuarioRepository.findByNomeLike(nome + "%");
    }

    @DeleteMapping(value = "/tipousuarios/{id}")
    public String deletarTipoUsuarioPeloId(@PathVariable("id") int id) {
        tipoUsuarioRepository.deleteById(id);

        return "Tipo de Usuário deletado com sucesso!";
    }

    @PutMapping(value = "/tipousuarios")
    public TipoUsuario atualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario tipoUsuarioBD = tipoUsuarioRepository.findById(tipoUsuario.getIdTipoUsuario()).get();

        tipoUsuarioBD.setNome(tipoUsuario.getNome());

        return tipoUsuarioRepository.save(tipoUsuarioBD);
    }

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

}
