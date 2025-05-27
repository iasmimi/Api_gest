package com.example.gestao.controllers;

import com.example.gestao.entities.Participantes;
import com.example.gestao.service.ParticipantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ParticipanteController {

    @Autowired
    private ParticipantesService participantesService;


    // Listar participantes de um evento
    @GetMapping("/evento/{eventoId}/participantes")
    public ResponseEntity<List<Participantes>> listarParticipantesPorEvento(@PathVariable Long eventoId) {
        List<Participantes> lista = participantesService.listarParticipantesPorEvento(eventoId);
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping("/new/participante")
    public ResponseEntity<Participantes> cadastrarParticipante(@RequestBody Participantes participantes) {
        Participantes novoParticipante = participantesService.cadastrarParticipante(participantes);
        return ResponseEntity.ok().body(novoParticipante);
    }

    @PostMapping("/inscrever")
    public ResponseEntity<String> inscreverEmEvento(@RequestBody Map<String, Long> params) {
        String resposta = participantesService.inscreverEmEvento(params.get("participanteId"), params.get("eventoId"));
        return ResponseEntity.ok().body(resposta);
    }

    // Cancelar inscrição do participante
    @DeleteMapping("/cancelar")
    public ResponseEntity<String> cancelarInscricao(
            @RequestParam Long participanteId,
            @RequestParam Long eventoId) {

        String resposta = participantesService.cancelarInscricao(participanteId, eventoId);
        return ResponseEntity.ok().body(resposta);
    }


}
