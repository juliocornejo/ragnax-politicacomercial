package com.ragnax.politicacomercial.servicio.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.ragnax.politicacomercial.entidad.ProductoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoCambio;

public class PoliticaComercialUtilidades {


	public static List<String> crearListaCadenaCodigoTipoCambio(TipoCambio objTipoCambio){

		List<String> listaCadena = new ArrayList<String>();
		
		String codigoTipoCambio = objTipoCambio.getIdTipoMonedaBase().getIdTipoMoneda()
				+""+objTipoCambio.getIdTipoMonedaCambio().getIdTipoMoneda();
		codigoTipoCambio = codigoTipoCambio.trim();
		codigoTipoCambio = codigoTipoCambio.replace("\\s", "").replace(" ", "");
		codigoTipoCambio = codigoTipoCambio.toLowerCase();

		listaCadena.add(codigoTipoCambio);

		return listaCadena;
	}
	
	public static List<String> crearListaCadenaCodigoProductoFeeComision(ProductoFeeComision objProductoFeeComision){

		List<String> listaCadena = new ArrayList<String>();
		
		String codigoProductoFeeComision = objProductoFeeComision.getIdTipoNegocio().getIdTipoNegocio()
				+""+objProductoFeeComision.getIdTipoFeeComision().getIdTipoFeeComision();
		codigoProductoFeeComision = codigoProductoFeeComision.trim();
		codigoProductoFeeComision = codigoProductoFeeComision.replace("\\s", "").replace(" ", "");
		codigoProductoFeeComision = codigoProductoFeeComision.toLowerCase();

		codigoProductoFeeComision = objProductoFeeComision.getIdPais().getCodigoPortalPaisLowerCase()+""+
				objProductoFeeComision.getNombreProductoServicio();

		listaCadena.add(codigoProductoFeeComision);

		return listaCadena;
	}
	
	public static List<String> convertirStrFechaConFormatToTimestamp(String sFecha, String formato){

		List<String> listaCadena = new ArrayList<String>(); 

		listaCadena.add(sFecha);

		listaCadena.add(formato);

		return listaCadena;

	}

//	public String obtenerCodigoProductoFeeComision(ProductoFeeComision objProductoFeeComision){
//
//		List<String> listaCadena = new ArrayList<String>(); 
//
//		try {
//			if(objProductoFeeComision.getIdTipoFeeComision().getIdTipoFeeComision()>0 &&
//					objProductoFeeComision.getIdTipoNegocio().getIdTipoNegocio() >0 &&
//					objProductoFeeComision.getIdPais().getCodigoPortalPaisLowerCase()!=null && 
//					objProductoFeeComision.getNombreProductoServicio()!=null) {
//				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.
//
//				String codigoProductoFeeComision = objProductoFeeComision.getIdTipoNegocio().getIdTipoNegocio()
//						+""+objProductoFeeComision.getIdTipoFeeComision().getIdTipoFeeComision();
//				codigoProductoFeeComision = codigoProductoFeeComision.trim();
//				codigoProductoFeeComision = codigoProductoFeeComision.replace("\\s", "").replace(" ", "");
//				codigoProductoFeeComision = codigoProductoFeeComision.toLowerCase();
//
//				String encriptar = objProductoFeeComision.getIdPais().getCodigoPortalPaisLowerCase()+""+
//						objProductoFeeComision.getNombreProductoServicio();
//
//				listaCadena.add(encriptar);
//				//				codigoProductoFeeComision = zapalaClienteRest.generarCodigoByNumeroByEncodear(new GeneraCodigo(codigoProductoFeeComision, encriptar)).getData().getCodigoGenerado();
//				return zapalaClienteRest.generarCodigoByNumeroByEncodear(new ZapalaRequest(listaCadena)).getCodigoGenerado();
//
//				//				return codigoProductoFeeComision;
//			}
//
//		} catch (Exception e) {
//			return null;
//		}
//
//		return null;
//	}

//	public Timestamp convertirStrFechaConFormatToTimestamp(String sFecha, String formato){
//
//		List<String> listaCadena = new ArrayList<String>(); 
//
//		try {
//
//			listaCadena.add(sFecha);
//
//			listaCadena.add(formato);
//
//			return  zapalaClienteRest.convertirStrFechaConFormatToTimestamp(new ZapalaRequest(listaCadena)).getTiempoStrtoTimeStamp();
//
//		} catch (Exception e) {
//			System.out.println(e);
//			return null;
//		}
//	}

} 
