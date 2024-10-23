package com.example.demo.controllerRest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceservicio.irolservicio;
import com.example.demo.modelo.rol;

@RestController
@RequestMapping("/roles")
public class controllerRol {
	@Autowired
	private irolservicio servicios;
	
	@GetMapping
	public List<rol> listarTodos() {
		List<rol> roles = servicios.listar();
		return roles;
	}
	
	@PostMapping
	public rol insertar(@RequestBody rol r) {
		return servicios.grabar(r);
	}
	
	@GetMapping(path ="/{id}")
	public Optional<rol> obtenerRol(@PathVariable("id") int id) {
		return servicios.obtenerPorId(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public String eliminarRol(@PathVariable("id") int id) {
		boolean ok =  servicios.eliminar(id);
		if (ok) {
			return "Se elimino el rol con id " + id;
		}
		else
		{
			return "id no encontrado";
		}
	}
	
	//parece que esta listo!!
}
