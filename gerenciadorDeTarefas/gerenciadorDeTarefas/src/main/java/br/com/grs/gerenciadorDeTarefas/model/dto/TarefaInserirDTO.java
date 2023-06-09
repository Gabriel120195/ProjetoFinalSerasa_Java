package br.com.grs.gerenciadorDeTarefas.model.dto;


import java.time.LocalDate;

import br.com.grs.gerenciadorDeTarefas.model.enums.StatusTarefa;
import lombok.Data;


@Data
public class TarefaInserirDTO {

    private Long id;

    private String nome;

    private String descricao;

    private LocalDate data;

    private StatusTarefa status;

}