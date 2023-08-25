package com.taskify.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.api.model.Projeto;
import com.taskify.api.repository.ProjetoRepository;

@RestController
@RequestMapping(value = "/projetos")
public class ProjetoController {

    @PostMapping
    public @ResponseBody Projeto cadastrarProjeto(@RequestBody Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    @GetMapping
    public Page<Projeto> listarProjetos(Pageable pageable) {
        return projetoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Projeto> obterProjetoPeloId(@PathVariable("id") Long idProjeto) {
        return projetoRepository.findById(idProjeto);
    } 
    
    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable("id") Long idProjeto) {
        projetoRepository.deleteById(idProjeto);
    }

    @PutMapping("/{id}")
    public Projeto atualizarProjeto(
        @PathVariable("id") Long idProjeto, 
        @RequestBody Projeto projeto) {

            Optional<Projeto> projetoExistente = projetoRepository.findById(idProjeto);

            if (projetoExistente.isPresent()) {
                // atualizar os campos
                Projeto projetoObj = projetoExistente.get();

                projetoObj.setNome(projeto.getNome());
                projetoObj.setDescricao(projeto.getDescricao());
                projetoObj.setUsuario(projeto.getUsuario());

                return projetoRepository.save(projetoObj);
            }

            return null;
        }

    @GetMapping("/usuario/{id}")
    public Optional<Page<Projeto>> obterProjetosDeUmUsuario(@PathVariable("id") Long idUsuario, Pageable pageable) {
        return projetoRepository.findByUsuario(idUsuario, pageable);
    }

    @Autowired
    private ProjetoRepository projetoRepository;

}
