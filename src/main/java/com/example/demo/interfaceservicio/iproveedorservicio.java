package com.example.demo.interfaceservicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.proveedor;

public interface iproveedorservicio {
	
	public List<proveedor> listar();
	
	public Optional<proveedor> obtenerPorId(int id);
	
	public proveedor grabar(proveedor p);
	
	public boolean eliminar(int id);
	
}
