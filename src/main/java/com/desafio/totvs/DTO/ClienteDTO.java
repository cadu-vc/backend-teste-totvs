package com.desafio.totvs.DTO;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ClienteDTO {

	@SerializedName("id")
	private Integer id;

	@SerializedName("nome")
	private String nome;

	@SerializedName("endereco")
	private String endereco;

	@SerializedName("bairro")
	private String bairro;

	@SerializedName("telefones")
	private List<TelefoneDTO> telefones;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	public ClienteDTO() {
	}

	public ClienteDTO(Integer id, String nome, String endereco, String bairro, List<TelefoneDTO> telefones) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.bairro = bairro;
		this.telefones = telefones;
	}
}