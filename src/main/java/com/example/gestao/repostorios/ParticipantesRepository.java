package com.example.gestao.repostorios;

import com.example.gestao.entities.Participantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantesRepository extends JpaRepository<Participantes,Long> {
}
