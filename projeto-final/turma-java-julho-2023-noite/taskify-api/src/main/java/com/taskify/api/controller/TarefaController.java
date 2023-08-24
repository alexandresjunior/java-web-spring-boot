package com.taskify.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.api.model.Tarefa;
import com.taskify.api.repository.TarefaRepository;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @PostMapping
    public @ResponseBody Tarefa cadastrarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> obterTarefas() {
        return tarefaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Tarefa> obterTarefaPeloId(@PathVariable("id") Long idTarefa) {
        return tarefaRepository.findById(idTarefa);
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable("id") Long idTarefa) {
        tarefaRepository.deleteById(idTarefa);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable("id") Long idTarefa, @RequestBody Tarefa tarefa) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(idTarefa);

        if (tarefaExistente.isPresent()) {
            Tarefa tarefaObj = tarefaExistente.get();

            tarefaObj.setNome(tarefa.getNome());
            tarefaObj.setDescricao(tarefa.getDescricao());
            tarefaObj.setPrioridade(tarefa.getPrioridade());
            tarefaObj.setDataDeCriacao(tarefa.getDataDeCriacao());
            tarefaObj.setDataDeConclusao(tarefa.getDataDeConclusao());
            tarefaObj.setStatus(tarefa.getStatus());
            tarefaObj.setProjeto(tarefa.getProjeto());
            tarefaObj.setUsuario(tarefa.getUsuario());

            return tarefaRepository.save(tarefaObj);
        }

        return null;
    }

    @GetMapping("/projeto/{id}")
    public Optional<List<Tarefa>> obterTarefasDeUmProjeto(@PathVariable("id") Long idProjeto) {
        return tarefaRepository.findByProjeto(idProjeto);
    }

    @GetMapping("/usuario/{id}")
    public Optional<List<Tarefa>> obterTarefasDeUmUsuario(@PathVariable("id") Long idUsuario) {
        return tarefaRepository.findByUsuario(idUsuario);
    }

    @Autowired
    private TarefaRepository tarefaRepository;

}
