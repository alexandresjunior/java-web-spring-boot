package com.taskify.api.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

import com.taskify.api.model.Tarefa;
import com.taskify.api.repository.TarefaRepository;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @PostMapping
    public Tarefa cadastrarNovoTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping
    public Page<Tarefa> listarTarefas(Pageable paginacao) {
        return tarefaRepository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> buscarTarefaPeloId(@PathVariable("id") Long id) {
        return tarefaRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(
            @PathVariable("id") Long id,
            @RequestBody Tarefa tarefa) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);

        if (tarefaExistente.isPresent()) {
            tarefaExistente.get().setNome(tarefa.getNome());
            tarefaExistente.get().setPrioridade(tarefa.getPrioridade());
            tarefaExistente.get().setStatus(tarefa.getStatus());
            tarefaExistente.get().setDescricao(tarefa.getDescricao());
            tarefaExistente.get().setDataDeCriacao(tarefa.getDataDeCriacao());
            tarefaExistente.get().setDataDeConclusao(tarefa.getDataDeConclusao());
            tarefaExistente.get().setProjeto(tarefa.getProjeto());
            tarefaExistente.get().setUsuario(tarefa.getUsuario());

            return tarefaRepository.save(tarefaExistente.get());
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletarTarefaPeloId(@PathVariable("id") Long id) {
        tarefaRepository.deleteById(id);

        return "Tarefa deletada com sucesso!";
    }

    @GetMapping("/projeto/{id}")
    public List<Tarefa> obterTarefasDeUmProjeto(@PathVariable("id") Long id) {
        return tarefaRepository.findByProjeto(id);
    }

    @GetMapping("/usuario/{id}")
    public List<Tarefa> obterTarefasDeUmUsuario(@PathVariable("id") Long id) {
        return tarefaRepository.findByUsuario(id);
    }

    @GetMapping("/projeto/{idProjeto}/usuario/{idUsuario}")
    public List<Tarefa> filtrarTarefasPorUsuarioEPorProjeto(
        @PathVariable("idProjeto") Long idProjeto,
        @PathVariable("idUsuario") Long idUsuario
    ) {
        return tarefaRepository.findByProjetoAndUsuario(idProjeto, idUsuario);
    }

    @Autowired
    private TarefaRepository tarefaRepository;

}
