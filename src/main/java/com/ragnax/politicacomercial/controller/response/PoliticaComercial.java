package com.ragnax.politicacomercial.controller.response;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.ragnax.politicacomercial.entidad.HistorialFeeComision;
import com.ragnax.politicacomercial.entidad.ProductoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoNegocio;
import com.ragnax.politicacomercial.entidad.TipoValorComision;
import com.ragnax.politicacomercial.entidad.HistorialTipoCambio;
import com.ragnax.politicacomercial.entidad.Pais;
import com.ragnax.politicacomercial.entidad.TipoCambio;
import com.ragnax.politicacomercial.entidad.TipoMoneda;

@XmlRootElement(name="politicaComercial")
public class PoliticaComercial implements Serializable{

	private static final long serialVersionUID = -4301293450469130528L;
	
	private HistorialTipoCambio historialTipoCambio;
	private TipoCambio tipoCambio;
	private TipoMoneda tipoMoneda;
	private Pais pais;
	private HistorialFeeComision historialFeeComision;
	private ProductoFeeComision productoFeeComision;
	private TipoFeeComision tipoFeeComision;
	private TipoNegocio tipoNegocio;
	private TipoValorComision tipoValorComision;
	
	private List<HistorialTipoCambio> listaHistorialTipoCambio;
	private List<TipoCambio> listaTipoCambio;
	private List<TipoMoneda> listaTipoMoneda;
	private List<Pais> listaPais;
	private List<HistorialFeeComision> listaHistorialFeeComision;
	private List<ProductoFeeComision> listaProductoFeeComision;
	private List<TipoFeeComision> listaTipoFeeComision;
	private List<TipoNegocio> listaTipoNegocio;
	private List<TipoValorComision> listaTipoValorComision;
	
	public PoliticaComercial() {
		super();
	}

	public HistorialTipoCambio getHistorialTipoCambio() {
		return historialTipoCambio;
	}

	public void setHistorialTipoCambio(HistorialTipoCambio historialTipoCambio) {
		this.historialTipoCambio = historialTipoCambio;
	}

	public TipoCambio getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(TipoCambio tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(TipoMoneda tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public HistorialFeeComision getHistorialFeeComision() {
		return historialFeeComision;
	}

	public void setHistorialFeeComision(HistorialFeeComision historialFeeComision) {
		this.historialFeeComision = historialFeeComision;
	}

	public ProductoFeeComision getProductoFeeComision() {
		return productoFeeComision;
	}

	public void setProductoFeeComision(ProductoFeeComision productoFeeComision) {
		this.productoFeeComision = productoFeeComision;
	}

	public TipoFeeComision getTipoFeeComision() {
		return tipoFeeComision;
	}

	public void setTipoFeeComision(TipoFeeComision tipoFeeComision) {
		this.tipoFeeComision = tipoFeeComision;
	}

	public TipoNegocio getTipoNegocio() {
		return tipoNegocio;
	}

	public void setTipoNegocio(TipoNegocio tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	public TipoValorComision getTipoValorComision() {
		return tipoValorComision;
	}

	public void setTipoValorComision(TipoValorComision tipoValorComision) {
		this.tipoValorComision = tipoValorComision;
	}

	public List<HistorialTipoCambio> getListaHistorialTipoCambio() {
		return listaHistorialTipoCambio;
	}

	public void setListaHistorialTipoCambio(List<HistorialTipoCambio> listaHistorialTipoCambio) {
		this.listaHistorialTipoCambio = listaHistorialTipoCambio;
	}

	public List<TipoCambio> getListaTipoCambio() {
		return listaTipoCambio;
	}

	public void setListaTipoCambio(List<TipoCambio> listaTipoCambio) {
		this.listaTipoCambio = listaTipoCambio;
	}

	public List<TipoMoneda> getListaTipoMoneda() {
		return listaTipoMoneda;
	}

	public void setListaTipoMoneda(List<TipoMoneda> listaTipoMoneda) {
		this.listaTipoMoneda = listaTipoMoneda;
	}

	public List<Pais> getListaPais() {
		return listaPais;
	}

	public void setListaPais(List<Pais> listaPais) {
		this.listaPais = listaPais;
	}

	public List<HistorialFeeComision> getListaHistorialFeeComision() {
		return listaHistorialFeeComision;
	}

	public void setListaHistorialFeeComision(List<HistorialFeeComision> listaHistorialFeeComision) {
		this.listaHistorialFeeComision = listaHistorialFeeComision;
	}

	public List<ProductoFeeComision> getListaProductoFeeComision() {
		return listaProductoFeeComision;
	}

	public void setListaProductoFeeComision(List<ProductoFeeComision> listaProductoFeeComision) {
		this.listaProductoFeeComision = listaProductoFeeComision;
	}

	public List<TipoFeeComision> getListaTipoFeeComision() {
		return listaTipoFeeComision;
	}

	public void setListaTipoFeeComision(List<TipoFeeComision> listaTipoFeeComision) {
		this.listaTipoFeeComision = listaTipoFeeComision;
	}

	public List<TipoNegocio> getListaTipoNegocio() {
		return listaTipoNegocio;
	}

	public void setListaTipoNegocio(List<TipoNegocio> listaTipoNegocio) {
		this.listaTipoNegocio = listaTipoNegocio;
	}

	public List<TipoValorComision> getListaTipoValorComision() {
		return listaTipoValorComision;
	}

	public void setListaTipoValorComision(List<TipoValorComision> listaTipoValorComision) {
		this.listaTipoValorComision = listaTipoValorComision;
	}
	
	
}
