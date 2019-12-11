package com.ragnax.politicacomercial.entidad;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: TipoValorComision
 * en la base de Datos representa 
 */
@Entity
@Table (name="tipo_valor_comision")

public class TipoValorComision{
	//nominal
	//porcentual 
	@Id
	@OrderBy
	@Column(name="id_tipo_valor_comision")
	private Integer idTipoValorComision;
	
	@Column(name="nombre_tipo_valor_comision")
	private String nombreTipoValorComision;
	
	@Column(name="limite_valor_comision")
	private int limiteValorComision;
	
	@JsonIgnore
	@OneToMany(mappedBy="idTipoValorComision")
	private List<HistorialFeeComision> historial_fees_comisiones;
	
	public TipoValorComision() {
		super();
	}
	
	public TipoValorComision(Integer idTipoValorComision, String nombreTipoValorComision, int limiteValorComision) {
		super();
		this.idTipoValorComision = idTipoValorComision;
		this.nombreTipoValorComision = nombreTipoValorComision;
		this.limiteValorComision = limiteValorComision;
	}

	public TipoValorComision(Integer idTipoValorComision) {
		super();
		this.idTipoValorComision = idTipoValorComision;
	}
	
	public TipoValorComision(Integer idTipoValorComision, String nombreTipoValorComision,
			List<HistorialFeeComision> historial_fees_comisiones) {
		super();
		this.idTipoValorComision = idTipoValorComision;
		this.nombreTipoValorComision = nombreTipoValorComision;
		this.historial_fees_comisiones = historial_fees_comisiones;
	}

	public Integer getIdTipoValorComision() {
		return idTipoValorComision;
	}

	public void setIdTipoValorComision(Integer idTipoValorComision) {
		this.idTipoValorComision = idTipoValorComision;
	}

	public String getNombreTipoValorComision() {
		return nombreTipoValorComision;
	}

	public void setNombreTipoValorComision(String nombreTipoValorComision) {
		this.nombreTipoValorComision = nombreTipoValorComision;
	}
	
	
	public int getLimiteValorComision() {
		return limiteValorComision;
	}

	public void setLimiteValorComision(int limiteValorComision) {
		this.limiteValorComision = limiteValorComision;
	}

	public List<HistorialFeeComision> getHistorial_fees_comisiones() {
		return historial_fees_comisiones;
	}

	public void setHistorial_fees_comisiones(List<HistorialFeeComision> historial_fees_comisiones) {
		this.historial_fees_comisiones = historial_fees_comisiones;
	}
}
