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

import com.example.demo.interfaceservicio.irequerimientoservicio;
import com.example.demo.modelo.requerimiento;

@RestController
@RequestMapping("/requerimientos")
public class controllerRequerimiento {
	@Autowired
	private irequerimientoservicio servicios;
	
	@GetMapping
	public List<requerimiento> listarTodos() {
		return servicios.listar();
	}
	
	@PostMapping
	public requerimiento insertar(@RequestBody requerimiento r) {
		return servicios.grabar(r);
	}
	
	@GetMapping(path ="/{id}")
	public Optional<requerimiento> obtenerRequerimiento(@PathVariable("id") int id) {
		return servicios.obtenerPorId(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public String EliminarRequerimiento(@PathVariable("id") int id) {
		boolean ok = servicios.eliminar(id);
		
		if(ok) {
			return "Se elimino el requerimiento con id " + id;
		}
		else {
			return "id no encontrado";
		}
	}
	
	
}
