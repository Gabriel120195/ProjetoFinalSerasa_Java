package br.com.grs.gerenciadorDeTarefas.controller;


import java.util.Objects;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.grs.gerenciadorDeTarefas.model.dto.TarefaInserirDTO;
import br.com.grs.gerenciadorDeTarefas.model.dto.TarefaDTO;
import br.com.grs.gerenciadorDeTarefas.model.entity.Tarefa;
import br.com.grs.gerenciadorDeTarefas.service.TarefaService;
import jakarta.websocket.server.PathParam;
import lombok.Getter;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired @Getter
    private TarefaService tarefaService;


    @GetMapping("/form-tarefa")
    public String carregarPaginaDeTarefa(@PathParam("id") Long id, Model model)throws ObjectNotFoundException{
        if (Objects.nonNull(id)) {
            Tarefa tarefa = tarefaService.procurarPeloId(id);
            model.addAttribute("tarefa", tarefa);
            return "nova-tarefa";
        }
        model.addAttribute("tarefa", new TarefaInserirDTO());
        return "nova-tarefa";
    }


    @PostMapping
    public String salvar(@ModelAttribute("tarefa") TarefaInserirDTO tarefa, Errors errors)throws Exception{
        if (!errors.hasErrors()) {
            TarefaDTO tarefaDTO = getTarefaService().salvar(tarefa);
            tarefa.setId(tarefaDTO.getId());
            return "redirect:/tarefas";
        }
            return "redirect:/tarefas";
    }

    @GetMapping
    public String listarTodasTarefas(Model model){
        model.addAttribute("tarefas", tarefaService.findAll());
        return "lista-tarefas";
    }

    @GetMapping("/remover")
    public String apagar(@PathParam("id") Long id){
        tarefaService.deleteById(id);
        return "redirect:/tarefas";
    }
}