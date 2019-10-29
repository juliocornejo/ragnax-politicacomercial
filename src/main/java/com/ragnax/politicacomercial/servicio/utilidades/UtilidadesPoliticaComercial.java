package com.ragnax.politicacomercial.servicio.utilidades;

import com.ragnax.politicacomercial.entidad.ProductoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoCambio;

import vijnana.utilidades.component.utilidades.excriptar.Encriptar1_1;

public class UtilidadesPoliticaComercial {

	public static String obtenerCodigoTipoCambio(TipoCambio objTipoCambio){

		try {
			if(objTipoCambio.getIdTipoMonedaBase().getIdTipoMoneda()>0 &&
					objTipoCambio.getIdTipoMonedaCambio().getIdTipoMoneda() >0) {
				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.

				String codigoTipoCambio = objTipoCambio.getIdTipoMonedaBase().getIdTipoMoneda()
						+""+objTipoCambio.getIdTipoMonedaCambio().getIdTipoMoneda();
				codigoTipoCambio = codigoTipoCambio.trim();
				codigoTipoCambio = codigoTipoCambio.replace("\\s", "").replace(" ", "");
				codigoTipoCambio = codigoTipoCambio.toLowerCase();
				
				
				codigoTipoCambio = Encriptar1_1.generarCodigoByNumero(codigoTipoCambio);
				
				return codigoTipoCambio;
			}

		} catch (Exception e) {
			return null;
		}

		return null;
	}
	
	public static String obtenerCodigoProductoFeeComision(ProductoFeeComision objProductoFeeComision){
		
		
		try {
			if(objProductoFeeComision.getIdTipoFeeComision().getIdTipoFeeComision()>0 &&
					objProductoFeeComision.getIdTipoNegocio().getIdTipoNegocio() >0 &&
					objProductoFeeComision.getIdPais().getCodigoPortalPaisLowerCase()!=null && 
					objProductoFeeComision.getNombreProductoServicio()!=null) {
				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.

				String codigoProductoFeeComision = objProductoFeeComision.getIdTipoNegocio().getIdTipoNegocio()
							+""+objProductoFeeComision.getIdTipoFeeComision().getIdTipoFeeComision();
				codigoProductoFeeComision = codigoProductoFeeComision.trim();
				codigoProductoFeeComision = codigoProductoFeeComision.replace("\\s", "").replace(" ", "");
				codigoProductoFeeComision = codigoProductoFeeComision.toLowerCase();
				
				String encriptar = objProductoFeeComision.getIdPais().getCodigoPortalPaisLowerCase()+""+
									objProductoFeeComision.getNombreProductoServicio();
				
				codigoProductoFeeComision = Encriptar1_1.generarCodigoByNumeroByEncodear(codigoProductoFeeComision, encriptar);
				
				return codigoProductoFeeComision;
			}

		} catch (Exception e) {
			return null;
		}

		return null;
	}
} 
