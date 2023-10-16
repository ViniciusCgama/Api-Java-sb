package com.company.apiJava.tarefas.api;

import com.company.apiJava.tarefas.dto.Dto;
import com.company.apiJava.tarefas.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class Api {
    @Autowired
    private Facade facade;
    @PostMapping
    @ResponseBody
    public Dto criar(@RequestBody Dto tarefaDto){
        return facade.criar(tarefaDto);
    }

    @PutMapping("/{tarefaId}")
    @ResponseBody
    public Dto atualizar(@PathVariable("tarefaId") Long tarefaId, @RequestBody Dto tarefaDto)
    {
        return facade.atualizar(tarefaDto, tarefaId);
    }

    @GetMapping
    @ResponseBody
    public List<Dto> getAll(){
        return facade.getAll();
    }

    @DeleteMapping("/{tarefaId}")

    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId) {
        return facade.deletar(tarefaId);
    }

    }

