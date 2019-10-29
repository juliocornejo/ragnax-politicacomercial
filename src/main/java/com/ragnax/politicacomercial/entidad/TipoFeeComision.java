package com.ragnax.politicacomercial.entidad;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: TipoFeeComision
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_fee_comision")

public class TipoFeeComision{
	//Comision de cobro al proveedor,
	//Comision de cobro al consumidor 
	@Id
	@OrderBy
	@Column(name="id_tipo_fee_comision")
	private Integer idTipoFeeComision;
	
	@Column(name="nombre_tipo_fee_comision")
	private String nombreTipoFeeComision;
	
	@Column(name="estado_tipo_fee_comision")
	private Boolean estadoTipoFeeComision;
	
	@JsonIgnore
	@OneToMany(mappedBy="idTipoFeeComision")
	private List<ProductoFeeComision> productos_fees_comisiones;
	
	public TipoFeeComision() {
		super();
	}
	
	public TipoFeeComision(Integer idTipoFeeComision) {
		super();
		this.idTipoFeeComision = idTipoFeeComision;
	}
	
	public TipoFeeComision(String nombreTipoFeeComision, Boolean estadoTipoFeeComision) {
		super();
		this.nombreTipoFeeComision = nombreTipoFeeComision;
		this.estadoTipoFeeComision = estadoTipoFeeComision;
	}
	
	public TipoFeeComision(Integer idTipoFeeComision, String nombreTipoFeeComision, Boolean estadoTipoFeeComision) {
		super();
		this.idTipoFeeComision = idTipoFeeComision;
		this.nombreTipoFeeComision = nombreTipoFeeComision;
		this.estadoTipoFeeComision = estadoTipoFeeComision;
	}

	public Integer getIdTipoFeeComision() {
		return idTipoFeeComision;
	}

	public void setIdTipoFeeComision(Integer idTipoFeeComision) {
		this.idTipoFeeComision = idTipoFeeComision;
	}

	public String getNombreTipoFeeComision() {
		return nombreTipoFeeComision;
	}

	public void setNombreTipoFeeComision(String nombreTipoFeeComision) {
		this.nombreTipoFeeComision = nombreTipoFeeComision;
	}

	public Boolean getEstadoTipoFeeComision() {
		return estadoTipoFeeComision;
	}

	public void setEstadoTipoFeeComision(Boolean estadoTipoFeeComision) {
		this.estadoTipoFeeComision = estadoTipoFeeComision;
	}

	public List<ProductoFeeComision> getProductos_fees_comisiones() {
		return productos_fees_comisiones;
	}

	public void setProductos_fees_comisiones(List<ProductoFeeComision> productos_fees_comisiones) {
		this.productos_fees_comisiones = productos_fees_comisiones;
	}
	
}
