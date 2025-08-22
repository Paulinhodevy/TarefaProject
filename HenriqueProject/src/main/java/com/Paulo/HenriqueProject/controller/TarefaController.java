package com.Paulo.HenriqueProject.controller;


import com.Paulo.HenriqueProject.dto.TarefaDTO;
import com.Paulo.HenriqueProject.model.Tarefa;
import org.springframework.web.bind.annotation.*;
import service.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> listar() {
        return service.listar();
    }

    @PostMapping
    public Tarefa criar(@RequestBody TarefaDTO dto) {
        return service.salvar(dto);
    }

    @PutMapping("/{id}/concluir")
    public Tarefa concluir(@PathVariable Long id) {
        return service.concluir(id);
    }
}