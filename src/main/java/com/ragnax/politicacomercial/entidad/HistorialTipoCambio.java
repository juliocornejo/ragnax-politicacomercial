package com.ragnax.politicacomercial.entidad;


import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 *  implementation class for : HistorialTipoCambio
 * en la base de Datos representa 
 */
@Entity
@Table (name="historial_tipo_cambio")

public class HistorialTipoCambio{
	
	@Id
	@OrderBy
	@Column(name="id_historial_tipo_cambio")
	private Integer idHistorialTipoCambio;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_cambio")
	private TipoCambio idTipoCambio;

	@Column(name="valor_moneda_cambio", precision=7, scale=2)
	private BigDecimal valorMonedaCambio; //en este dia 1 Moneda Local x Dolar vale 
	
	@Column(name="fecha_inicio_tipo_cambio")
	private Timestamp fechaInicioTipoCambio; //en este dia dd-mm-yyyy el fee era
	
	@Column(name="fecha_final_tipo_cambio")
	private Timestamp fechaFinalTipoCambio; //en este dia dd-mm-yyyy el fee era
	
	@Column(name="estado_historial_tipo_cambio")
	private Boolean estadoHistorialTipoCambio;
	
	public HistorialTipoCambio() {
		super();
	}

	public HistorialTipoCambio(TipoCambio idTipoCambio) {
		super();
		this.idTipoCambio = idTipoCambio;
	}
	
	public HistorialTipoCambio(TipoCambio idTipoCambio, BigDecimal valorMonedaCambio) {
		super();
		this.idTipoCambio = idTipoCambio;
		this.valorMonedaCambio = valorMonedaCambio;
	}
	
//	public HistorialTipoCambio(TipoCambio idTipoCambio, BigDecimal valorMonedaCambio,
//			Timestamp fechaInicioTipoCambio, Timestamp fechaFinalTipoCambio, Boolean estadoHistorialTipoCambio) {
//		super();
//		this.idTipoCambio = idTipoCambio;
//		this.valorMonedaCambio = valorMonedaCambio;
//		this.fechaInicioTipoCambio = fechaInicioTipoCambio;
//		this.fechaFinalTipoCambio = fechaFinalTipoCambio;
//		this.estadoHistorialTipoCambio = estadoHistorialTipoCambio;
//	}
	
//	public HistorialTipoCambio(Integer idHistorialTipoCambio, TipoCambio idTipoCambio,
//			BigDecimal valorMonedaCambio, Timestamp fechaInicioTipoCambio, Timestamp fechaFinalTipoCambio,
//			Boolean estadoHistorialTipoCambio) {
//		super();
//		this.idHistorialTipoCambio = idHistorialTipoCambio;
//		this.idTipoCambio = idTipoCambio;
//		this.valorMonedaCambio = valorMonedaCambio;
//		this.fechaInicioTipoCambio = fechaInicioTipoCambio;
//		this.fechaFinalTipoCambio = fechaFinalTipoCambio;
//		this.estadoHistorialTipoCambio = estadoHistorialTipoCambio;
//	}

	public Integer getIdHistorialTipoCambio() {
		return idHistorialTipoCambio;
	}

	public void setIdHistorialTipoCambio(Integer idHistorialTipoCambio) {
		this.idHistorialTipoCambio = idHistorialTipoCambio;
	}

	public TipoCambio getIdTipoCambio() {
		return idTipoCambio;
	}

	public void setIdTipoCambio(TipoCambio idTipoCambio) {
		this.idTipoCambio = idTipoCambio;
	}

	public BigDecimal getValorMonedaCambio() {
		return valorMonedaCambio;
	}

	public void setValorMonedaCambio(BigDecimal valorMonedaCambio) {
		this.valorMonedaCambio = valorMonedaCambio;
	}

	public Timestamp getFechaInicioTipoCambio() {
		return fechaInicioTipoCambio;
	}

	public void setFechaInicioTipoCambio(Timestamp fechaInicioTipoCambio) {
		this.fechaInicioTipoCambio = fechaInicioTipoCambio;
	}

	public Timestamp getFechaFinalTipoCambio() {
		return fechaFinalTipoCambio;
	}

	public void setFechaFinalTipoCambio(Timestamp fechaFinalTipoCambio) {
		this.fechaFinalTipoCambio = fechaFinalTipoCambio;
	}

	public Boolean getEstadoHistorialTipoCambio() {
		return estadoHistorialTipoCambio;
	}

	public void setEstadoHistorialTipoCambio(Boolean estadoHistorialTipoCambio) {
		this.estadoHistorialTipoCambio = estadoHistorialTipoCambio;
	}

	
}
