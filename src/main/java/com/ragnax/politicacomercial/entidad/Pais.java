package com.ragnax.politicacomercial.entidad;



import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entity implementation class for Entity: Pais
 * en la base de Datos representa 
 */
@Entity
@Table (name="pais")

public class Pais{
	
	/*** Para generar las key en otros negocios es necesario que el id sea numerico ********/
	@Id
	@Column(name="codigo_portal_pais_lower_case")
	private String codigoPortalPaisLowerCase;
	
	@Column(name="nombre_pais")
	private String nombrePais;
	
	@Column(name="nombre_pais_lower_case")
	private String nombrePaisLowerCase;
	
	@Column(name="estado_pais")
	private Boolean estadoPais;
	
	@ManyToOne
	@JoinColumn(name="fk_id_tipo_moneda")
	private TipoMoneda idTipoMoneda;
	
	@JsonIgnore
	@OneToMany(mappedBy="idPais")
	private List<ProductoFeeComision> productos_fees_comisiones;
	
	public Pais() {
		super();
	}
	
	public Pais(String codigoPortalPaisLowerCase) {
		super();
		this.codigoPortalPaisLowerCase = codigoPortalPaisLowerCase;
	}
	
	public Pais(String nombrePais, String codigoPortalPaisLowerCase, Boolean estadoPais,
			TipoMoneda idTipoMoneda) {
		super();
		this.nombrePais = nombrePais;
		this.codigoPortalPaisLowerCase = codigoPortalPaisLowerCase;
		this.estadoPais = estadoPais;
		this.idTipoMoneda = idTipoMoneda;
	}

	public String getCodigoPortalPaisLowerCase() {
		return codigoPortalPaisLowerCase;
	}

	public void setCodigoPortalPaisLowerCase(String codigoPortalPaisLowerCase) {
		this.codigoPortalPaisLowerCase = codigoPortalPaisLowerCase;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getNombrePaisLowerCase() {
		return nombrePaisLowerCase;
	}

	public void setNombrePaisLowerCase(String nombrePaisLowerCase) {
		this.nombrePaisLowerCase = nombrePaisLowerCase;
	}

	public Boolean getEstadoPais() {
		return estadoPais;
	}

	public void setEstadoPais(Boolean estadoPais) {
		this.estadoPais = estadoPais;
	}

	public TipoMoneda getIdTipoMoneda() {
		return idTipoMoneda;
	}

	public void setIdTipoMoneda(TipoMoneda idTipoMoneda) {
		this.idTipoMoneda = idTipoMoneda;
	}
}
