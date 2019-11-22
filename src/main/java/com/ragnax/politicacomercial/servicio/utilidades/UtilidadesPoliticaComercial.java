package com.ragnax.politicacomercial.servicio.utilidades;

import java.time.Duration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ragnax.politicacomercial.entidad.ProductoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoCambio;

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
	
	public static String limpiarPatronRUT(String textoRUT)  {
		try {
			
			textoRUT = textoRUT.replace(".", "");
			textoRUT = textoRUT.replace("-", "");

			return textoRUT;
		} catch (Exception e) {
			return "";
		}
	}
	
	public static String generarPatronRUT(String textoRUT)  {
		try {
			textoRUT = limpiarPatronRUT(textoRUT);
			
			int cont = 0;
			
			String rutFormateado = "-" + textoRUT.substring(textoRUT.length() - 1);
	        
			for (int i = textoRUT.length() - 2; i >= 0; i--) {
				rutFormateado = textoRUT.substring(i, i + 1) + rutFormateado;
	            cont++;
	            if (cont == 3 && i != 0) {
	            	rutFormateado = "." + rutFormateado;
	                cont = 0;
	            }
	        }
	        return rutFormateado;

		} catch (Exception e) {
			return "";
		}
	}
	
	public static <T> Object convertirJsonToObject(String string, Class<T> typeResponse ) throws Exception
	{	

		return new ObjectMapper().readValue(string, typeResponse);
		
	}
	
	public static String generarTiempoDuracion(Duration duration){
		try{
			return duration.getSeconds()+","+duration.getNano();
		}catch(Exception e){
			
		}
		return null;
		
	}
} 
