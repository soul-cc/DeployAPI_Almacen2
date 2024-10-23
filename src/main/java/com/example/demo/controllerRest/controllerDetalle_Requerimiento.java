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

import com.example.demo.interfaceservicio.idetalle_requerimientoservicio;
import com.example.demo.modelo.detalle_requerimiento;

@RestController
@RequestMapping("/DetallesDeRequerimiento")
public class controllerDetalle_Requerimiento {
	@Autowired 
	private idetalle_requerimientoservicio servicios;
	
	@GetMapping
	public List<detalle_requerimiento> listarTodos() {
		return servicios.listar();
	}
	
	@PostMapping
	public detalle_requerimiento insertar(@RequestBody detalle_requerimiento d) {
		return servicios.grabar(d);
	}
	
	@GetMapping(path ="/{id}")
	public Optional<detalle_requerimiento> obtenerDetalle(@PathVariable int id) {
		return servicios.obtenerPorId(id);
	}
	
	@GetMapping("/byRequerimiento/{requerimiento_id}")
	public List<detalle_requerimiento> listarPorRequerimientoId(@PathVariable("requerimiento_id") int requerimiento_id) {
		return servicios.obtenerPorRequerimientoId(requerimiento_id);
	}
	
	@DeleteMapping(path ="/{id}")
	public String EliminarDetalle(@PathVariable("id") int id) {
		boolean ok = servicios.eliminar(id);
		
		if(ok) {
			return "Se elimino el detalle de requerimiento con id " + id;
		}
		else {
			return "id no encontrado";
		}
	}
	
}
