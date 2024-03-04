package com.desafio.totvs.DTO;

import com.google.gson.annotations.SerializedName;

public class TelefoneDTO {

	@SerializedName("numero")
	private String numero;

	public TelefoneDTO() {
	}

	public TelefoneDTO(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}