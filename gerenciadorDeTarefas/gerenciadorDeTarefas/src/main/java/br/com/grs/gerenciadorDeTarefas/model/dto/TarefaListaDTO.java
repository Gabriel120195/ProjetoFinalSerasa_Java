package br.com.grs.gerenciadorDeTarefas.model.dto;

import java.time.LocalDate;

import br.com.grs.gerenciadorDeTarefas.model.enums.StatusTarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TarefaListaDTO {


    private Long id;

    private String nome;

    private String descricao;

    private LocalDate data;

    private StatusTarefa status;
    
}