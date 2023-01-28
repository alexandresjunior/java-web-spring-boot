package com.agenda.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAgendamento;

    private LocalDate data;
    private LocalTime hora;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "idServico")
    private Servico servico;
    
}
