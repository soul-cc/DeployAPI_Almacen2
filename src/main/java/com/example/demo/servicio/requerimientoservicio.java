package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceservicio.irequerimientoservicio;
import com.example.demo.modelo.requerimiento;
import com.example.demo.repository.irequerimiento;

@Service
public class requerimientoservicio implements irequerimientoservicio{
	@Autowired
	private irequerimiento data;
	
	@Override
	public List<requerimiento> listar() {
		return (List<requerimiento>)data.findAll();
	}

	@Override
	public Optional<requerimiento> obtenerPorId(int id) {
		return data.findById(id);
	}

	@Override
	public requerimiento grabar(requerimiento r) {
		return data.save(r);
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
