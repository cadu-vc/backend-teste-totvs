package com.desafio.totvs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.totvs.DTO.ClienteDTO;
import com.desafio.totvs.entity.Cliente;
import com.desafio.totvs.service.ClienteService;
/**
 * RestController que faz a comunicação com o front (API)
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	/**
	 * Endpoint que recupera o Cliente baseado no id
	 * @param id
	 * @return Cliente recuperado com parametro id
	 * @author Cadu
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable(value = "id") Long id) {
		Cliente cliente = service.findById(id);
		if (cliente == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body("Não foi possivel encontrar o cliente correspondente ao id " + id);
		return ResponseEntity.ok(cliente);
	}
	/**
	 * Endpoint que recupera todos os clientes do db
	 * @return Lista de Clientes salvos no db
	 * @author Cadu
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok(clientes);
	}
	/**
	 * Endpoint que cria um novo Cliente
	 * @param cliente Request de Cliente para salvar
	 * @return HTTP Status
	 * @author Cadu
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody ClienteDTO cliente) {
		try {
			if (service.validaTelefone(cliente.getTelefones())) {
				service.save(Cliente.ClienteDTOtoCliente(cliente));
				return ResponseEntity.ok(HttpStatus.OK);
			} else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Telefone inválido.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getCause());

		}
	}
}
