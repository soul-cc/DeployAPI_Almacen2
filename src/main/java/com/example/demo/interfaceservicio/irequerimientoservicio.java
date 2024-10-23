package com.example.demo.interfaceservicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.requerimiento;

public interface irequerimientoservicio {
	
	public List<requerimiento> listar();
	
	public Optional<requerimiento> obtenerPorId(int id);
	
	public requerimiento grabar(requerimiento r);
	
	public boolean eliminar(int id);
	
}
