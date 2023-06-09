package br.com.grs.gerenciadorDeTarefas.model.dto;

import java.time.LocalDate;

import br.com.grs.gerenciadorDeTarefas.model.enums.StatusTarefa;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TarefaDTO {

    private Long id;

    private String nome;

    private String descricao;

    private LocalDate data;

    private StatusTarefa status;
}