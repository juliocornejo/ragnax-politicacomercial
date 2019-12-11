package com.ragnax.politicacomercial.servicio;

import com.ragnax.politicacomercial.controller.response.PoliticaComercial;
import com.ragnax.politicacomercial.entidad.HistorialFeeComision;
import com.ragnax.politicacomercial.entidad.HistorialTipoCambio;
import com.ragnax.politicacomercial.entidad.Pais;
import com.ragnax.politicacomercial.entidad.ProductoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoCambio;
import com.ragnax.politicacomercial.entidad.TipoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoMoneda;
import com.ragnax.politicacomercial.entidad.TipoNegocio;
import com.ragnax.politicacomercial.entidad.TipoValorComision;
import com.ragnax.politicacomercial.exception.LogicaImplException;

public interface PoliticaComercialService {
	
	
	public PoliticaComercial crearTipoMoneda(TipoMoneda objTipoMoneda) throws LogicaImplException;
	public PoliticaComercial actualizarTipoMoneda(Integer id, TipoMoneda objTipoMoneda) throws LogicaImplException;
	public PoliticaComercial buscarTipoMoneda(TipoMoneda objTipoMoneda) throws LogicaImplException;
	public PoliticaComercial listarTodoTipoMoneda() throws LogicaImplException;

	public PoliticaComercial crearTipoNegocio(TipoNegocio objTipoNegocio) throws LogicaImplException;
	public PoliticaComercial actualizarTipoNegocio(Integer id, TipoNegocio objTipoNegocio) throws LogicaImplException;
	public PoliticaComercial buscarTipoNegocio(TipoNegocio objTipoNegocio) throws LogicaImplException;
	public PoliticaComercial listarTodoTipoNegocio() throws LogicaImplException;
	
	public PoliticaComercial crearTipoFeeComision(TipoFeeComision objTipoFeeComision) throws LogicaImplException;
	public PoliticaComercial actualizarTipoFeeComision(Integer id, TipoFeeComision objTipoFeeComision) throws LogicaImplException;
	public PoliticaComercial buscarTipoFeeComision(TipoFeeComision objTipoFeeComision) throws LogicaImplException;
	public PoliticaComercial listarTodoTipoFeeComision() throws LogicaImplException;
	
	public PoliticaComercial crearTipoValorComision(TipoValorComision objTipoValorComision) throws LogicaImplException;
	public PoliticaComercial buscarTipoValorComision(TipoValorComision objTipoValorComision) throws LogicaImplException;
	public PoliticaComercial listarTodoTipoValorComision() throws LogicaImplException;
	
	public PoliticaComercial crearPais(Pais objPais) throws LogicaImplException;
	public PoliticaComercial actualizarPais(String codigoportal, Pais objPais) throws LogicaImplException;
	public PoliticaComercial buscarPaisxCodigoPortal(Pais objPais) throws LogicaImplException;
	public PoliticaComercial listarTodoPais() throws LogicaImplException;
	
	public PoliticaComercial generarCodigoTipoCambio(TipoCambio objTipoCambio) throws LogicaImplException;
	public PoliticaComercial crearTipoCambio(TipoCambio objTipoCambio) throws LogicaImplException;
	public PoliticaComercial buscarTipoCambioxCodigo(TipoCambio objTipoCambio) throws LogicaImplException;
	public PoliticaComercial listarTodoTipoCambio() throws LogicaImplException;
	public PoliticaComercial listarTipoCambioxTipoMonedaBase(TipoCambio objTipoCambio) throws LogicaImplException;
	
	public PoliticaComercial generarNuevoCodigoProductoFeeComision(ProductoFeeComision objProductoFeeComision) throws LogicaImplException;
	public PoliticaComercial crearProductoFeeComision(ProductoFeeComision objProductoFeeComision) throws LogicaImplException;
	public PoliticaComercial actualizarProductoFeeComision(String codigoProductoFeeComision,ProductoFeeComision objProductoFeeComision) throws LogicaImplException;
//	public PoliticaComercial buscarProductoFeeComisionxTipoNegocioxTipoFeexCodigoProductoServicio(ProductoFeeComision objProductoFeeComision) throws LogicaImplException;
	public PoliticaComercial buscarProductoFeeComisionxCodigoProductoServicio(ProductoFeeComision objProductoFeeComision) throws LogicaImplException;
	public PoliticaComercial listarTodoProductoFeeComision() throws LogicaImplException;
	public PoliticaComercial listarProductoFeeComisionxTipoNegocioxEstado(ProductoFeeComision objProductoFeeComision) throws LogicaImplException;
	
	public PoliticaComercial crearHistorialTipoCambio(HistorialTipoCambio objHistorialTipoCambio) throws LogicaImplException;
    public PoliticaComercial buscarHistorialTipoCambioxTipoCambioxActivo(HistorialTipoCambio objHistorialTipoCambio) throws LogicaImplException;
    public PoliticaComercial listarTodoHistorialTipoCambio() throws LogicaImplException;
    public PoliticaComercial listarHistorialTipoCambioxActivo() throws LogicaImplException;
	public PoliticaComercial listarHistorialTipoCambioxTipoCambioEntreFechas(String codigoTipoCambio, String sFechaInicial, String sFechaFinal) throws LogicaImplException;
	
	public PoliticaComercial crearHistorialFeeComision(HistorialFeeComision objHistorialFeeComision) throws LogicaImplException;
	public PoliticaComercial buscarHistorialFeeComisionxProductoFeeComisionxActivo(HistorialFeeComision objHistorialFeeComision) throws LogicaImplException;
	public PoliticaComercial listarTodoHistorialFeeComision() throws LogicaImplException;
	public PoliticaComercial listarHistorialFeeComisionxActivo() throws LogicaImplException;
	public PoliticaComercial listarHistorialFeeComisionxProductoFeeComisionEntreFechas(String codigoProductoServicio, String sFechaInicial, String sFechaFinal) throws LogicaImplException;
	
	
	/**************************/
	/******Se Puede buscar solo por el codigo****/
	
	
	
	public void limpiarCacheLocal();
	
}
