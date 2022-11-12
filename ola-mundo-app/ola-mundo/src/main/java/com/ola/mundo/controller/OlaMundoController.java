package com.ola.mundo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ola.mundo.model.Saudacao;
import com.ola.mundo.repository.SaudacaoRepository;

@RestController
public class OlaMundoController {

    @GetMapping("/ola")
    public Saudacao digaOla(
            @RequestParam(name = "id", required = false, defaultValue = "0") int id,
            @RequestParam(name = "mensagem", required = false, defaultValue = "null") String mensagem) {
        return new Saudacao(id, mensagem);
    }

    @PostMapping("/saudacao")
    public Saudacao salvarSaudacao(@RequestBody Saudacao saudacao) {
        return saudacaoRepository.save(saudacao);
    }

    @GetMapping("/saudacao")
    public Iterable<Saudacao> obterTodasSaudacoes() {
        return saudacaoRepository.findAll();
    }

    @GetMapping("/saudacao/{id}")
    public Saudacao obterSaudacaoPorId(@PathVariable String id) {
        return saudacaoRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/saudacao/{id}")
    public String deletarSaudacaoPeloId(@PathVariable String id) {
        saudacaoRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/saudacao/{id}")
    public Object atualizarSaudacao(
        @PathVariable String id,
        @RequestBody Saudacao saudacaoBody) {
            try {
                Saudacao saudacao = saudacaoRepository.findById(Integer.valueOf(id)).get();
                
                saudacao.setMensagem(saudacaoBody.getMensagem());

                return saudacaoRepository.save(saudacao);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private SaudacaoRepository saudacaoRepository;

}
