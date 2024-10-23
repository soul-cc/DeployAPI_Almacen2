package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.requerimiento;

@Repository
public interface irequerimiento extends CrudRepository<requerimiento, Integer>{
	
}
