package com.desafio.totvs.entity;

import java.util.ArrayList;
import java.util.List;

import com.desafio.totvs.DTO.ClienteDTO;
import com.desafio.totvs.DTO.TelefoneDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "tx_nome", length = 10, unique = true)
	private String nome;

	@Column(name = "tx_endereco")
	private String endereco;

	@Column(name = "tx_bairro")
	private String bairro;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Telefone> telefones;

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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	// Converte lista de clientesDTO para lista de clientes
	public static Cliente ClienteDTOtoCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteDTO.getId());
		cliente.setNome(clienteDTO.getNome());
		cliente.setEndereco(clienteDTO.getEndereco());
		cliente.setBairro(clienteDTO.getBairro());

		// Converte lista de telefones
		List<Telefone> telefones = new ArrayList<>();
		if (clienteDTO.getTelefones() != null) {
			for (TelefoneDTO telefoneDTO : clienteDTO.getTelefones()) {
				Telefone telefone = new Telefone();
				telefone.setNumero(telefoneDTO.getNumero());
				telefones.add(telefone);
			}
		}
		cliente.setTelefones(telefones);

		return cliente;
	}

}
