package com.ragnax.politicacomercial.entidad;


import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Entity implementation class for Entity: TipoCambio
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_cambio")

public class TipoCambio{
	
//	@Id
//	@OrderBy
//	@Column(name="id_tipo_cambio")
//	private Integer idTipoCambio;
	
	@Id
	@Column(name="codigo_tipo_cambio")
	private String codigoTipoCambio;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_moneda_base")
	private TipoMoneda idTipoMonedaBase;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_moneda_cambio")
	private TipoMoneda idTipoMonedaCambio;
	
	@Column(name="descipcion_tipo_cambio")
	private String descripcionTipoCambio;
	
	@JsonIgnore
	@OneToMany(mappedBy="idTipoCambio")
	private List<HistorialTipoCambio> historiales_tipos_cambio;
	
	public TipoCambio() {
		super();
	}
	
	public TipoCambio(String codigoTipoCambio) {
		super();
		this.codigoTipoCambio = codigoTipoCambio;
	}

	public TipoCambio(TipoMoneda idTipoMonedaBase, TipoMoneda idTipoMonedaCambio) {
		super();
		this.idTipoMonedaBase = idTipoMonedaBase;
		this.idTipoMonedaCambio = idTipoMonedaCambio;
	}
	
	public TipoCambio(TipoMoneda idTipoMonedaBase, TipoMoneda idTipoMonedaCambio, String descripcionTipoCambio) {
		super();
		this.idTipoMonedaBase = idTipoMonedaBase;
		this.idTipoMonedaCambio = idTipoMonedaCambio;
		this.descripcionTipoCambio = descripcionTipoCambio;
	}

	public TipoMoneda getIdTipoMonedaBase() {
		return idTipoMonedaBase;
	}

	public void setIdTipoMonedaBase(TipoMoneda idTipoMonedaBase) {
		this.idTipoMonedaBase = idTipoMonedaBase;
	}

	public TipoMoneda getIdTipoMonedaCambio() {
		return idTipoMonedaCambio;
	}

	public void setIdTipoMonedaCambio(TipoMoneda idTipoMonedaCambio) {
		this.idTipoMonedaCambio = idTipoMonedaCambio;
	}

	public String getCodigoTipoCambio() {
		return codigoTipoCambio;
	}

	public void setCodigoTipoCambio(String codigoTipoCambio) {
		this.codigoTipoCambio = codigoTipoCambio;
	}
	
	public String getDescripcionTipoCambio() {
		return descripcionTipoCambio;
	}

	public void setDescripcionTipoCambio(String descripcionTipoCambio) {
		this.descripcionTipoCambio = descripcionTipoCambio;
	}

	public List<HistorialTipoCambio> getHistoriales_tipos_cambio() {
		return historiales_tipos_cambio;
	}

	public void setHistoriales_tipos_cambio(List<HistorialTipoCambio> historiales_tipos_cambio) {
		this.historiales_tipos_cambio = historiales_tipos_cambio;
	}
	
}
