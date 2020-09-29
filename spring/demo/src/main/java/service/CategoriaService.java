package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.entity.Categoria;
import com.example.demo2.repository.CategoriaRepository;

@Service //Regras de Negócio
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getAll(){
		return categoriaRepository.findAll();
	}
}
