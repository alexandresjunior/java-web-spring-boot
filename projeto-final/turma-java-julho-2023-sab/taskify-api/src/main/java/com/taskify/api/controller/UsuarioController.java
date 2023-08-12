package com.taskify.api.controller;

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
    public Usuario cadastrarNovoUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public Page<Usuario> listarUsuarios(
            @PageableDefault(size = 10, page = 0, sort = "nome", direction = Direction.DESC) Pageable paginacao) {
        return usuarioRepository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> buscarUsuarioPeloId(@PathVariable("id") Long id) {
        return usuarioRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(
            @PathVariable("id") Long id,
            @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuarioExistente.get().setNome(usuario.getNome());
            usuarioExistente.get().setSobrenome(usuario.getSobrenome());
            usuarioExistente.get().setEmail(usuario.getEmail());
            usuarioExistente.get().setSenha(usuario.getSenha());
            usuarioExistente.get().setGenero(usuario.getGenero());

            return usuarioRepository.save(usuarioExistente.get());
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletarUsuarioPeloId(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);

        return "Usuário deletado com sucesso!";
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

    @Autowired
    private UsuarioRepository usuarioRepository;

}
