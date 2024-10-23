package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceservicio.iproveedorservicio;
import com.example.demo.modelo.proveedor;
import com.example.demo.repository.iproveedor;

@Service
public class proveedorservicio implements iproveedorservicio{
	@Autowired
	private iproveedor data;
	
	@Override
	public List<proveedor> listar() {
		return (List<proveedor>)data.findAll();
	}

	@Override
	public Optional<proveedor> obtenerPorId(int id) {
		return data.findById(id);
	}

	@Override
	public proveedor grabar(proveedor p) {
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
