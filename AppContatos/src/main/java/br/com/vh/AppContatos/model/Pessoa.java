package br.com.vh.AppContatos.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private String cep;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String uf;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Contato> contatos;
 
	public Pessoa(Long id, String name, String endereco, String cep, String cidade, String uf) {
		this.id = id;
		this.name = name;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	public Pessoa() {
		
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Pessoa [id="  + id       + 
				", name="     + name     + 
				", endereco=" + endereco + 
				", cep="      + cep      + 
				", cidade="   + cidade   + 
				", uf="       + uf       + "]";
	}


}
