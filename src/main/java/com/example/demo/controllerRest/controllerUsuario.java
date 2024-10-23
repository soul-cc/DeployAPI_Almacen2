package com.example.demo.controllerRest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaceservicio.iusuarioservicio;
import com.example.demo.modelo.usuario;

@RestController
@RequestMapping("/usuarios")
public class controllerUsuario {
	@Autowired
	private iusuarioservicio servicios;
	
	@GetMapping
	public List<usuario> listarTodos() {
		List<usuario> usuarios = servicios.listar();
		return usuarios;
	}
	
	@PostMapping
	public usuario insertar(@RequestBody usuario u) {
		return servicios.grabar(u);
	}
	
	/*
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody usuario u) {
        Optional<usuario> buscado = servicios.logeo(u.getEmail(),u.getPassword());
        
        if (buscado.isPresent()) {
            return ResponseEntity.ok(buscado.get());
        }
        return ResponseEntity.status(401).body("Credenciales incorrectas");
    }
	*/
	
	@PostMapping("/login")
	public boolean login(@RequestBody usuario u) {
		Optional<usuario> buscado = servicios.logeo(u.getEmail(),u.getPassword());
        
        if (buscado.isPresent()) {
            return true;
        }
        return false;
    }
	
	
	@GetMapping(path ="/{id}")
	public Optional<usuario> obtenerUsuario(@PathVariable("id") int id) {
		return servicios.obtenerPorId(id);
	}
	
	@DeleteMapping(path ="/{id}")
	public String EliminarUsuario(@PathVariable("id") int id) {
		boolean ok = servicios.eliminar(id);
		
		if(ok) {
			return "Se elimino el usuario con id " + id;
		}
		else {
			return "id no encontrado";
		}
	}
	
	
}
