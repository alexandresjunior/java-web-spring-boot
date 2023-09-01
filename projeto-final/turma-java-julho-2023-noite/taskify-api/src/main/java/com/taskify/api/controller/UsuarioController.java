package com.taskify.api.controller;

import java.util.List;
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
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuarioObj = usuarioExistente.get();

            usuarioObj.setNome(usuario.getNome());
            usuarioObj.setSobrenome(usuario.getSobrenome());
            usuarioObj.setEmail(usuario.getEmail());
            usuarioObj.setSenha(usuario.getSenha());
            usuarioObj.setGenero(usuario.getGenero());

            return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioObj));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> listarUsuarios(
            @PageableDefault(size = 2, page = 1, sort = "email", direction = Direction.DESC) Pageable paginacao) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> obterUsuarioPeloId(@PathVariable("id") Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioExistente);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuarioPeloId(@PathVariable("id") Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> obterUsuarioPeloEmail(@PathVariable("email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @GetMapping("/nome/{nome}")
    public Optional<List<Usuario>> obterUsuarioPeloNome(@PathVariable("nome") String nome) {
        return usuarioRepository.findByNome(nome);
    }

    @GetMapping("/endereco/{cep}")
    public Endereco obterEnderecoPeloCep(@PathVariable("cep") String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(url, Endereco.class);
    }

    @PostMapping("/endereco")
    public ResponseEntity<Usuario> salvarEnderecoDoUsuario(@RequestBody EnderecoDTO dto) {
        // 1. Verificar se o usuário existe

        Optional<Usuario> usuarioExistente = usuarioRepository.findById(dto.getIdUsuario());

        if (usuarioExistente.isPresent()) {
            // 2. Se o usuário existe, chamar a API do Via CEP e obter os demais campos

            Endereco endereco = obterEnderecoPeloCep(dto.getCep());

            endereco.setNumero(dto.getNumero());
            endereco.setComplemento(dto.getComplemento());

            // 3. Usar o método set para atualizar o usuário

            Usuario usuario = usuarioExistente.get();

            usuario.setEndereco(endereco);

            // 4. Persistir os dados no banco

            return ResponseEntity.ok().body(usuarioRepository.save(usuario));
        }

        // 5. Se usuário não existe, retornar 404
        return ResponseEntity.notFound().build();
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

}
