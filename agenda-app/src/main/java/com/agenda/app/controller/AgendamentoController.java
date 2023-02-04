package com.agenda.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.app.model.Agendamento;
import com.agenda.app.repository.AgendamentoRepository;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @PostMapping
    public ResponseEntity<Agendamento> criarNovoAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(agendamentoRepository.save(agendamento));
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> obterTodosAgendamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Agendamento>> obterAgendamentoPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<Agendamento> atualizarAgendamento(@RequestBody Agendamento agendamento) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.save(agendamento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarAgendamento(@PathVariable("id") int id) {
        agendamentoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Serviço deletado com sucesso");
    }

    @GetMapping(value = "/cliente/{id}")
    public ResponseEntity<List<Agendamento>> obterAgendamentosDoCliente(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.findByCliente(id));
    }

    @GetMapping(value = "/prestador/{id}")
    public ResponseEntity<List<Agendamento>> obterAgendaDoPrestador(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(agendamentoRepository.findByPrestador(id));
    }

    // TODO: Spring Validation / Security para agendamento APENAS para usuários do
    // tipo CLIENTE.

    @Autowired
    private AgendamentoRepository agendamentoRepository;

}
