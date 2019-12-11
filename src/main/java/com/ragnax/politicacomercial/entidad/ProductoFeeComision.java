package com.ragnax.politicacomercial.entidad;

import java.util.List;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: ProductoFeeComision
 * en la base de Datos representa 
 */
@Entity
@Table (name="producto_fee_comision")

public class ProductoFeeComision{
	//producto
	//servicio
//	@Id
//	@OrderBy
//	@Column(name="id_producto_fee_comision")
//	private Integer idProductoFeeComision;
	//a que aplicacion se le agrega esta comision
	@Id
	@Column(name="codigo_producto_fee_comision")
	private String codigoProductoFeeComision;
	
	@Column(name="nombre_producto_servicio")
	private String nombreProductoServicio;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_negocio")
	private TipoNegocio idTipoNegocio;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_fee_comision")
	private TipoFeeComision idTipoFeeComision;
	
	@ManyToOne
	@JoinColumn(name="fk_id_pais")
	private Pais idPais;
	
	//nombre del producto o servicio de la aplicacion se le esta agregando la comision
	@Column(name="estado_producto_fee_comision")
	private Boolean estadoProductoFeeComision; 
	
	@JsonIgnore
	@OneToMany(mappedBy="idProductoFeeComision")
	private List<HistorialFeeComision> historial_fees_comisiones;
	
	public ProductoFeeComision() {
		super();
	}
	
	public ProductoFeeComision(String codigoProductoFeeComision) {
		super();
		this.codigoProductoFeeComision = codigoProductoFeeComision;
	}
	
	public ProductoFeeComision(TipoNegocio idTipoNegocio, Boolean estadoProductoFeeComision) {
		super();
		this.idTipoNegocio = idTipoNegocio;
		this.estadoProductoFeeComision = estadoProductoFeeComision;
	}
	
	public ProductoFeeComision(TipoNegocio idTipoNegocio, TipoFeeComision idTipoFeeComision,
			String nombreProductoServicio) {
		super();
		this.idTipoNegocio = idTipoNegocio;
		this.idTipoFeeComision = idTipoFeeComision;
		this.nombreProductoServicio = nombreProductoServicio;
	}
	
	
	public ProductoFeeComision(TipoNegocio idTipoNegocio, TipoFeeComision idTipoFeeComision,
			Pais idPais, String nombreProductoServicio) {
		super();
		this.idTipoNegocio = idTipoNegocio;
		this.idTipoFeeComision = idTipoFeeComision;
		this.idPais = idPais;
		this.nombreProductoServicio = nombreProductoServicio;
	}

	public String getCodigoProductoFeeComision() {
		return codigoProductoFeeComision;
	}

	public void setCodigoProductoFeeComision(String codigoProductoFeeComision) {
		this.codigoProductoFeeComision = codigoProductoFeeComision;
	}

	public String getNombreProductoServicio() {
		return nombreProductoServicio;
	}

	public void setNombreProductoServicio(String nombreProductoServicio) {
		this.nombreProductoServicio = nombreProductoServicio;
	}

	public TipoNegocio getIdTipoNegocio() {
		return idTipoNegocio;
	}

	public void setIdTipoNegocio(TipoNegocio idTipoNegocio) {
		this.idTipoNegocio = idTipoNegocio;
	}

	public TipoFeeComision getIdTipoFeeComision() {
		return idTipoFeeComision;
	}

	public void setIdTipoFeeComision(TipoFeeComision idTipoFeeComision) {
		this.idTipoFeeComision = idTipoFeeComision;
	}

	public Pais getIdPais() {
		return idPais;
	}

	public void setIdPais(Pais idPais) {
		this.idPais = idPais;
	}

	public Boolean getEstadoProductoFeeComision() {
		return estadoProductoFeeComision;
	}

	public void setEstadoProductoFeeComision(Boolean estadoProductoFeeComision) {
		this.estadoProductoFeeComision = estadoProductoFeeComision;
	}

	public List<HistorialFeeComision> getHistorial_fees_comisiones() {
		return historial_fees_comisiones;
	}

	public void setHistorial_fees_comisiones(List<HistorialFeeComision> historial_fees_comisiones) {
		this.historial_fees_comisiones = historial_fees_comisiones;
	}
	
}
