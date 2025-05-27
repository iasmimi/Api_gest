package com.example.gestao.service;

import com.example.gestao.entities.Evento;
import com.example.gestao.entities.Participantes;
import com.example.gestao.repostorios.EventoRepository;
import com.example.gestao.repostorios.ParticipantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ParticipantesService {

    @Autowired
    private ParticipantesRepository participantesRepository;

    @Autowired
    private EventoRepository eventoRepository;

    // ✅ Cadastro de participante
    public Participantes cadastrarParticipante(Participantes participante) {
        return participantesRepository.save(participante);
    }

    // ✅ Inscrição em evento (com verificação de vagas)
    public String inscreverEmEvento(Long participanteId, Long eventoId) {
        Participantes participante = participantesRepository.findById(participanteId)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado. ID: " + participanteId));

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado. ID: " + eventoId));

        if (evento.getVagas() <= 0) {
            return "Não há vagas disponíveis para este evento.";
        }

        if (participante.getEventos().contains(evento)) {
            return "Participante já está inscrito neste evento.";
        }

        participante.getEventos().add(evento);
        evento.setVagas(evento.getVagas() - 1); // Decrementa a vaga

        participantesRepository.save(participante);
        eventoRepository.save(evento);

        return "Inscrição realizada com sucesso!";
    }

    // Cancelamento de inscrição
    public String cancelarInscricao(Long participanteId, Long eventoId) {
        Participantes participante = participantesRepository.findById(participanteId)
                .orElseThrow(() -> new RuntimeException("Participante não encontrado. ID: " + participanteId));

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado. ID: " + eventoId));

        if (!participante.getEventos().contains(evento)) {
            return "Participante não está inscrito neste evento.";
        }

        participante.getEventos().remove(evento);
        evento.setVagas(evento.getVagas() + 1); // Libera a vaga

        participantesRepository.save(participante);
        eventoRepository.save(evento);

        return "Inscrição cancelada com sucesso!";
    }

    // ✅ Listar participantes de um evento
    public List<Participantes> listarParticipantesPorEvento(Long eventoId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado. ID: " + eventoId));

        List<Participantes> participantesDoEvento = new ArrayList<>();

        List<Participantes> todosParticipantes = participantesRepository.findAll();
        for (Participantes participante : todosParticipantes) {
            if (participante.getEventos().contains(evento)) {
                participantesDoEvento.add(participante);
            }
        }

        return participantesDoEvento;
    }
}