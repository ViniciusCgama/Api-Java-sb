package com.company.apiJava.tarefas.facade;

import com.company.apiJava.tarefas.dto.Dto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Facade {
    private static final Map<Long, Dto> tarefas = new HashMap<>();

    public Dto criar(Dto tarefaDto) {
        Long proximoId = tarefas.keySet().size() + 1L;
        tarefaDto.setId(proximoId);
        tarefas.put(proximoId, tarefaDto);
        return tarefaDto;
    }

    public Dto atualizar(Dto tarefaDto, Long tarefaId) {
        tarefas.put(tarefaId, tarefaDto);
        return tarefaDto;
    }

    public Dto getById (Long tarefaId) {
        return tarefas.get(tarefaId);
    }

    public List<Dto> getAll() {
        return new ArrayList<>(tarefas.values());
    }

    public String deletar (Long tarefaId) {
        tarefas.remove(tarefaId);
            return "Deletado";
    }
}
