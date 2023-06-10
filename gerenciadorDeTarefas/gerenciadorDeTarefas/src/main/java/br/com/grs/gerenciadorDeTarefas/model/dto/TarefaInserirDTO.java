package br.com.grs.gerenciadorDeTarefas.model.dto;


import java.time.LocalDate;

import br.com.grs.gerenciadorDeTarefas.model.enums.StatusTarefa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class TarefaInserirDTO {

    private Long id;

    @NotBlank(message = "Nome não pode ser vazio")
    @Size(min = 5, max = 100, message = "Nome deve ter no mínimo 5 e no máximo 100 caracteres")
    private String nome;

    @NotBlank(message = "Descrição não pode ser vazio")
    @Size(min = 5, max = 500, message = "Descrição deve ter no mínimo 5 e no máximo 500 caracteres")
    private String descricao;

    private LocalDate data;

    private StatusTarefa status;

}