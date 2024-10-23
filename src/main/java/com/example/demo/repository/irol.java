package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.rol;

@Repository
public interface irol extends CrudRepository<rol, Integer>{
	
}
