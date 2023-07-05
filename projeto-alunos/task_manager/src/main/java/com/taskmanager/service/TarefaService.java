package com.taskmanager.service;

import com.taskmanager.dto.TarefaSaveDTO;
import com.taskmanager.mapper.TarefaSaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.taskmanager.dto.TarefaDTO;
import com.taskmanager.mapper.TarefaMapper;
import com.taskmanager.model.Tarefa;
import com.taskmanager.model.Usuario;
import com.taskmanager.repository.TarefaRepository;

@Service
public class TarefaService {
  public Page<TarefaDTO> listarTarefas(Usuario usuario, Pageable pageable) {
    Page<Tarefa> tarefas = tarefaRepository.findByUsuario(usuario, pageable);
    return tarefas.map(TarefaMapper::toDTO);
  }

  public TarefaDTO editarTarefa(Long id, TarefaDTO tarefaDTO, Usuario usuarioLogado) {
    Tarefa tarefaExistente = tarefaRepository.findById(id).orElse(null);

    if (tarefaExistente == null) {
      return null;
    } else if (!tarefaExistente.getUsuario().equals(usuarioLogado)) {
      return null;
    }

    Tarefa tarefa = TarefaMapper.toEntity(tarefaDTO);
    tarefa.setId(id);
    tarefa.setUsuario(usuarioLogado);

    Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);
    return TarefaMapper.toDTO(tarefaAtualizada);
  }

  public TarefaDTO listarTarefaPorId(Long id, Usuario usuarioLogado) {
    Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

    if (tarefa == null) {
      return null;
    } else if (!tarefa.getUsuario().equals(usuarioLogado)) {
      return null;
    }

    return TarefaMapper.toDTO(tarefa);
  }

  public void deletarTarefa(Long id, Usuario usuarioLogado) {
    Tarefa tarefa = tarefaRepository.findById(id).orElse(null);

    if (tarefa != null && tarefa.getUsuario().equals(usuarioLogado)) {
      tarefaRepository.delete(tarefa);
    }
  }

  public TarefaDTO criarTarefa(TarefaSaveDTO tarefaSaveDTO, Usuario usuarioLogado) {

    Tarefa tarefa = TarefaSaveMapper.toEntity(tarefaSaveDTO, usuarioLogado);

    Tarefa novaTarefa = tarefaRepository.save(tarefa);
    return TarefaMapper.toDTO(novaTarefa);
  }

  private final TarefaRepository tarefaRepository;

  @Autowired
  public TarefaService(TarefaRepository tarefaRepository) {
    this.tarefaRepository = tarefaRepository;
  }

}
