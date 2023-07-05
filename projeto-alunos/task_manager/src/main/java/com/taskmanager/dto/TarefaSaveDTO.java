package com.taskmanager.dto;

import com.taskmanager.helpers.PrioridadeTarefa;
import com.taskmanager.helpers.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaSaveDTO {
    private Long id;
    private String nome;
    private String descricao;
    private PrioridadeTarefa prioridade;
    private StatusTarefa status;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
}