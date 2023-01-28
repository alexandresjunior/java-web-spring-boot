package com.agenda.app.model;

import jakarta.persistence.Column;
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
@Entity(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nome", nullable = false, length = 45)
    private String nome;

    @Column(name = "sobrenome", nullable = false)
    private String sobrenome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "senha", nullable = false, length = 45)
    private String senha;

    @OneToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipoUsuario;

}
