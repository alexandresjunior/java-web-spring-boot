package com.taskmanager.mapper;

import com.taskmanager.dto.TarefaDTO;
import com.taskmanager.dto.TarefaSaveDTO;
import com.taskmanager.dto.UsuarioDTO;
import com.taskmanager.model.Tarefa;
import com.taskmanager.model.Usuario;

public class TarefaSaveMapper {

  public static Tarefa toEntity(TarefaSaveDTO tarefaDTO, Usuario usuarioSave) {

    Usuario usuario = usuarioSave;

    Tarefa tarefa = new Tarefa();
    tarefa.setId(tarefaDTO.getId());
    tarefa.setNome(tarefaDTO.getNome());
    tarefa.setDescricao(tarefaDTO.getDescricao());
    tarefa.setPrioridade(tarefaDTO.getPrioridade());
    tarefa.setStatus(tarefaDTO.getStatus());
    tarefa.setDataInicio(tarefaDTO.getDataInicio());
    tarefa.setDataFinal(tarefaDTO.getDataFinal());
    tarefa.setUsuario(usuario);

    return tarefa;
  }
}
