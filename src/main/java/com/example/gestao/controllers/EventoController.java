package com.example.gestao.controllers;

import com.example.gestao.entities.Evento;
import com.example.gestao.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/all")
    public ResponseEntity<List<Evento>> findAll() {
        List<Evento> lista = eventoService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Evento> findById(@PathVariable Long id) {
        Evento obj = eventoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/new")
    public ResponseEntity<Evento> create(@RequestBody Evento evento) {
        Evento novoEvento = eventoService.save(evento);
        return ResponseEntity.ok().body(novoEvento);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Evento> update(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
        Evento evento = eventoService.update(id, eventoAtualizado);
        return ResponseEntity.ok().body(evento);
    }

    @DeleteMapping("/dell/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

