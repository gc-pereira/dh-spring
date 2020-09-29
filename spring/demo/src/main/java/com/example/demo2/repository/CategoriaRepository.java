package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
