package com.ragnax.politicacomercial.entidad;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: TipoNegocio
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_negocio")
public class TipoNegocio {
	
	
	@Id
	@OrderBy
	@Column(name="id_tipo_negocio")
	private Integer idTipoNegocio;
	
	@Column(name="nombre_tipo_negocio")
	private String nombreTipoNegocio;
	
	@Column(name="estado_tipo_negocio")
	private Boolean estadoTipoNegocio;
	
	@JsonIgnore
	@OneToMany(mappedBy="idTipoNegocio")
	private List<ProductoFeeComision> productos_fees_comisiones;
	
	public TipoNegocio() {
		super();
	}

	public TipoNegocio(Integer idTipoNegocio) {
		super();
		this.idTipoNegocio = idTipoNegocio;
	}

	public TipoNegocio(Integer idTipoNegocio, String nombreTipoNegocio, Boolean estadoTipoNegocio) {
		super();
		this.idTipoNegocio = idTipoNegocio;
		this.nombreTipoNegocio = nombreTipoNegocio;
		this.estadoTipoNegocio = estadoTipoNegocio;
	}

	public Integer getIdTipoNegocio() {
		return idTipoNegocio;
	}

	public void setIdTipoNegocio(Integer idTipoNegocio) {
		this.idTipoNegocio = idTipoNegocio;
	}

	public String getNombreTipoNegocio() {
		return nombreTipoNegocio;
	}

	public void setNombreTipoNegocio(String nombreTipoNegocio) {
		this.nombreTipoNegocio = nombreTipoNegocio;
	}

	public Boolean getEstadoTipoNegocio() {
		return estadoTipoNegocio;
	}

	public void setEstadoTipoNegocio(Boolean estadoTipoNegocio) {
		this.estadoTipoNegocio = estadoTipoNegocio;
	}

	public List<ProductoFeeComision> getProductos_fees_comisiones() {
		return productos_fees_comisiones;
	}

	public void setProductos_fees_comisiones(List<ProductoFeeComision> productos_fees_comisiones) {
		this.productos_fees_comisiones = productos_fees_comisiones;
	}
}
