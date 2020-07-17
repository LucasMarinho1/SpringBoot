package com.example.prova.modal;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class usuario {

	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private String email;
	
	@OneToMany
	private List<digito> digito;

	public List<digito> getDigito() {
		return digito;
	}
	public void setDigito(List<digito> digito) {
		this.digito = digito;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
