package com.example.demo.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceservicio.idetalle_requerimientoservicio;
import com.example.demo.modelo.detalle_requerimiento;
import com.example.demo.modelo.requerimiento;
import com.example.demo.repository.idetalle_requerimiento;
import com.example.demo.repository.irequerimiento;

@Service
public class detalle_requerimientoservicio implements idetalle_requerimientoservicio{
	@Autowired
	private idetalle_requerimiento data;
	@Autowired
	private irequerimiento data_req;
	
	@Override
	public List<detalle_requerimiento> listar() {
		return (List<detalle_requerimiento>)data.findAll();
	}
	
	@Override
	public Optional<detalle_requerimiento> obtenerPorId(int id) {
		return data.findById(id);
	}
	
	@Override
	public detalle_requerimiento grabar(detalle_requerimiento d) {
		return data.save(d);
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

	@Override
	public List<detalle_requerimiento> obtenerPorRequerimientoId(int id) {
		Optional<requerimiento> requerimientoBuscado= data_req.findById(id);
		
		if(requerimientoBuscado.isPresent()) {
			requerimiento req = requerimientoBuscado.get();
			
			return data.findByRequerimiento(req);
		}
		else {
			return new ArrayList<>(); //devuelve una lista vacia
		}
		
		
	}
	
	
}
