package br.com.vh.AppContatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	@Column(nullable = false)
	private String contact;
	
	@OneToMany
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;
	
	public Contato(Long id, String name, Integer typeCtt, String contact, Usuario usuario) {
		this.id = id;
		this.name = name;
		this.typeCtt = typeCtt;
		this.contact = contact;
		this.usuario = usuario;
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
		return contact;
	}

	public void setNumberTel(String contact) {
		this.contact = contact;
	}

	public Integer getTypeCtt() {
		return typeCtt;
	}

	public void setTypeCtt(Integer typeCtt) {
		this.typeCtt = typeCtt;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + 
			   ", name="      + name + 
			   ", typeCtt="   + typeCtt + 
			   ", contact="   + contact + 
			   ", usuario="   + usuario + "]";
	}
	
	
	
}
