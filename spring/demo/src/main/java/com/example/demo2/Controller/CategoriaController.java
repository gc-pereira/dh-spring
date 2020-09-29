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

import com.example.demo2.entity.Categoria;
import com.example.demo2.repository.CategoriaRepository;

import javassist.NotFoundException;

@RestController
public class CategoriaController {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping("/categorias")
	public ResponseEntity<List<Categoria>> index() {
		List<Categoria> categorias = categoriaRepository.findAll();
		return ResponseEntity.ok(categorias);
	}
	
	@GetMapping("/categorias/{id}")
	public ResponseEntity<Categoria> show(@PathVariable(value="id") Integer id) throws NotFoundException {
		Optional<Categoria> entity = categoriaRepository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Categoria não encontrado");
		}
		Categoria categoria = entity.get();
		return ResponseEntity.ok(categoria);
	}
	
	@PostMapping("/categorias")
	@Transactional
	public ResponseEntity<Categoria> store(@RequestBody Categoria categoria) {
		Categoria novaCategoria = categoriaRepository.save(categoria);
		return ResponseEntity.ok(novaCategoria);
	}
	
	@PutMapping("/categorias/{id}")
	@Transactional
	public ResponseEntity<Categoria> update(@PathVariable(value="id") Integer id, @RequestBody Categoria categoria) throws NotFoundException {
		Optional<Categoria> entity = categoriaRepository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Cliente não encontrado");
		}
		categoria.setId(id);
		Categoria categoriaAtualizada = categoriaRepository.save(categoria);
		return ResponseEntity.ok(categoriaAtualizada);
	}
	
	@DeleteMapping("/categorias/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable(value="id") Integer id) throws NotFoundException {
		Optional<Categoria> entity = categoriaRepository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Cliente não encontrado");
		}
		categoriaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
