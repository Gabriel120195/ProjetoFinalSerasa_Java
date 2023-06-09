package br.com.grs.gerenciadorDeTarefas.model.entity;


import java.time.LocalDate;

import br.com.grs.gerenciadorDeTarefas.model.enums.StatusTarefa;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Tarefa {


    @Getter @Setter
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String descricao;

    @Getter @Setter
    private LocalDate data;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;
}