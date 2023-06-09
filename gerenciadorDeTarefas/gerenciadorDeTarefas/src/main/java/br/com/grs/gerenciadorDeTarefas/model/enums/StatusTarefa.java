package br.com.grs.gerenciadorDeTarefas.model.enums;

import lombok.Getter;


public enum StatusTarefa {

    PENDENTE("Pendente"),

    EmPROGRESSO("Em Progresso"),

    CONCLUIDA("Concluida");
    

    @Getter
    private String descricao;

    StatusTarefa(String descricao) {
        this.descricao = descricao;
    }
}