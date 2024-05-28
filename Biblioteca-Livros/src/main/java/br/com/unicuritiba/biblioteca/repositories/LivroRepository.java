package br.com.unicuritiba.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unicuritiba.biblioteca.models.Livro;

public interface LivroRepository extends
	JpaRepository<Livro, Long>{
	
}
