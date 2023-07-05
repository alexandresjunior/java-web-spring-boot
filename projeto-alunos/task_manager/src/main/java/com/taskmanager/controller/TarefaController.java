package com.taskmanager.controller;

import com.taskmanager.dto.TarefaSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.dto.TarefaDTO;
import com.taskmanager.model.Usuario;
import com.taskmanager.repository.UsuarioRepository;
import com.taskmanager.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/tarefas", produces = "application/json")
public class TarefaController {

  @GetMapping
  public ResponseEntity<Page<TarefaDTO>> listarTarefas(
      @PageableDefault(size = 10, page = 0, sort = { "nome" }) Pageable pageable) {
    Usuario usuario = getUsuarioLogado();

    Page<TarefaDTO> tarefasDTOs = tarefaService.listarTarefas(usuario, pageable);

    return ResponseEntity.status(HttpStatus.OK).body(tarefasDTOs);
  }

  @PostMapping
  public ResponseEntity<TarefaDTO> criarTarefa(@Valid @RequestBody TarefaSaveDTO tarefaSaveDTO) {
    Usuario usuarioLogado = getUsuarioLogado();

    TarefaDTO novaTarefaDTO = tarefaService.criarTarefa(tarefaSaveDTO, usuarioLogado);

    if (novaTarefaDTO == null) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefaDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TarefaDTO> editarTarefa(@PathVariable("id") Long id, @Valid @RequestBody TarefaDTO tarefaDTO) {
    Usuario usuarioLogado = getUsuarioLogado();

    TarefaDTO tarefaAtualizadaDTO = tarefaService.editarTarefa(id, tarefaDTO, usuarioLogado);

    if (tarefaAtualizadaDTO == null) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(tarefaAtualizadaDTO);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TarefaDTO> listarTarefaPorId(@PathVariable("id") Long id) {
    Usuario usuarioLogado = getUsuarioLogado();

    TarefaDTO tarefaDTO = tarefaService.listarTarefaPorId(id, usuarioLogado);

    if (tarefaDTO == null) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(tarefaDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarTarefa(@PathVariable("id") Long id) {
    Usuario usuarioLogado = getUsuarioLogado();

    tarefaService.deletarTarefa(id, usuarioLogado);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  private Usuario getUsuarioLogado() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String emailUsuarioLogado = authentication.getName();
    return usuarioRepository.findByEmail(emailUsuarioLogado);
  }

  private final TarefaService tarefaService;
  private final UsuarioRepository usuarioRepository;

  @Autowired
  public TarefaController(TarefaService tarefaService, UsuarioRepository usuarioRepository) {
    this.tarefaService = tarefaService;
    this.usuarioRepository = usuarioRepository;

  }
}
