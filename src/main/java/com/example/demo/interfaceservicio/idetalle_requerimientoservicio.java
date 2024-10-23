package com.example.demo.interfaceservicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.detalle_requerimiento;

public interface idetalle_requerimientoservicio {
	
	public List<detalle_requerimiento> listar();
	
	public Optional<detalle_requerimiento> obtenerPorId(int id);
	
	public detalle_requerimiento grabar(detalle_requerimiento d);
	
	public boolean eliminar(int id);
	
	public List<detalle_requerimiento> obtenerPorRequerimientoId(int id);
	
}
