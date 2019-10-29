package com.ragnax.politicacomercial.repository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

@Repository
public class FactoryPoliticaComercialDAOImpl implements FactoryPoliticaComercialDAO {
	
	@Autowired
	private TipoMonedaRepository tipoMonedaRepository;	
	
	public TipoMonedaRepository getTipoMonedaRepository() {
		return tipoMonedaRepository;
	}
	
	@Autowired
	private PaisRepository paisRepository;	
	
	public PaisRepository getPaisRepository() {
		return paisRepository;
	}
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;	
	
	public TipoCambioRepository getTipoCambioRepository() {
		return tipoCambioRepository;
	}
	
	@Autowired
	private HistorialTipoCambioRepository historialTipoCambioRepository;	
	
	public HistorialTipoCambioRepository getHistorialTipoCambioRepository() {
		return historialTipoCambioRepository;
	}
	
	@Autowired
	private HistorialFeeComisionRepository historialFeeComisionRepository;	
	
	public HistorialFeeComisionRepository getHistorialFeeComisionRepository() {
		return historialFeeComisionRepository;
	}
	
	@Autowired
	private ProductoFeeComisionRepository productoFeeComisionRepository;	
	
	public ProductoFeeComisionRepository getProductoFeeComisionRepository() {
		return productoFeeComisionRepository;
	}
	
	@Autowired
	private TipoFeeComisionRepository tipoFeeComisionRepository;	
	
	public TipoFeeComisionRepository getTipoFeeComisionRepository() {
		return tipoFeeComisionRepository;
	}
	
	@Autowired
	private TipoNegocioRepository tipoNegocioRepository;	
	
	public TipoNegocioRepository getTipoNegocioRepository() {
		return tipoNegocioRepository;
	}
	
	@Autowired
	private TipoValorComisionRepository tipoValorComisionRepository;	
	
	public TipoValorComisionRepository getTipoValorComisionRepository() {
		return tipoValorComisionRepository;
	}
}
