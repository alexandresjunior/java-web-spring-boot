package com.agenda.app.controller;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agenda.app.model.Usuario;
import com.agenda.app.repository.UsuarioRepository;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public ResponseEntity<Object> fazerLogin(@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());

        if (Objects.nonNull(usuarioBD) && usuarioBD.get().getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioBD.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email/senha inválidos!");
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

}
