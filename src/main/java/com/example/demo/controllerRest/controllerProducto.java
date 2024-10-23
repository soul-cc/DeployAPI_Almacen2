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

import com.example.demo.interfaceservicio.iproductoservicio;
import com.example.demo.modelo.producto;

@RestController
@RequestMapping("/productos")
public class controllerProducto {
	@Autowired
	private iproductoservicio servicios;
	
	@GetMapping
	public List<producto> listarTodos() {
		return servicios.listar();
	}
	
	@PostMapping
	public producto insertar(@RequestBody producto p) {
		return servicios.grabar(p);
	}
	
	@GetMapping(path ="/{id}")
	public Optional<producto> obtenerProducto(@PathVariable("id") int id) {
		return servicios.obtenerPorId(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public String eliminarProducto(@PathVariable("id") int id) {
		boolean ok = servicios.eliminar(id);
		
		if(ok) {
			return "Se elimino el producto con id " + id;
		}
		else {
			return "id no encontrado";
		}
	}
	
}
