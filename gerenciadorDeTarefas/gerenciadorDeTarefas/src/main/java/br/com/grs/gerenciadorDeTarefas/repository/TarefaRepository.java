package br.com.grs.gerenciadorDeTarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.grs.gerenciadorDeTarefas.model.entity.Tarefa;


public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
    
}