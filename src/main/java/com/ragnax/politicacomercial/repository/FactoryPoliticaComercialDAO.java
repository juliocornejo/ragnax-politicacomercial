package com.ragnax.politicacomercial.repository;



public interface FactoryPoliticaComercialDAO {
	
//	public FeeComisionRepository getFeeComisionRepository();
	
	public TipoMonedaRepository getTipoMonedaRepository();
	public PaisRepository getPaisRepository();
	public TipoCambioRepository getTipoCambioRepository();
	public HistorialTipoCambioRepository getHistorialTipoCambioRepository();
	public HistorialFeeComisionRepository getHistorialFeeComisionRepository();
	public ProductoFeeComisionRepository getProductoFeeComisionRepository();
	public TipoFeeComisionRepository getTipoFeeComisionRepository();
	public TipoNegocioRepository getTipoNegocioRepository();
	public TipoValorComisionRepository getTipoValorComisionRepository();
	
}
