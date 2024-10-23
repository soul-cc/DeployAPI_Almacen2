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

import com.example.demo.interfaceservicio.iproveedorservicio;
import com.example.demo.modelo.proveedor;

@RestController
@RequestMapping("/proveedores")
public class controllerProveedor {
	@Autowired
	private iproveedorservicio servicios;
	
	@GetMapping
	public List<proveedor> Listartodos() {
		return servicios.listar();
	}
	
	@PostMapping
	public proveedor insertar(@RequestBody proveedor p) {
		return servicios.grabar(p);
	}
	
	@GetMapping(path ="/{id}")
	public Optional<proveedor> obtenerProveedor(@PathVariable("id") int id) {
		return servicios.obtenerPorId(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public String eliminarProveedor(@PathVariable("id") int id) {
		boolean ok = servicios.eliminar(id);
		
		if(ok) {
			return "Se elimino el proveedor con id " + id;
		}
		else {
			return "id no encontrado";
		}
			
	}
	
}
