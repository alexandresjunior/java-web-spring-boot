package com.taskmanager.mapper;

import com.taskmanager.dto.TarefaDTO;
import com.taskmanager.dto.UsuarioDTO;
import com.taskmanager.model.Tarefa;
import com.taskmanager.model.Usuario;

public class TarefaMapper {

  public static TarefaDTO toDTO(Tarefa tarefa) {
    UsuarioDTO usuarioDTO = new UsuarioDTO(
        tarefa.getUsuario().getNome(),
        tarefa.getUsuario().getSobrenome(),
        tarefa.getUsuario().getEmail(),
        null // O token pode ser definido de acordo com a necessidade
    );

    return new TarefaDTO(
        tarefa.getId(),
        tarefa.getNome(),
        tarefa.getDescricao(),
        tarefa.getPrioridade(),
        tarefa.getStatus(),
        tarefa.getDataInicio(),
        tarefa.getDataFinal(),
        usuarioDTO);
  }

  public static Tarefa toEntity(TarefaDTO tarefaDTO) {
    Tarefa tarefa = new Tarefa();
    tarefa.setId(tarefaDTO.getId());
    tarefa.setNome(tarefaDTO.getNome());
    tarefa.setDescricao(tarefaDTO.getDescricao());
    tarefa.setPrioridade(tarefaDTO.getPrioridade());
    tarefa.setStatus(tarefaDTO.getStatus());
    tarefa.setDataInicio(tarefaDTO.getDataInicio());
    tarefa.setDataFinal(tarefaDTO.getDataFinal());

    Usuario usuario = new Usuario();
    usuario.setNome(tarefaDTO.getUsuario().getNome());
    usuario.setSobrenome(tarefaDTO.getUsuario().getSobrenome());
    usuario.setEmail(tarefaDTO.getUsuario().getEmail());
    tarefa.setUsuario(usuario);

    return tarefa;
  }
}
