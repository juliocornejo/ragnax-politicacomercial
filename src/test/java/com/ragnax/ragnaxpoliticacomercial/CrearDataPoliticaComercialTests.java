package com.ragnax.ragnaxpoliticacomercial;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ragnax.politicacomercial.RagnaxPoliticacomercialApplication;
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
import com.ragnax.politicacomercial.servicio.FactoryPoliticaComercialService;

@RunWith(SpringRunner.class)

@SpringBootTest(classes = RagnaxPoliticacomercialApplication.class)
public class CrearDataPoliticaComercialTests {
	
	@Autowired
    private FactoryPoliticaComercialService factoryPoliticaComercialService;


	@Test
	public void  crearDataPoliticaComercial() throws LogicaImplException {
		crearTipoMonedaTest();
		crearTipoNegocioTest();
		crearTipoFeeComisionTest();
		crearTipoValorComisionTest();
		crearPaisTest();
		crearTipoCambioTest();
		crearProductoTipoFeeComisionTest();
		crearHistorialTipoCambioTest();
		crearHistorialFeeComisionTest();
	}

	
	public void crearTipoMonedaTest() throws LogicaImplException {
		
		TipoMoneda tipoMonedaA = new TipoMoneda("usd".toUpperCase(), "Dolar estadounidense", "$");
		TipoMoneda tipoMonedaB = new TipoMoneda("CLP".toUpperCase(), "Peso chileno", "$");
		TipoMoneda tipoMonedaC = new TipoMoneda("ARS".toUpperCase(), "Peso Argentino", "$");
		TipoMoneda tipoMonedaD = new TipoMoneda("COP".toUpperCase(), "Peso Colombiano", "$");
		TipoMoneda tipoMonedaE = new TipoMoneda("PER".toUpperCase(), "Sol Peruano", "S/.");
		
		factoryPoliticaComercialService.crearTipoMoneda(tipoMonedaA);
		factoryPoliticaComercialService.crearTipoMoneda(tipoMonedaB);
		factoryPoliticaComercialService.crearTipoMoneda(tipoMonedaC);
		factoryPoliticaComercialService.crearTipoMoneda(tipoMonedaD);
		factoryPoliticaComercialService.crearTipoMoneda(tipoMonedaE);
		
	}
	
	public void crearTipoNegocioTest() throws LogicaImplException {
		try {
		TipoNegocio tipoNegocioA = new TipoNegocio(null, "arrastramegrua", true);
		TipoNegocio tipoNegocioB = new TipoNegocio(null, "arrastrametrip", true);
		TipoNegocio tipoNegocioC = new TipoNegocio(null, "retailbbb", true);
		
		factoryPoliticaComercialService.crearTipoNegocio(tipoNegocioA);
		factoryPoliticaComercialService.crearTipoNegocio(tipoNegocioB);
		factoryPoliticaComercialService.crearTipoNegocio(tipoNegocioC);
		}catch(Exception e) {
			
		}
		
	}
	
	public void crearTipoFeeComisionTest() throws LogicaImplException {
		
		try {
		TipoFeeComision tipoFeeComisionA = new TipoFeeComision("proveedor", true);
		TipoFeeComision tipoFeeComisionB = new TipoFeeComision("consumidor", true);
		
		factoryPoliticaComercialService.crearTipoFeeComision(tipoFeeComisionA);
		factoryPoliticaComercialService.crearTipoFeeComision(tipoFeeComisionB);
		} catch(Exception e) {
			
		}
		
	}
	
	public void crearTipoValorComisionTest() throws LogicaImplException {
		
		try {
		TipoValorComision tipoValorComisionA = new TipoValorComision(null, "nominal", 999);
		TipoValorComision tipoValorComisionB = new TipoValorComision(null, "porciento", 2);
		
		factoryPoliticaComercialService.crearTipoValorComision(tipoValorComisionA);
		factoryPoliticaComercialService.crearTipoValorComision(tipoValorComisionB);
		} catch(Exception e) {
			
		}
	}
	
	public void crearPaisTest() throws LogicaImplException {
		
		Pais[] arreglo = new Pais[1000]; 
		
		int i=0;
		
		/**Sudamerica****/
		arreglo[i] =  new Pais("Chile", "CL".toLowerCase(),true, new TipoMoneda(2)); i = i+1;
		arreglo[i] =  new Pais("Argentina", "AR".toLowerCase(),true, new TipoMoneda(3)); i = i+1;
		arreglo[i] =  new Pais("Colombia", "CO".toLowerCase(),true, new TipoMoneda(4)); i = i+1;
		arreglo[i] =  new Pais("Perú", "PE".toLowerCase(),true, new TipoMoneda(5)); i = i+1;
		arreglo[i] =  new Pais("Bolivia", "BO".toLowerCase(),true, null); i = i+1;
		arreglo[i] =  new Pais("Brasil", "BR".toLowerCase(),true, null); i = i+1;
		arreglo[i] =  new Pais("Ecuador", "EC".toLowerCase(),true, null); i = i+1;
		arreglo[i] =  new Pais("Paraguay", "PY".toLowerCase(),true, null); i = i+1;
		arreglo[i] =  new Pais("Uruguay", "UY".toLowerCase(),true, null); i = i+1;
		arreglo[i] =  new Pais("Venezuela", "VE".toLowerCase(),true, null); i = i+1;
//		arreglo[i] =  new Pais("Guyana", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Suriname", "",true, null); i = i+1;
		
		/**CentroAmerica - NorteAmerica****/
//		arreglo[i] =  new Pais("Aruba", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Antigua y Barbuda", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bahamas", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Barbados", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Belice", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bermudas", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Canadá", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Costa Rica", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Cuba", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Curacao", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Dominica", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("El Salvador", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Estados Unidos", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Granada", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Groenlandia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Guatemala", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Haití", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Honduras", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Islas Caimán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Islas Turcas y Caicos", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Islas Vírgenes Británicas", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Islas Vírgenes (EE.UU.)", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Jamaica", "",true, null); i = i+1;
		arreglo[i] =  new Pais("México", "MX".toLowerCase(),true, null); i = i+1;
//		arreglo[i] =  new Pais("Nicaragua", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Panamá", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Puerto Rico", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("República Dominicana", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Saint Kitts y Nevis", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Santa Lucía", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("San Vicente y las Granadinas", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Trinidad y Tobago", "",true, null); i = i+1;

		/**Europa****/
//		arreglo[i] =  new Pais("Albania", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Alemania", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Andorra", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Armenia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Austria", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Azerbaiyán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Belarús", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bélgica", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bosnia y Herzegovina", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bulgaria", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Chipre", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Croacia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Dinamarca", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("España", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Eslovenia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Estonia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Federación de Rusia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Finlandia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Francia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Georgia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Grecia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Hungría", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Irlanda", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Islandia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Islas Feroe", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Italia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Kosovo", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Letonia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Liechtenstein", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Lituania", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Luxemburgo", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Malta", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Moldovia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Mónaco", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Montenegro", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Noruega", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Países Bajos", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Polonia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Portugal", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Reino Unido", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Rumania", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("San Marino", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Serbia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("República Checa", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("República Eslovaca", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Suecia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Suiza", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Ucrania", "",true, null); i = i+1;
		
		/**Asia****/
//		arreglo[i] =  new Pais("Afganistán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Arabia Saudita", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bahrein", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bangladesh", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Bhután", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Brunei Darussalam", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Camboya", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("China", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Comoras", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Corea del Norte", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Corea del Sur", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Emiratos Árabes Unidos", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Filipinas", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Hong Kong, Región Administrativa Especial", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("India", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Indonesia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Iraq", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Irán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Israel", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Japón", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Jordania", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Kazajstán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Kirguistán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Kuwait", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Laos", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Líbano", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Macao,  Región Administrativa Especial", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Malasia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Maldivas", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Mongolia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Myanmar", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Nepal", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Omán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Palestina (Ribera Occidental y Gaza)", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Pakistán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Qatar", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Singapur", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Siria", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Sri Lanka", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Tailandia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Tayikistán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Timor-Leste", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Turkmenistán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Turquía", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Uzbekistán", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Viet Nam", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Yemen", "",true, null); i = i+1;
		
		/**Africa****/
//		arreglo[i] =  new Pais("Angola", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Argelia", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Burundi", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Benin", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Burkina Faso", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Botswana", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Cabo Verde", "",true, null); i = i+1;
//		arreglo[i] =  new Pais("Camerún", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Chad", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Costa de Marfil", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Djibouti", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Egipto", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Eritrea", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Etiopía", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Gabón", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Gambia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Ghana", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Guinea", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Guinea-Bissau", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Guinea Ecuatorial", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Kenya", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Lesotho", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Liberia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Libia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Madagascar", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Malawi", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Malí", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Mauricio", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Mauritania", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Marruecos", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Mozambique", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Namibia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Níger", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Nigeria", "",true, null); i = i+1;
//		arreglo[i] = new Pais("República Centroafricana", "",true, null); i = i+1;
//		arreglo[i] = new Pais("República del Congo", "",true, null); i = i+1;
//		arreglo[i] = new Pais("República Democrática del Congo", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Rwanda", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Santo Tomé y Príncipe", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Senegal", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Seychelles", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Sierra Leona", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Somalia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Sudáfrica", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Sudán", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Sudán del Sur", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Swazilandia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Tanzanía", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Togo", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Túnez", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Uganda", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Zambia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Zimbabwe", "",true, null); i = i+1;

		/**Oceania****/

//		arreglo[i] = new Pais("Australia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Fiji", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Guam", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Islas Marshall", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Islas Salomón", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Kiribati", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Mariana", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Micronesia (Estados Federados de)", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Nauru", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Nueva Caledonia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Nueva Zelandia", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Palau", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Papua Nueva Guinea", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Polinesia Francesa", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Samoa", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Samoa Americana", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Tonga", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Tuvalu", "",true, null); i = i+1;
//		arreglo[i] = new Pais("Vanuatu", "",true, null);
		
		
		System.out.println("paises[i]:"+i);

		for(int j=0; j< arreglo.length; j++){
			if(arreglo[j]!=null){
				try{
					factoryPoliticaComercialService.crearPais(arreglo[j]);
				}catch(Exception e){
					System.out.println("rechazo["+j+"] ->"+arreglo[j].getNombrePais());
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public void crearTipoCambioTest() throws LogicaImplException {
		
		TipoCambio tipoCambioA = new TipoCambio(new TipoMoneda(1), new TipoMoneda(2), "Dolar a Peso Chileno");
		TipoCambio tipoCambioB = new TipoCambio(new TipoMoneda(1), new TipoMoneda(3), "Dolar a Peso Colombiano");
		TipoCambio tipoCambioC = new TipoCambio(new TipoMoneda(1), new TipoMoneda(4), "Dolar a Peso Argentino");
		TipoCambio tipoCambioD = new TipoCambio(new TipoMoneda(1), new TipoMoneda(5), "Dolar a Sol");
		
		
		tipoCambioA = factoryPoliticaComercialService.generarCodigoTipoCambio(tipoCambioA).getTipoCambio();
		tipoCambioB = factoryPoliticaComercialService.generarCodigoTipoCambio(tipoCambioB).getTipoCambio();
		tipoCambioC = factoryPoliticaComercialService.generarCodigoTipoCambio(tipoCambioC).getTipoCambio();
		tipoCambioD = factoryPoliticaComercialService.generarCodigoTipoCambio(tipoCambioD).getTipoCambio();
		
		tipoCambioA = factoryPoliticaComercialService.crearTipoCambio(tipoCambioA).getTipoCambio();
		tipoCambioB = factoryPoliticaComercialService.crearTipoCambio(tipoCambioB).getTipoCambio();
		tipoCambioC = factoryPoliticaComercialService.crearTipoCambio(tipoCambioC).getTipoCambio();
		tipoCambioD = factoryPoliticaComercialService.crearTipoCambio(tipoCambioD).getTipoCambio();
		
		tipoCambioA = factoryPoliticaComercialService.buscarTipoCambioxCodigo(tipoCambioA).getTipoCambio();
		tipoCambioB = factoryPoliticaComercialService.buscarTipoCambioxCodigo(tipoCambioB).getTipoCambio();
		tipoCambioC = factoryPoliticaComercialService.buscarTipoCambioxCodigo(tipoCambioC).getTipoCambio();
		tipoCambioD = factoryPoliticaComercialService.buscarTipoCambioxCodigo(tipoCambioD).getTipoCambio();
		
		List<TipoCambio> listaTipoCambio = factoryPoliticaComercialService.listarTodoTipoCambio().getListaTipoCambio();
		System.out.println(listaTipoCambio);
		
		TipoCambio tipoCambioBase = new TipoCambio(new TipoMoneda(1), null, null);
		List<TipoCambio> listaTipoCambioMB = factoryPoliticaComercialService.listarTipoCambioxTipoMonedaBase(tipoCambioBase).getListaTipoCambio();
		System.out.println(listaTipoCambioMB);
		
	}
	
	public void crearProductoTipoFeeComisionTest() throws LogicaImplException {

		//Comision de cobro al proveedor,
		//Comision de cobro al consumidor ProductoFeeComision(Integer idProductoFeeComision, String nombreProductoServicio,
		try {
			ProductoFeeComision productoFeeComisionA = new ProductoFeeComision(new TipoNegocio(1), new TipoFeeComision(1), new Pais("cl"), "cobro arrastramegrua a proveedor");
			ProductoFeeComision productoFeeComisionB = new ProductoFeeComision(new TipoNegocio(1), new TipoFeeComision(2), new Pais("cl"), "cobro arrastramegrua a consumidor");
			ProductoFeeComision productoFeeComisionC = new ProductoFeeComision(new TipoNegocio(2), new TipoFeeComision(1), new Pais("cl"), "cobro arrastrametrip a proveedor");
			ProductoFeeComision productoFeeComisionD = new ProductoFeeComision(new TipoNegocio(2), new TipoFeeComision(2), new Pais("cl"), "cobro arrastrametrip a consumidor");
			ProductoFeeComision productoFeeComisionE = new ProductoFeeComision(new TipoNegocio(3), new TipoFeeComision(1), new Pais("cl"), "cobro retailbbb a proveedor");
			ProductoFeeComision productoFeeComisionF = new ProductoFeeComision(new TipoNegocio(3), new TipoFeeComision(2), new Pais("cl"), "cobro retailbbb a consumidor");

			productoFeeComisionA = factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(productoFeeComisionA).getProductoFeeComision();
			productoFeeComisionB = factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(productoFeeComisionB).getProductoFeeComision();
			productoFeeComisionC = factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(productoFeeComisionC).getProductoFeeComision();
			productoFeeComisionD = factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(productoFeeComisionD).getProductoFeeComision();
			productoFeeComisionE = factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(productoFeeComisionE).getProductoFeeComision();
			productoFeeComisionF = factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(productoFeeComisionF).getProductoFeeComision();

			factoryPoliticaComercialService.crearProductoFeeComision(productoFeeComisionA);
			factoryPoliticaComercialService.crearProductoFeeComision(productoFeeComisionB);
			factoryPoliticaComercialService.crearProductoFeeComision(productoFeeComisionC);
			factoryPoliticaComercialService.crearProductoFeeComision(productoFeeComisionD);
			factoryPoliticaComercialService.crearProductoFeeComision(productoFeeComisionE);
			factoryPoliticaComercialService.crearProductoFeeComision(productoFeeComisionF);

			productoFeeComisionA.setEstadoProductoFeeComision(false);
			productoFeeComisionB.setEstadoProductoFeeComision(false);
			productoFeeComisionC.setEstadoProductoFeeComision(false);
//			productoFeeComisionD.setEstadoProductoFeeComision(false);
//			productoFeeComisionE.setEstadoProductoFeeComision(false);
//			productoFeeComisionF.setEstadoProductoFeeComision(false);

			productoFeeComisionA = factoryPoliticaComercialService.actualizarProductoFeeComision(productoFeeComisionA.getCodigoProductoFeeComision(), productoFeeComisionA).getProductoFeeComision();
			productoFeeComisionB = factoryPoliticaComercialService.actualizarProductoFeeComision(productoFeeComisionB.getCodigoProductoFeeComision(), productoFeeComisionB).getProductoFeeComision();
			productoFeeComisionC = factoryPoliticaComercialService.actualizarProductoFeeComision(productoFeeComisionC.getCodigoProductoFeeComision(), productoFeeComisionC).getProductoFeeComision();
			productoFeeComisionD = factoryPoliticaComercialService.actualizarProductoFeeComision(productoFeeComisionD.getCodigoProductoFeeComision(), productoFeeComisionD).getProductoFeeComision();
			productoFeeComisionE = factoryPoliticaComercialService.actualizarProductoFeeComision(productoFeeComisionE.getCodigoProductoFeeComision(), productoFeeComisionE).getProductoFeeComision();
			productoFeeComisionF = factoryPoliticaComercialService.actualizarProductoFeeComision(productoFeeComisionF.getCodigoProductoFeeComision(), productoFeeComisionF).getProductoFeeComision();

			productoFeeComisionA = factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(productoFeeComisionA).getProductoFeeComision();
			productoFeeComisionB = factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(productoFeeComisionB).getProductoFeeComision();
			productoFeeComisionC = factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(productoFeeComisionC).getProductoFeeComision();
			productoFeeComisionD = factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(productoFeeComisionD).getProductoFeeComision();
			productoFeeComisionE = factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(productoFeeComisionE).getProductoFeeComision();
			productoFeeComisionF = factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(productoFeeComisionF).getProductoFeeComision();

			List<ProductoFeeComision> listaProductoFeeComision = factoryPoliticaComercialService.listarTodoProductoFeeComision().getListaProductoFeeComision();
			System.out.println(listaProductoFeeComision);

			ProductoFeeComision estadoProductoFeeComision = new ProductoFeeComision(new TipoNegocio(1), true);
			
			listaProductoFeeComision = factoryPoliticaComercialService.listarProductoFeeComisionxTipoNegocioxEstado(estadoProductoFeeComision).getListaProductoFeeComision();
			System.out.println(listaProductoFeeComision);

		}catch(Exception e) {

		}
	}
	
	public void crearHistorialTipoCambioTest() throws LogicaImplException {
		
		List<TipoCambio> listaTipoCambio = factoryPoliticaComercialService.listarTodoTipoCambio().getListaTipoCambio();
		
		HistorialTipoCambio historialTipoCambioA = new HistorialTipoCambio(listaTipoCambio.get(0), new BigDecimal(720));
		HistorialTipoCambio historialTipoCambioB = new HistorialTipoCambio(listaTipoCambio.get(1), new BigDecimal(2000));
		HistorialTipoCambio historialTipoCambioC = new HistorialTipoCambio(listaTipoCambio.get(2), new BigDecimal(70));
		HistorialTipoCambio historialTipoCambioD = new HistorialTipoCambio(listaTipoCambio.get(3), new BigDecimal(10));
		HistorialTipoCambio historialTipoCambioE = new HistorialTipoCambio(listaTipoCambio.get(0), new BigDecimal(711));
		HistorialTipoCambio historialTipoCambioF = new HistorialTipoCambio(listaTipoCambio.get(1), new BigDecimal(1985));
		
		factoryPoliticaComercialService.crearHistorialTipoCambio(historialTipoCambioA);
		factoryPoliticaComercialService.crearHistorialTipoCambio(historialTipoCambioB);
		factoryPoliticaComercialService.crearHistorialTipoCambio(historialTipoCambioC);
		factoryPoliticaComercialService.crearHistorialTipoCambio(historialTipoCambioD);
		factoryPoliticaComercialService.crearHistorialTipoCambio(historialTipoCambioE);
		factoryPoliticaComercialService.crearHistorialTipoCambio(historialTipoCambioF);
		
		historialTipoCambioA = factoryPoliticaComercialService.buscarHistorialTipoCambioxTipoCambioxActivo(historialTipoCambioA).getHistorialTipoCambio();
		
		List<HistorialTipoCambio> listaHistorialTipoCambio = factoryPoliticaComercialService.listarHistorialTipoCambioxActivo().getListaHistorialTipoCambio();
		System.out.println(listaHistorialTipoCambio);
		
		Date fechaInicial = new LocalDateTime(2019, 2, 1, 0, 0, 1).toDate(); 
		Date fechaFinal = new LocalDateTime(2019, 12, 31, 17, 16, 1).toDate();
		
		String strFormatoFechaYYYY_MM_ddTHH_MM_SSZ =  "yyyy-MM-dd'T'HH:mm:ss'Z'";
		SimpleDateFormat formatoFecha_YYYY_MM_DDTHHmmss = new SimpleDateFormat(strFormatoFechaYYYY_MM_ddTHH_MM_SSZ);
		
		System.out.println(fechaInicial);
		System.out.println(fechaFinal);
		
		listaHistorialTipoCambio = factoryPoliticaComercialService.listarHistorialTipoCambioxTipoCambioEntreFechas(
				listaTipoCambio.get(0).getCodigoTipoCambio(), formatoFecha_YYYY_MM_DDTHHmmss.format(fechaInicial),
				formatoFecha_YYYY_MM_DDTHHmmss.format(fechaFinal)).getListaHistorialTipoCambio();
		System.out.println(listaHistorialTipoCambio);
		
	}
	
	public void crearHistorialFeeComisionTest() throws LogicaImplException {

		List<ProductoFeeComision> listaProductoFeeComision = factoryPoliticaComercialService.listarTodoProductoFeeComision().getListaProductoFeeComision();
		
		//Comision de cobro al proveedor,
		//Comision de cobro al consumidor ProductoFeeComision fkIdProductoFeeComision,  TipoValorComision fkIdTipoValorComision, BigDecimal porcentajeFeeComision
		HistorialFeeComision historialFeeComisionA = new HistorialFeeComision(listaProductoFeeComision.get(0), new TipoValorComision(1), new BigDecimal(800));
		HistorialFeeComision historialFeeComisionB = new HistorialFeeComision(listaProductoFeeComision.get(1), new TipoValorComision(2), new BigDecimal(1.9));
		HistorialFeeComision historialFeeComisionC = new HistorialFeeComision(listaProductoFeeComision.get(2), new TipoValorComision(1), new BigDecimal(700));
		HistorialFeeComision historialFeeComisionD = new HistorialFeeComision(listaProductoFeeComision.get(0), new TipoValorComision(2), new BigDecimal(1.8));

		factoryPoliticaComercialService.crearHistorialFeeComision(historialFeeComisionA);
		factoryPoliticaComercialService.crearHistorialFeeComision(historialFeeComisionB);
		factoryPoliticaComercialService.crearHistorialFeeComision(historialFeeComisionC);
		factoryPoliticaComercialService.crearHistorialFeeComision(historialFeeComisionD);

		historialFeeComisionA = factoryPoliticaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(historialFeeComisionA).getHistorialFeeComision();
		historialFeeComisionB = factoryPoliticaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(historialFeeComisionB).getHistorialFeeComision();
		historialFeeComisionC = factoryPoliticaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(historialFeeComisionC).getHistorialFeeComision();
		historialFeeComisionD = factoryPoliticaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(historialFeeComisionC).getHistorialFeeComision();

		List<HistorialFeeComision> listaHistorialFeeComision = factoryPoliticaComercialService.listarHistorialFeeComisionxActivo().getListaHistorialFeeComision();
		System.out.println(listaHistorialFeeComision);
		
		Date fechaInicial = new LocalDateTime(2019, 10, 1, 0, 0, 1).toDate(); 
		Date fechaFinal = new LocalDateTime(2019, 12, 31, 0, 0, 1).toDate();
		
		String strFormatoFechaYYYY_MM_ddTHH_MM_SSZ =  "yyyy-MM-dd'T'HH:mm:ss'Z'";
		SimpleDateFormat formatoFecha_YYYY_MM_DDTHHmmss = new SimpleDateFormat(strFormatoFechaYYYY_MM_ddTHH_MM_SSZ);

		listaHistorialFeeComision = factoryPoliticaComercialService.listarHistorialFeeComisionxProductoFeeComisionEntreFechas(
				listaProductoFeeComision.get(0).getCodigoProductoFeeComision(), formatoFecha_YYYY_MM_DDTHHmmss.format(fechaInicial), 
				formatoFecha_YYYY_MM_DDTHHmmss.format(fechaFinal)).getListaHistorialFeeComision();
		
		System.out.println(listaHistorialFeeComision);

	}
	
}
