package com.example.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
