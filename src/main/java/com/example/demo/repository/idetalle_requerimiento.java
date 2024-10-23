package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.detalle_requerimiento;
import com.example.demo.modelo.requerimiento;

import java.util.List;

@Repository
public interface idetalle_requerimiento extends CrudRepository<detalle_requerimiento, Integer>{
	List<detalle_requerimiento> findByRequerimiento(requerimiento requerimiento);
}
