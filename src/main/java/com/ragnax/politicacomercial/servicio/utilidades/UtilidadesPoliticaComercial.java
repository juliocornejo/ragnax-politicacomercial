package com.ragnax.politicacomercial.servicio.utilidades;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.Duration;
import org.joda.time.LocalDateTime;

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
			return duration.getStandardSeconds()+","+duration.getMillis();
		}catch(Exception e){
			
		}
		return null;
		
	}
	
	public static Timestamp convertirStrFechaConFormatToTimestamp(String sFecha, String formato) {
		//    	SimpleDateFormat formatInicial = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); 2019-10-22T10:30:00
		
		Timestamp retorno = new Timestamp(new Date().getTime());
		
		if(isValidDate(sFecha, formato)){
			try{

				int ano1 = Integer.parseInt(sFecha.substring(0, 4));
				int mes1 = Integer.parseInt(sFecha.substring(5, 7));
				int dia1 = Integer.parseInt(sFecha.substring(8, 10));
				int hora1 = Integer.parseInt(sFecha.substring(11, 13));
				int minuto1 = Integer.parseInt(sFecha.substring(14, 16));
				int seg1 = Integer.parseInt(sFecha.substring(17, 19));
				
				retorno = new Timestamp(new LocalDateTime(ano1, mes1, dia1, hora1, minuto1, seg1).toDate().getTime());

			}catch(Exception e){
				
			}
		}else{
			
		}

		return retorno;
	}
	
	public static boolean isValidDate(String value, String strFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(strFormat);
		try{
			sdf.setLenient(false);
			sdf.parse(value);
			return true;
		}
		catch(ParseException e){
			return false;
		}
	}
	
	Date fechaFinal = new LocalDateTime(2019, 12, 31, 0, 0, 1).toDate();
} 
