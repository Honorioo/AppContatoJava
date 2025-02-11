package br.com.vh.AppContatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
        
    @Column(nullable = false)
    private Integer typeCtt;
    
    @Column(nullable = true)
    private String numberTel;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = true)
    private Pessoa pessoa; 
    
    public Contato(Long id, String name, Integer typeCtt, String numberTel, Pessoa pessoa) { // Alterado para aceitar Usuario
        this.id = id;
        this.name = name;
        this.typeCtt = typeCtt;
        this.numberTel = numberTel;
    }

    public Contato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberTel() {
        return numberTel;
    }

    public void setNumberTel(String numberTel) {
        this.numberTel = numberTel;
    }

    public Integer getTypeCtt() {
        return typeCtt;
    }

    public void setTypeCtt(Integer typeCtt) {
        this.typeCtt = typeCtt;
    }

    public Pessoa getPessoa() {
        return pessoa; 
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa; 
    }
    
    @Override
    public String toString() {
        return "Contato [id=" + id + 
               ", name=" + name + 
               ", typeCtt=" + typeCtt + 
               ", contact=" + numberTel + 
               ", usuario=" + pessoa + "]";
    }
}
