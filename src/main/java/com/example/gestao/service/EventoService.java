package com.example.gestao.service;

import com.example.gestao.entities.Evento;
import com.example.gestao.repostorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    // Buscar todos os eventos
    public List<Evento> findAll() {
        return repository.findAll();
    }

    // Buscar evento por ID
    public Evento findById(Long id) {
        Optional<Evento> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Evento não encontrado. ID: " + id));
    }

    // Salvar um evento novo
    public Evento save(Evento evento) {
        return repository.save(evento);
    }

    // Atualizar um evento existente
    public Evento update(Long id, Evento eventoAtualizado) {
        Evento evento = findById(id);
        evento.setNome(eventoAtualizado.getNome());
        evento.setDescricao(eventoAtualizado.getDescricao());
        evento.setData(eventoAtualizado.getData());
        evento.setLocal(eventoAtualizado.getLocal());
        evento.setVagas(eventoAtualizado.getVagas());
        return repository.save(evento);
    }

    // Deletar evento por ID
    public void delete(Long id) {
        Evento evento = findById(id);
        repository.delete(evento);
    }

}
