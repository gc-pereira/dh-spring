package com.example.demo2.Controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Cliente;
import com.example.demo2.repository.ClienteRepository;

import javassist.NotFoundException;


@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> index() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> show(@PathVariable(value="id") Integer id) throws NotFoundException {
		Optional<Cliente> entity = clienteRepository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Cliente não encontrado");
		}
		Cliente cliente = entity.get();
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/clientes")
	@Transactional
	public ResponseEntity<Cliente> store(@RequestBody Cliente cliente) {
		Cliente novoCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(novoCliente);
	}
	
	@PutMapping("/clientes/{id}")
	@Transactional
	public ResponseEntity<Cliente> update(@PathVariable(value="id") Integer id, @RequestBody Cliente cliente) throws NotFoundException {
		Optional<Cliente> entity = clienteRepository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Cliente não encontrado");
		}
		cliente.setId(id);
		Cliente clienteAtualizado = clienteRepository.save(cliente);
		return ResponseEntity.ok(clienteAtualizado);
	}
	
	@DeleteMapping("/clientes/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable(value="id") Integer id) throws NotFoundException {
		Optional<Cliente> entity = clienteRepository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Cliente não encontrado");
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
