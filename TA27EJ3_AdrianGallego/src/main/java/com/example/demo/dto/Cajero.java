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
@Table(name="cajeros")
public class Cajero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_cajero;
	private String nom_apels;
	
	@OneToMany
    @JoinColumn(name="cajero_id")
	private List<Venta> Venta;
	
	public Cajero() {
	}

	public Cajero(int codigo_cajero, String nom_apels, List<com.example.demo.dto.Venta> venta) {
		super();
		this.codigo_cajero = codigo_cajero;
		this.nom_apels = nom_apels;
		Venta = venta;
	}

	public int getCodigo_cajero() {
		return codigo_cajero;
	}

	public void setCodigo_cajero(int codigo_cajero) {
		this.codigo_cajero = codigo_cajero;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
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
