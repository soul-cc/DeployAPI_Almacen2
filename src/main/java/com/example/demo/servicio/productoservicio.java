package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceservicio.iproductoservicio;
import com.example.demo.modelo.producto;
import com.example.demo.repository.iproducto;

@Service
public class productoservicio implements iproductoservicio{
	@Autowired
	private iproducto data;

	@Override
	public List<producto> listar() {
		return (List<producto>)data.findAll();
	}

	@Override
	public Optional<producto> obtenerPorId(int id) {
		return data.findById(id);
	}

	@Override
	public producto grabar(producto p) {
		return data.save(p);
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
