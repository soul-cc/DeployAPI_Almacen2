package com.example.demo.interfaceservicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.usuario;

public interface iusuarioservicio {
	
	public List<usuario> listar();
	
	public Optional<usuario> obtenerPorId(int id);
	
	public usuario grabar(usuario u);
	
	public boolean eliminar(int id);
	
	public Optional<usuario> logeo(String email, String password);
	
}
