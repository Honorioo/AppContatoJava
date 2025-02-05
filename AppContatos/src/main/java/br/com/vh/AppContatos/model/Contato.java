package br.com.vh.AppContatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String numberTel;
	
	public Contato(Long id, String name, String numberTel) {
		this.id = id;
		this.name = name;
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
		
	
}
