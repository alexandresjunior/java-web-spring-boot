package com.taskify.api.constants;

import lombok.Getter;

@Getter
public enum Prioridade {
    ALTA(1),
    MEDIA(2),
    BAIXA(3);

    private final int valor;

    Prioridade(int valor) {
        this.valor = valor;
    }
}
