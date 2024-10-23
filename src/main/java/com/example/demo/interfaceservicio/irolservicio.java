package com.example.demo.interfaceservicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.rol;

public interface irolservicio {

	public List<rol> listar();
	
	public Optional<rol> obtenerPorId(int id);
	
	public rol grabar(rol r);
	
	public boolean eliminar(int id);
	
}
