package com.example.demo.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "requerimiento")
public class requerimiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String codigo_guia;
	private String fecha;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private proveedor proveedor;
	
	//@OneToMany(mappedBy = "requerimiento")
	//private List<detalle_requerimiento> detalles_req;

	public requerimiento() {
	}

	public requerimiento(int id, String codigo_guia, String fecha, proveedor proveedor) {
		this.id = id;
		this.codigo_guia = codigo_guia;
		this.fecha = fecha;
		this.proveedor = proveedor;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo_guia() {
		return codigo_guia;
	}

	public void setCodigo_guia(String codigo_guia) {
		this.codigo_guia = codigo_guia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(proveedor proveedor) {
		this.proveedor = proveedor;
	}

	
	
}
