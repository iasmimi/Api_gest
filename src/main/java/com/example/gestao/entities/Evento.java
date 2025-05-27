package com.example.gestao.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Date data;
    private String local;
    private int vagas;

    @ManyToMany(mappedBy = "eventos")
    private Set<Participantes> participantes = new HashSet<>();

    // --- ADICIONE ESTE CONSTRUTOR AQUI ---
    public Evento() {
        // Construtor padrão exigido pelo JPA/Hibernate
    }

    public Evento(Long id, String nome, String descricao, Date data, String local, int vagas, Set<Participantes> participantes) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
        this.local = local;
        this.vagas = vagas;
        this.participantes = participantes;
    }

    // --- GETTERS E SETTERS ---
    // (Mantenha todos os seus getters e setters existentes)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public Set<Participantes> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participantes> participantes) {
        this.participantes = participantes;
    }
}