package com.taskify.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskify.api.model.Usuario;
import com.taskify.api.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            Usuario usuarioObj = usuarioExistente.get();

            usuarioObj.setNome(usuario.getNome());
            usuarioObj.setSobrenome(usuario.getSobrenome());
            usuarioObj.setEmail(usuario.getEmail());
            usuarioObj.setSenha(usuario.getSenha());
            usuarioObj.setGenero(usuario.getGenero());

            return usuarioRepository.save(usuarioObj);
        }

        return null;
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(
        @PageableDefault(size = 2, page = 1, sort = "email", direction = Direction.DESC) Pageable paginacao) {
        return usuarioRepository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obterUsuarioPeloId(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuarioPeloId(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
    }

    @GetMapping("/email/{email}")
    public Optional<Usuario> obterUsuarioPeloEmail(@PathVariable("email") String email) {
        return usuarioRepository.findByEmail(email);
    }

    @GetMapping("/nome/{nome}")
    public Optional<List<Usuario>> obterUsuarioPeloNome(@PathVariable("nome") String nome) {
        return usuarioRepository.findByNome(nome);
    }

    // Ponto de injeção
    @Autowired
    private UsuarioRepository usuarioRepository;

}
