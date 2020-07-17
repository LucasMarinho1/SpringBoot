package com.example.prova.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class digito {

	@Id
	@GeneratedValue
	private int idDig;
	private String paramN;
	private int paramK;
	private int digitoUnico;

	@ManyToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE) // para apagar os digitos vinculados ao usuario em modo cascata.
	private usuario idUsuario;

	public usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdDig() {
		return idDig;
	}

	public void setIdDig(int idDig) {
		this.idDig = idDig;
	}

	public String getParamN() {
		return paramN;
	}

	public void setParamN(String paramN) {
		this.paramN = paramN;
	}

	public int getParamK() {
		return paramK;
	}

	public void setParamK(int paramK) {
		this.paramK = paramK;
	}

	public int getDigitoUnico() {
		return digitoUnico;
	}

	public void setDigitoUnico(int digitoUnico) {
		this.digitoUnico = digitoUnico;
	}

	public int sum(String n) {
		return n.length() == 1 ? Integer.parseInt(n)
				: Integer.parseInt(n.substring(0, 1)) + sum(n.substring(1, n.length()));
	}
	
	public int calDigUnico(String n, int k) {
		n = String.valueOf(k == 0 ? sum(n) : (sum(n) * k));
		return n.length() > 1 ? calDigUnico(n, 0) : Integer.parseInt(n);
	}
}
