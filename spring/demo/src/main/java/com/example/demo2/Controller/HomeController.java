package com.example.demo2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.entity.Categoria;
import com.example.demo2.repository.CategoriaRepository;

@RestController
public class HomeController {
	@Autowired
	private CategoriaRepository repository;
	@GetMapping("/")
	public String home() {
		return "<h1>Hello World</h1>";
	}
	
	@GetMapping("/contatos/{nome}")
	public String contatos(@PathVariable("nome") String nome) {
		return "Contatos: "+nome;
	}
	
	@GetMapping("/categorias")
	public List<Categoria> teste(){
		return repository.findAll();
	}
	
}
