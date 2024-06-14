package br.com.unicuritiba.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.biblioteca.models.Cliente;

public interface ClienteRepository extends 
   	JpaRepository<Cliente, Long>{

}
