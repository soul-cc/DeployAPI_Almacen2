package com.example.demo.interfaceservicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.producto;

public interface iproductoservicio {
	
	public List<producto> listar();
	
	public Optional<producto> obtenerPorId(int id);
	
	public producto grabar(producto p);
	
	public boolean eliminar(int id);
	
}
