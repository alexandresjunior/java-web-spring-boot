package com.agenda.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.agenda.app.dto.Endereco;

@FeignClient(url = "https://viacep.com.br/ws", name = "viacep")
public interface EnderecoService {

    @GetMapping(value = "/{cep}/json")
    Endereco buscarEnderecoPorCep(@PathVariable("cep") String cep);

}
