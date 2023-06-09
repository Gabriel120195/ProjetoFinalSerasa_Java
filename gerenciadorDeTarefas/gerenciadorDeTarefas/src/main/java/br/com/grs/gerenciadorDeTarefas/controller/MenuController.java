package br.com.grs.gerenciadorDeTarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @GetMapping("/pagina-menu")
    public String carregaHome(){
        return "menu";
    }

    
}