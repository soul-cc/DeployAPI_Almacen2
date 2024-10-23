package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_requerimiento")
public class detalle_requerimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "requerimiento_id")
	private requerimiento requerimiento;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private producto producto;
	
	private int cantidad;

	public detalle_requerimiento() {
	}

	public detalle_requerimiento(int id, com.example.demo.modelo.requerimiento requerimiento,
			com.example.demo.modelo.producto producto, int cantidad) {
		this.id = id;
		this.requerimiento = requerimiento;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public requerimiento getRequerimiento() {
		return requerimiento;
	}

	public void setRequerimiento(requerimiento requerimiento) {
		this.requerimiento = requerimiento;
	}

	public producto getProducto() {
		return producto;
	}

	public void setProducto(producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
