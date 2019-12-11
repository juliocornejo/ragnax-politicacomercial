package com.ragnax.politicacomercial.entidad;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoMoneda
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_moneda")

public class TipoMoneda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6364104554717791393L;

	@Id
	@OrderBy
	@Column(name="id_tipo_moneda")
	private Integer idTipoMoneda;
	
	@Column(name="codigo_tipo_moneda_upper_case")
	private String codigoTipoMonedaUpperCase;
	
	@Column(name="nombre_tipo_moneda")
	private String nombreTipoMoneda;
	
	@Column(name="nombre_tipo_moneda_lower_case")
	private String nombreTipoMonedaLowerCase;
	
	@Column(name="simbolo_tipo_moneda")
	private String simboloTipoMoneda;
	
	@Column(name="estado_tipo_moneda")
	private Boolean estadoTipoMoneda;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="idTipoMonedaBase")
//	private List<TipoCambio> tipos_cambios_bases;
//	
//	@JsonIgnore
//	@OneToMany(mappedBy="idTipoMonedaCambio")
//	private List<TipoCambio> tipos_cambios_destinos;
	
	
	public TipoMoneda() {
		super();
	}
	
	public TipoMoneda(Integer idTipoMoneda) {
		super();
		this.idTipoMoneda = idTipoMoneda;
	}
	
	public TipoMoneda(Integer idTipoMoneda, String codigoTipoMonedaUpperCase) {
		super();
		this.idTipoMoneda = idTipoMoneda;
		this.codigoTipoMonedaUpperCase = codigoTipoMonedaUpperCase;
	}
	
	public TipoMoneda(String codigoTipoMonedaUpperCase, String nombreTipoMoneda, String simboloTipoMoneda) {
		super();
		this.codigoTipoMonedaUpperCase = codigoTipoMonedaUpperCase;
		this.nombreTipoMoneda = nombreTipoMoneda;
		this.simboloTipoMoneda = simboloTipoMoneda;
	}
	

	public TipoMoneda(Integer idTipoMoneda, String codigoTipoMonedaUpperCase, String nombreTipoMoneda, String nombreTipoMonedaLowerCase,
			String simboloTipoMoneda, Boolean estadoTipoMoneda) {
		super();
		this.idTipoMoneda = idTipoMoneda;
		this.codigoTipoMonedaUpperCase = codigoTipoMonedaUpperCase;
		this.nombreTipoMoneda = nombreTipoMoneda;
		this.nombreTipoMonedaLowerCase = nombreTipoMonedaLowerCase;
		this.simboloTipoMoneda = simboloTipoMoneda;
		this.estadoTipoMoneda = estadoTipoMoneda;
	}

	public Integer getIdTipoMoneda() {
		return idTipoMoneda;
	}

	public void setIdTipoMoneda(Integer idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}

	public String getCodigoTipoMonedaUpperCase() {
		return codigoTipoMonedaUpperCase;
	}

	public void setCodigoTipoMonedaUpperCase(String codigoTipoMonedaUpperCase) {
		this.codigoTipoMonedaUpperCase = codigoTipoMonedaUpperCase;
	}
	
	public String getNombreTipoMoneda() {
		return nombreTipoMoneda;
	}

	public void setNombreTipoMoneda(String nombreTipoMoneda) {
		this.nombreTipoMoneda = nombreTipoMoneda;
	}

	public String getNombreTipoMonedaLowerCase() {
		return nombreTipoMonedaLowerCase;
	}

	public void setNombreTipoMonedaLowerCase(String nombreTipoMonedaLowerCase) {
		this.nombreTipoMonedaLowerCase = nombreTipoMonedaLowerCase;
	}

	public String getSimboloTipoMoneda() {
		return simboloTipoMoneda;
	}

	public void setSimboloTipoMoneda(String simboloTipoMoneda) {
		this.simboloTipoMoneda = simboloTipoMoneda;
	}

	public Boolean getEstadoTipoMoneda() {
		return estadoTipoMoneda;
	}

	public void setEstadoTipoMoneda(Boolean estadoTipoMoneda) {
		this.estadoTipoMoneda = estadoTipoMoneda;
	}

//	public List<TipoCambio> getTipos_cambios_bases() {
//		return tipos_cambios_bases;
//	}
//
//	public void setTipos_cambios_bases(List<TipoCambio> tipos_cambios_bases) {
//		this.tipos_cambios_bases = tipos_cambios_bases;
//	}
//
//	public List<TipoCambio> getTipos_cambios_destinos() {
//		return tipos_cambios_destinos;
//	}
//
//	public void setTipos_cambios_destinos(List<TipoCambio> tipos_cambios_destinos) {
//		this.tipos_cambios_destinos = tipos_cambios_destinos;
//	}
	
}
