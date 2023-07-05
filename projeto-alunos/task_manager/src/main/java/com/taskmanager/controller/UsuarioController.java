package com.taskmanager.controller;

import com.taskmanager.model.Usuario;
import com.taskmanager.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/api/usuarios", produces = "application/json")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<Object> salvarUsuario(@RequestBody Usuario usuario) {

        Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);

        if (Objects.isNull(usuarioSalvo)) {
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                    .body("Já existe usuário cadastrado com este e-mail");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @GetMapping
    private ResponseEntity<Object> listarUsuarios(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.listarUsuario(pageable));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Usuario> editarUsuario(@PathVariable("id") long id, @RequestBody Usuario usuario){
        Usuario usuarioEdit = usuarioService.editarUsuario(id, usuario);

        if(Objects.isNull(usuarioEdit)){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(usuarioEdit);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Object> deletarUsuario(@PathVariable("id") long id) {
        Boolean usuarioDeletado = usuarioService.deletarUsuario(id);

        if(usuarioDeletado == false){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso !!");
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> buscarUsuarioId(@PathVariable("id")long id){
        Usuario usuario = usuarioService.buscarUsuarioId(id);

        if(usuario == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

}
