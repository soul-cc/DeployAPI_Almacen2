package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.producto;

@Repository
public interface iproducto extends CrudRepository<producto, Integer>{

}
