package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_productos;
	private String nombre;
	private int precio;
	
	@OneToMany
    @JoinColumn(name="producto_id")
	private List<Venta> Venta;
	
	public Producto() {
		
	}

	public Producto(int codigo_productos, String nombre, int precio, List<com.example.demo.dto.Venta> venta) {
		super();
		this.codigo_productos = codigo_productos;
		this.nombre = nombre;
		this.precio = precio;
		Venta = venta;
	}

	public int getCodigo_productos() {
		return codigo_productos;
	}

	public void setCodigo_productos(int codigo_productos) {
		this.codigo_productos = codigo_productos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return Venta;
	}

	public void setVenta(List<Venta> venta) {
		Venta = venta;
	}

	
		
}
