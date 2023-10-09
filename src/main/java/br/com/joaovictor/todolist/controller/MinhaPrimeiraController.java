package br.com.joaovictor.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraController {

    @GetMapping("/primeiroMetodo")
    public String primeiroMensagem() {
        return "Olá Mundo!";
    }
}
