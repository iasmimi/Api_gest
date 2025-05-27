package com.example.gestao.repostorios;

import com.example.gestao.entities.Participantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantesRepository extends JpaRepository<Participantes,Long> {

}