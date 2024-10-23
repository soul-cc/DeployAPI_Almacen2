package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceservicio.iusuarioservicio;
import com.example.demo.modelo.usuario;
import com.example.demo.repository.iusuario;

@Service
public class usuarioservicio implements iusuarioservicio{
	@Autowired
	private iusuario data;
	
	@Override
	public List<usuario> listar() {
		return (List<usuario>)data.findAll();
	}

	@Override
	public Optional<usuario> obtenerPorId(int id) {
		return data.findById(id);
	}

	@Override
	public usuario grabar(usuario u) {
		return data.save(u);
	}
	
	@Override
	public Optional<usuario> logeo(String email, String password) {
		Optional<usuario> buscado = data.findByEmail(email);
		
		if(buscado.isPresent() && buscado.get().getPassword().equals(password)) {
			return buscado;
		}
		else {
			return Optional.empty();
		}
	}
	

	@Override
	public boolean eliminar(int id) {
		try {
			data.deleteById(id);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

}
