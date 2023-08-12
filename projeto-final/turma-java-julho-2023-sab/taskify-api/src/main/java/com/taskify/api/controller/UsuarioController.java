package com.taskify.api.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.client.RestTemplate;

import com.taskify.api.dto.EnderecoDTO;
import com.taskify.api.model.Endereco;
import com.taskify.api.model.Usuario;
import com.taskify.api.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @PostMapping
    public ResponseEntity<Usuario> cadastrarNovoUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listarUsuarios(
            @PageableDefault(size = 10, page = 0, sort = "nome", direction = Direction.DESC) Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioPeloId(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(
            @PathVariable("id") Long id,
            @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuarioExistente.get().setNome(usuario.getNome());
            usuarioExistente.get().setSobrenome(usuario.getSobrenome());
            usuarioExistente.get().setEmail(usuario.getEmail());
            usuarioExistente.get().setSenha(usuario.getSenha());
            usuarioExistente.get().setGenero(usuario.getGenero());

            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioExistente.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuarioPeloId(@PathVariable("id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> buscarUsuarioPeloEmail(@PathVariable("email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @GetMapping("/{id}/email/{email}")
    public Optional<Usuario> buscarUsuarioPeloIdEmail(
            @PathVariable("id") Long id,
            @PathVariable("email") String email) {
        return usuarioRepository.findByIdUsuarioAndEmail(id, email);
    }

    @GetMapping("/endereco/{cep}")
    public Endereco obterEnderecoPeloCEP(@PathVariable("cep") String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Endereco.class);
    }

    @PostMapping("/endereco")
    public ResponseEntity<Usuario> salvarEnderecoDoUsuario(@RequestBody EnderecoDTO dto) {
        Optional<Usuario> usuario = usuarioRepository.findById(dto.getIdUsuario());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        String url = String.format("https://viacep.com.br/ws/%s/json/", dto.getCep());

        RestTemplate restTemplate = new RestTemplate();

        Endereco endereco = restTemplate.getForObject(url, Endereco.class);

        if (Objects.nonNull(endereco)) {
            endereco.setNumero(dto.getNumero());
        }

        usuario.get().setEndereco(endereco);

        return ResponseEntity.ok().body(usuarioRepository.save(usuario.get()));
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

}
