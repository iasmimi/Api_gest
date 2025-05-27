package com.example.gestao.entities;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_participantes")
public class Participantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    @ManyToMany
    @JoinTable(
            name = "tb_participante_evento", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "participante_id"),
            inverseJoinColumns = @JoinColumn(name = "evento_id")
    )
    private Set<Evento> eventos = new HashSet<>();


    public Participantes() {
    }

    public Participantes(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public Set<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Set<Evento> eventos) {
        this.eventos = eventos;
    }
}
