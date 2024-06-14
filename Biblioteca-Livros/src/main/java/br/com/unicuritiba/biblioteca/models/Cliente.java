package br.com.unicuritiba.biblioteca.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String teste;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTestel() {
		return teste;
	}
	public void setTeste(String teste) {
		this.teste = teste;
	}
	
}
