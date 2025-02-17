package br.com.vh.AppContatos.model;

import br.com.vh.AppContatos.enumTipoContato.TipoContato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    private String nome;

    @Column(nullable = false)
    private String contato;

    @Enumerated(EnumType.STRING)
    private TipoContato tipoContato;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
    
    public Contato(Long id, String nome, TipoContato tipoContato, String contato, Pessoa pessoa) { 
        this.id = id;
        this.nome = nome;
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Contato() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
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
               ", name=" + nome + 
               ", tipoContato=" + tipoContato + 
               ", contato=" + contato + 
               ", usuario=" + pessoa + "]";
    }
    
    
}
