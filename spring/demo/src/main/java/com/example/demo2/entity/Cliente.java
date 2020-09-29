package com.example.demo2.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity //clientes
@Table(name="cliente") //nesse caso é opcional
@Getter
@Setter
public class Cliente {

	@Id  //define a chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // estrategia para entender como funciona a tabela
	private Integer id;
	
	private String nome;
	
	private String cpf;
	
	private String telefone;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
