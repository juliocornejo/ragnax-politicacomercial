package com.ragnax.politicacomercial.entidad;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 *  implementation class for : HistorialFeeComision
 * en la base de Datos representa 
 */
@Entity
@Table (name="historial_fee_comision")

public class HistorialFeeComision{
	
	
	@Id
	@OrderBy
	@Column(name="id_historial_fee_comision")
	private Integer idHistorialFeeComision;
	
	
	@ManyToOne
	@JoinColumn(name="fk_id_producto_fee_comision")
	private ProductoFeeComision idProductoFeeComision;
	
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_valor_comision")
	private TipoValorComision idTipoValorComision;
	
	/**************************/
	
	@Column(name="porcentaje_fee_comision", precision=5, scale=2)
	private BigDecimal porcentajeFeeComision; //el valor del fee es. 
	/**************************/
	
	@Column(name="fecha_inicio_fee_comision")
	private Timestamp fechaInicioFeeComision; //en este dia dd-mm-yyyy el fee era
	
	
	@Column(name="fecha_final_fee_comision")
	private Timestamp fechaFinalFeeComision; //en este dia dd-mm-yyyy el fee era
	//solo el de mayor numero
	//1 prioridad base, 1+ prioridad para evento
//	@Column(name="prioridad_fee_comision")
//	private Integer prioridadFeeComision;
	//Activo o Pasivo
	
	@Column(name="estado_fee_comision")
	private Boolean estadoFeeComision; 
	
	public HistorialFeeComision() {
		super();
	}
	
	public HistorialFeeComision(Integer idHistorialFeeComision) {
		super();
		this.idHistorialFeeComision = idHistorialFeeComision;
	}
	
	public HistorialFeeComision(ProductoFeeComision idProductoFeeComision,  TipoValorComision idTipoValorComision) {
		super();
		this.idProductoFeeComision = idProductoFeeComision;
		this.idTipoValorComision = idTipoValorComision;
	}
	
	public HistorialFeeComision(ProductoFeeComision idProductoFeeComision,  TipoValorComision idTipoValorComision, BigDecimal porcentajeFeeComision) {
		super();
		this.idProductoFeeComision = idProductoFeeComision;
		this.idTipoValorComision = idTipoValorComision;
		this.porcentajeFeeComision = porcentajeFeeComision;
	}

	public HistorialFeeComision(Timestamp fechaInicioFeeComision, boolean estadoFeeComision) {
		super();
		this.fechaInicioFeeComision = fechaInicioFeeComision;
		this.estadoFeeComision = estadoFeeComision;
	}
	
	public HistorialFeeComision(Integer idHistorialFeeComision,
			ProductoFeeComision idProductoFeeComision, TipoValorComision idTipoValorComision,
			BigDecimal porcentajeFeeComision, Timestamp fechaInicioFeeComision, Timestamp fechaFinalFeeComision,
			Boolean estadoFeeComision) {
		super();
		this.idHistorialFeeComision = idHistorialFeeComision;
		this.idProductoFeeComision = idProductoFeeComision;
		this.idTipoValorComision = idTipoValorComision;
		this.porcentajeFeeComision = porcentajeFeeComision;
		this.fechaInicioFeeComision = fechaInicioFeeComision;
		this.fechaFinalFeeComision = fechaFinalFeeComision;
		this.estadoFeeComision = estadoFeeComision;
	}

	public Integer getIdHistorialFeeComision() {
		return idHistorialFeeComision;
	}

	public void setIdHistorialFeeComision(Integer idHistorialFeeComision) {
		this.idHistorialFeeComision = idHistorialFeeComision;
	}

	public ProductoFeeComision getIdProductoFeeComision() {
		return idProductoFeeComision;
	}

	public void setIdProductoFeeComision(ProductoFeeComision idProductoFeeComision) {
		this.idProductoFeeComision = idProductoFeeComision;
	}

	public TipoValorComision getIdTipoValorComision() {
		return idTipoValorComision;
	}

	public void setIdTipoValorComision(TipoValorComision idTipoValorComision) {
		this.idTipoValorComision = idTipoValorComision;
	}

	public BigDecimal getPorcentajeFeeComision() {
		return porcentajeFeeComision;
	}

	public void setPorcentajeFeeComision(BigDecimal porcentajeFeeComision) {
		this.porcentajeFeeComision = porcentajeFeeComision;
	}

	public Timestamp getFechaInicioFeeComision() {
		return fechaInicioFeeComision;
	}

	public void setFechaInicioFeeComision(Timestamp fechaInicioFeeComision) {
		this.fechaInicioFeeComision = fechaInicioFeeComision;
	}

	public Timestamp getFechaFinalFeeComision() {
		return fechaFinalFeeComision;
	}

	public void setFechaFinalFeeComision(Timestamp fechaFinalFeeComision) {
		this.fechaFinalFeeComision = fechaFinalFeeComision;
	}

	public Boolean getEstadoFeeComision() {
		return estadoFeeComision;
	}

	public void setEstadoFeeComision(Boolean estadoFeeComision) {
		this.estadoFeeComision = estadoFeeComision;
	}
	
}