package br.com.grs.gerenciadorDeTarefas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grs.gerenciadorDeTarefas.model.dto.TarefaInserirDTO;
import br.com.grs.gerenciadorDeTarefas.model.dto.TarefaListaDTO;
import br.com.grs.gerenciadorDeTarefas.model.dto.TarefaDTO;
import br.com.grs.gerenciadorDeTarefas.model.entity.Tarefa;
import br.com.grs.gerenciadorDeTarefas.repository.TarefaRepository;
import lombok.Getter;

@Service
public class TarefaService {

    @Autowired
    @Getter
    private TarefaRepository tarefaRepository;

    public TarefaDTO salvar(TarefaInserirDTO tarefaInserirDTO){
        Tarefa tarefa = dto2TarefaBuilder(tarefaInserirDTO);
        tarefa = getTarefaRepository().save(tarefa);
        return tarefa2TarefaDtoBuilder(tarefa);
    }
    

    public List<TarefaListaDTO> findAll(){
        return listaDeTarefa2ListaDeTarefaListaDto(tarefaRepository.findAll());
    }

    private Tarefa dto2TarefaBuilder(TarefaInserirDTO tarefaInserirDTO){
        return Tarefa.builder()
                .id(tarefaInserirDTO.getId())
                .nome(tarefaInserirDTO.getNome())
                .descricao(tarefaInserirDTO.getDescricao())
                .data(tarefaInserirDTO.getData())
                .status(tarefaInserirDTO.getStatus())
                .build();
        
    }

    private TarefaDTO tarefa2TarefaDtoBuilder(Tarefa tarefa){
        return TarefaDTO.builder()
                .id(tarefa.getId())
                .nome(tarefa.getNome())
                .descricao(tarefa.getDescricao())
                .data(tarefa.getData())
                .status(tarefa.getStatus())
                .build();
    }
    


    private List<TarefaListaDTO> listaDeTarefa2ListaDeTarefaListaDto(List<Tarefa> tarefas){
        return tarefas.stream().map(tarefa -> new TarefaListaDTO(
            tarefa.getId(),
            tarefa.getNome(),
            tarefa.getDescricao(),
            tarefa.getData(),
            tarefa.getStatus()))
            .collect(Collectors.toList());
            
                
                
    }

    public void deleteById(Long id){
        tarefaRepository.deleteById(id);
    }

    public Tarefa procurarPeloId(Long id) throws ObjectNotFoundException{
        return tarefaRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Objeto não encontrado",id));
    }

}