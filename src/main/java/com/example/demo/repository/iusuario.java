package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.usuario;
import java.util.Optional;


@Repository
public interface iusuario extends CrudRepository<usuario, Integer>{
	Optional<usuario> findByEmail(String email);
}
