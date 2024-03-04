package com.desafio.totvs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.totvs.DTO.TelefoneDTO;
import com.desafio.totvs.entity.Cliente;
import com.desafio.totvs.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	/**
	 * Salva cliente no db
	 * 
	 * @param cliente Cliente a ser salvo
	 * @return Cliente que foi salvo
	 * @author Cadu
	 */
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	/**
	 * Busca um cliente por id
	 * @param id Id do cliente que será buscado
	 * @return Cliente que foi buscado 
	 * @author Cadu
	 */
	public Cliente findById(long id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * Busca todos os clientes do db
	 * @return Lista com todos os clientes do db
	 * @author Cadu
	 */
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	/**
	 * Valida telefones no padrão estabelecido
	 * @param telefones
	 * @return Verdadeiro se na lista não tem telefone inválido
	 * @author Cadu
	 */
	public Boolean validaTelefone(List<TelefoneDTO> telefones) {
		if (!telefones.isEmpty()) {
			List<TelefoneDTO> telefonesValidados = new ArrayList<TelefoneDTO>();
			telefones.forEach(telefone -> {
				if (telefone.getNumero() != null && validarTelefone(telefone.getNumero().toString())) {
					telefonesValidados.add(telefone);
				}
			});
			if (telefonesValidados.isEmpty()) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	/**
	 * Valida telefone que tenha 13 digitos
	 * @param telefone
	 * @return Verdadeiro se o telefone é valido
	 * @author Cadu
	 */
	public static boolean validarTelefone(String telefone) {
		return telefone != null && telefone.matches("\\d{13}");
	}

}
