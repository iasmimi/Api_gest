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
    private String vagas;

    @ManyToMany(mappedBy = "eventos")
    private Set<Participantes> participantes = new HashSet<>();

    public Evento() {
    }

    public Evento(Long id, String nome, String descricao, String local, Date data, String vagas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public String getVagas() {
        return vagas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setVagas(String vagas) {
        this.vagas = vagas;
    }
}
