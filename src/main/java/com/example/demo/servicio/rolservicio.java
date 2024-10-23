package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceservicio.irolservicio;
import com.example.demo.modelo.rol;
import com.example.demo.repository.irol;

@Service
public class rolservicio implements irolservicio{
	@Autowired
	private irol data;

	@Override
	public List<rol> listar() {
		return (List<rol>)data.findAll();
	}

	@Override
	public Optional<rol> obtenerPorId(int id) {
		return data.findById(id);
	}

	@Override
	public rol grabar(rol r) {
		return data.save(r);
	}

	@Override
	public boolean eliminar(int id) {
		try {
			data.deleteById(id); //este metodo no devuelve nada (void) y si falla arroja excepción
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	
}
