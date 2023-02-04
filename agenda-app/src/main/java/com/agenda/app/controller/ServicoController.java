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

import com.agenda.app.model.Servico;
import com.agenda.app.repository.ServicoRepository;

@RestController
@RequestMapping(value = "/servicos")
public class ServicoController {

    @PostMapping
    public ResponseEntity<Servico> criarNovoServico(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicoRepository.save(servico));
    }

    @GetMapping
    public ResponseEntity<List<Servico>> obterTodosServicos() {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Servico>> obterServicoPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<Servico> atualizarServico(@RequestBody Servico servico) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.save(servico));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarServico(@PathVariable("id") int id) {
        servicoRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Serviço deletado com sucesso");
    }

    @GetMapping(value = "/prestador/{id}")
    public ResponseEntity<List<Servico>> obterServicosDoPrestador(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.findByPrestador(id));
    }

    // TODO: Spring Validation / Security para cadastro de serviço APENAS para
    // usuários do tipo PRESTADOR.

    @Autowired
    private ServicoRepository servicoRepository;

}
