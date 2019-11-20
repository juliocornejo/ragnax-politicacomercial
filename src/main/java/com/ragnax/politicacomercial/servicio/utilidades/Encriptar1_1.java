package com.ragnax.politicacomercial.servicio.utilidades;

import java.util.HashMap;
import java.util.Map;

public class Encriptar1_1 {
	
	public static String generarCodigoByNumero (String simpleCambio) throws Exception{

		try {
			Map<String, String> mapaCambio = new HashMap<String, String>();

			String[] respuesta = new String[simpleCambio.length()];

			String[] arraySplit = simpleCambio.split("");

			mapaCambio.put("1","U");
			mapaCambio.put("2","D");
			mapaCambio.put("3","T");
			mapaCambio.put("4","F");
			mapaCambio.put("5","C");
			mapaCambio.put("6","S");
			mapaCambio.put("7","E");
			mapaCambio.put("8","O");
			mapaCambio.put("9","N");
			mapaCambio.put("0","Z");

			for(int i=0; i < arraySplit.length; i++) {
				respuesta[i] = mapaCambio.get(arraySplit[i]);
			}
			return String.join("", respuesta);
			
		}
		catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public static String generarCodigoByNumeroByEncodear (String simpleCambio, String textoEncodear) throws Exception{

		try {
			Map<String, String> mapaCambio = new HashMap<String, String>();

			String[] respuesta = new String[simpleCambio.length()];

			String[] arraySplit = simpleCambio.split("");

			mapaCambio.put("1","U");
			mapaCambio.put("2","D");
			mapaCambio.put("3","T");
			mapaCambio.put("4","F");
			mapaCambio.put("5","C");
			mapaCambio.put("6","S");
			mapaCambio.put("7","E");
			mapaCambio.put("8","O");
			mapaCambio.put("9","N");
			mapaCambio.put("0","Z");

			for(int i=0; i < arraySplit.length; i++) {
				respuesta[i] = mapaCambio.get(arraySplit[i]);
			}
			return String.join("", respuesta)+"-"+SimpleDecodificacion.getBase64(textoEncodear);
			
		}
		catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
}
