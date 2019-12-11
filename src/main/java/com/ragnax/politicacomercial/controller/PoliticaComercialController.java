package com.ragnax.politicacomercial.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ragnax.politicacomercial.controller.response.RagnaxError;
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
import com.ragnax.politicacomercial.servicio.PoliticaComercialService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping
//(value = { "${servicio.app.controller}" })
public class PoliticaComercialController {
	
	/****@GetMapping  no soporta Errors****/
	@Autowired
	PoliticaComercialService politicaComercialService;
	
//	@Autowired
//	PoliticaComercialUtilidad politicaComercialUtilidad;

	
	@GetMapping(value = "${servicio.app.uri.limpiarCache}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void clearAllCaches() {
		politicaComercialService.limpiarCacheLocal();
	}
	
	/***************************************************/
	/*************** TipoMoneda ***************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Moneda", response = TipoMoneda.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoMoneda.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoMoneda>  crearTipoMoneda(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoMoneda objTipoMoneda, @ApiIgnore Errors errors)  throws LogicaImplException{
		
		
		return new ResponseEntity<>(politicaComercialService.crearTipoMoneda(objTipoMoneda).getTipoMoneda(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Tipo de Moneda", response = TipoMoneda.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoMoneda.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoMoneda>  actualizarTipoMoneda(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoMoneda objTipoMoneda,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.actualizarTipoMoneda(
				Integer.parseInt(id), objTipoMoneda).getTipoMoneda(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Tipo de Moneda", response = TipoMoneda.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoMoneda.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoMoneda>  buscarTipoMoneda(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarTipoMoneda(
				new TipoMoneda(Integer.parseInt(id))).getTipoMoneda(), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Listar Todos los Tipos de Monedas", response = TipoMoneda.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoMoneda.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoMoneda>>  listarTodoTipoMoneda()  throws LogicaImplException{
		
		return new ResponseEntity<>(politicaComercialService.listarTodoTipoMoneda().getListaTipoMoneda(), HttpStatus.OK);
		
	}
	
	/***************************************************/
	/*************** TipoNegocio *** *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Negocio", response = TipoNegocio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoNegocio.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoNegocio>  crearTipoNegocio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoNegocio objTipoNegocio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.crearTipoNegocio(
				objTipoNegocio).getTipoNegocio(), HttpStatus.OK);
		
	}

	@ApiOperation(value = "Actualizar Tipo de Negocio", response = TipoNegocio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoNegocio.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoNegocio>  actualizarTipoNegocio(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoNegocio objTipoNegocio,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.actualizarTipoNegocio(
				Integer.parseInt(id), objTipoNegocio).getTipoNegocio(), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Negocio", response = TipoNegocio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoNegocio.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoNegocio>  buscarTipoNegocio(  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarTipoNegocio(
				new TipoNegocio(Integer.parseInt(id))).getTipoNegocio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarTipoNegocio(
//				new TipoNegocio(Integer.parseInt(id))), politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Tipos de Negocio", response = TipoNegocio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoNegocio.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoNegocio>>  listarTodoTipoNegocio()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoTipoNegocio()
				.getListaTipoNegocio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTodoTipoNegocio(), 
//				politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoFeeComision *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Fee Comision", response = TipoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoFeeComision.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoFeeComision>  crearTipoFeeComision(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoFeeComision objTipoFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.crearTipoFeeComision(
				objTipoFeeComision).getTipoFeeComision(), HttpStatus.OK);
		
//		return new ResponseEntity<>(new TipoFeeComision(null,  HttpStatus.OK.value(), politicaComercialService.crearTipoFeeComision(
//				objTipoFeeComision), politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Fee Comision", response = TipoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoFeeComision.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoFeeComision>  actualizarTipoFeeComision(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoFeeComision objTipoFeeComision,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id, 
			@ApiIgnore Errors errors)  throws LogicaImplException{
		
		return new ResponseEntity<>(politicaComercialService.crearTipoFeeComision(
				objTipoFeeComision).getTipoFeeComision(), HttpStatus.OK);
		

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.actualizarTipoFeeComision(
//				Integer.parseInt(id), objTipoFeeComision), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Fee-comision", response = TipoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoFeeComision>  buscarTipoFeeComision(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarTipoFeeComision(
				new TipoFeeComision(Integer.parseInt(id))).getTipoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarTipoFeeComision(
//				new TipoFeeComision(Integer.parseInt(id))), politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todo Tipo de Fee-comision", response = TipoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoFeeComision>  listarTodoTipoFeeComision()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoTipoFeeComision().getTipoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTodoTipoFeeComision(),
//				politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoValorComision *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Valor Comision", response = TipoValorComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoValorComision.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoValorComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoValorComision>  crearTipoValorComision(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoValorComision objTipoValorComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.crearTipoValorComision(objTipoValorComision).getTipoValorComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.crearTipoValorComision(
//				objTipoValorComision), politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Valor para Fee-comision", response = TipoValorComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoValorComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoValorComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoValorComision>  buscarTipoValorComision(  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarTipoValorComision(new TipoValorComision(Integer.parseInt(id))).getTipoValorComision(), HttpStatus.OK);
		
//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarTipoValorComision(
//				new TipoValorComision(Integer.parseInt(id))), politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todo Tipo Valor Comision", response = TipoValorComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoValorComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoValorComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoValorComision>>  listarTodoTipoValorComision()  throws LogicaImplException{
		
		return new ResponseEntity<>(politicaComercialService.listarTodoTipoValorComision().getListaTipoValorComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTodoTipoValorComision(),
//				politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	/***************************************************/
	/*************** Pais ******************************/
	/***************************************************/
	@ApiOperation(value = "Crear Pais", response = Pais.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Pais.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais>  crearPais(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Pais objPais, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.crearPais(objPais).getPais(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.crearPais(
//				objPais), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Pais", response = Pais.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Pais.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais>  actualizarPais(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid Pais objPais,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoportal, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.actualizarPais(codigoportal , objPais).getPais(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.actualizarPais(
//				codigoportal , objPais), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Pais por el codigo de portal/pais", response = Pais.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Pais.class)
	}) 
	@GetMapping(value = "${servicio.app.uri.buscarPaisxCodigoPortal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais>  buscarPaisxCodigoPortal(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoportal)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarPaisxCodigoPortal(
				new  Pais(codigoportal)).getPais(), HttpStatus.OK);
		
//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarPaisxCodigoPortal(
//				new  Pais(codigoportal)) , politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Paises", response = Pais.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Pais.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Pais>>  listarTodoPais()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoPais().getListaPais(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTodoPais(), 
//				politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** TipoCambio ***************/
	/***************************************************/
	@ApiOperation(value = "Generar Codigo Tipo de Cambio", response = TipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoCambio.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarCodigoTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCambio>  generarCodigoTipoCambioxTipoMonedaBasexTipoMonedaCambio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoCambio objTipoCambio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.generarCodigoTipoCambio(objTipoCambio).getTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.generarCodigoTipoCambio(
//				objTipoCambio), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear Tipo de Cambio", response = TipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoCambio.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCambio>  crearTipoCambio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoCambio objTipoCambio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.crearTipoCambio(objTipoCambio).getTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.crearTipoCambio(
//				objTipoCambio), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Tipo de Cambio x codigo", response = TipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoCambioxCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoCambio>  buscarTipoCambioxCodigo(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigotipocambio)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarTipoCambioxCodigo(
				new TipoCambio(codigotipocambio)).getTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarTipoCambioxCodigo(
//				new TipoCambio(codigotipocambio)), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Tipos de Cambio", response = TipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCambio>>  listarTodoTipoCambio()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoTipoCambio().getListaTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTodoTipoCambio(), 
//				politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Listar Todos los Tipos de Cambio", response = TipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTipoCambioxTipoMonedaBase}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCambio>> listarTipoCambioxTipoMonedaBase(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipomonedabase)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTipoCambioxTipoMonedaBase(
				new TipoCambio(new TipoMoneda(Integer.parseInt(idtipomonedabase)),null)).getListaTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTipoCambioxTipoMonedaBase(
//				new TipoCambio(new TipoMoneda(Integer.parseInt(idtipomonedabase)),null)), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** ProductoFeeComision ***************/
	/***************************************************/
	@ApiOperation(value = "Generar Codigo de Producto de Fee-comision", response = ProductoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ProductoFeeComision.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarCodigoProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoFeeComision>  generarCodigoProductoFeeComision(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ProductoFeeComision objProductoFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.generarNuevoCodigoProductoFeeComision(
				objProductoFeeComision).getProductoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.generarNuevoCodigoProductoFeeComision(
//				objProductoFeeComision), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear Producto de Fee-comision", response = ProductoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ProductoFeeComision.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoFeeComision>  crearProductoFeeComision(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ProductoFeeComision objProductoFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.crearProductoFeeComision(
				objProductoFeeComision).getProductoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.crearProductoFeeComision(
//				objProductoFeeComision), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Producto de Fee Comision", response = ProductoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ProductoFeeComision.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoFeeComision>  actualizarProductoFeeComision(
			  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ProductoFeeComision objProductoFeeComision,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductofeecomision, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.actualizarProductoFeeComision(
				codigoproductofeecomision, objProductoFeeComision).getProductoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.actualizarProductoFeeComision(
//				codigoproductofeecomision, objProductoFeeComision), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Producto de Fee-comision por tipo de negocio, tipo de fee, producto de servicio y estado", response = ProductoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ProductoFeeComision.class)
	}) 
	@GetMapping(value = "${servicio.app.uri.buscarProductoFeeComisionxCodigoProductoServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoFeeComision>  buscarProductoFeeComisionxCodigoProductoServicio(  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductoservicio)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(
				new ProductoFeeComision(codigoproductoservicio)).getProductoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(
//				new ProductoFeeComision(codigoproductoservicio)) , politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Producto de Fee-comision", response = ProductoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ProductoFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoFeeComision>>  listarTodoProductoFeeComision()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoProductoFeeComision().getListaProductoFeeComision(), HttpStatus.OK);
		
//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),politicaComercialService.listarTodoProductoFeeComision(), 
//				politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}

	
	@ApiOperation(value = "Buscar Producto de Fee-comision por tipo de negocio y estado", response = ProductoFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ProductoFeeComision.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarProductoFeeComisionxTipoNegocioxEstado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductoFeeComision>>  listarProductoFeeComisionxTipoNegocioxEstado(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String tiponegocio,
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "false") @PathVariable String estadoproductoservicio)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarProductoFeeComisionxTipoNegocioxEstado(
				new ProductoFeeComision(new TipoNegocio(Integer.parseInt(tiponegocio)), Boolean.parseBoolean(estadoproductoservicio))).getListaProductoFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.listarProductoFeeComisionxTipoNegocioxEstado(
//				new ProductoFeeComision(new TipoNegocio(Integer.parseInt(tiponegocio)), Boolean.parseBoolean(estadoproductoservicio))), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** HistorialTipoCambio ********/
	/***************************************************/
	
	@ApiOperation(value = "Crear Historial de Tipo de Cambio", response = HistorialTipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialTipoCambio.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearHistorialTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HistorialTipoCambio>  crearHistorialTipoCambio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid HistorialTipoCambio objHistorialTipoCambio, @ApiIgnore Errors errors)  throws LogicaImplException{

		
		/****Limpiar Cache****/
		politicaComercialService.limpiarCacheLocal();
		/****Limpiar Cache****/
		
		return new ResponseEntity<>(politicaComercialService.crearHistorialTipoCambio(
				objHistorialTipoCambio).getHistorialTipoCambio(), HttpStatus.OK);
		
//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.crearHistorialTipoCambio(
//				objHistorialTipoCambio), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Historial de Tipo de Cambio por tipo de Cambio, solo activos", response = HistorialTipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialTipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarHistorialTipoCambioxTipoCambioxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HistorialTipoCambio>  buscarHistorialTipoCambioxTipoCambioxActivo(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigotipocambio)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarHistorialTipoCambioxTipoCambioxActivo(
				new HistorialTipoCambio(new TipoCambio(codigotipocambio))).getHistorialTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarHistorialTipoCambioxTipoCambioxActivo(
//				new HistorialTipoCambio(new TipoCambio(codigotipocambio))), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial de Tipo de Cambio, solo activos", response = HistorialTipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialTipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialTipoCambioxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialTipoCambio>> listarHistorialTipoCambioxActivo()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarHistorialTipoCambioxActivo()
				.getListaHistorialTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.listarHistorialTipoCambioxActivo(),
//				politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial de Tipo de Cambio por tipo de cambio entre fechas", response = HistorialTipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialTipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialTipoCambioxTipoCambioEntreFechas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialTipoCambio>>  listarHistorialTipoCambioxTipoCambioEntreFechas(
				@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigotipocambio
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechainicial
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechafinal)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarHistorialTipoCambioxTipoCambioEntreFechas(
				codigotipocambio, fechainicial, fechafinal).getListaHistorialTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.listarHistorialTipoCambioxTipoCambioEntreFechas(
//				codigotipocambio, fechainicial, fechafinal), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Historial de Tipo de Cambio", response = HistorialTipoCambio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialTipoCambio.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoHistorialTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialTipoCambio>> listarTodoHistorialTipoCambio(
			)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoHistorialTipoCambio().getListaHistorialTipoCambio(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.listarTodoHistorialTipoCambio(),
//				politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** HistorialFeeComision ********/
	/***************************************************/
	
	@ApiOperation(value = "Crear Historial Fee Comision", response = HistorialFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialFeeComision.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearHistorialFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HistorialFeeComision>  crearHistorialFeeComision(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid HistorialFeeComision objHistorialFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{
		
		/****Limpiar Cache****/
		politicaComercialService.limpiarCacheLocal();
		
		return new ResponseEntity<>(politicaComercialService.crearHistorialFeeComision(objHistorialFeeComision).getHistorialFeeComision(), HttpStatus.OK);
		/****Limpiar Cache****/
//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.crearHistorialFeeComision(
//				objHistorialFeeComision), politicaComercialUtilidad.generarTiempoDuracion(now), 
//				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Historial Fee Comision por productofeecomision, solo activos", response = HistorialFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarHistorialFeeComisionxCodigoProductoFeeComisionxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HistorialFeeComision>  buscarHistorialFeeComisionxProductoFeeComisionxActivo(
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductofeecomision)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(
				new HistorialFeeComision(new ProductoFeeComision(codigoproductofeecomision), null)).getHistorialFeeComision(), HttpStatus.OK);
		
//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(
//				new HistorialFeeComision(new ProductoFeeComision(codigoproductofeecomision), null)), politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Historial Fee Comision", response = HistorialFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoHistorialFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialFeeComision>>  listarTodoHistorialFeeComision(
			)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoHistorialFeeComision().
				getListaHistorialFeeComision(), HttpStatus.OK);

//		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), politicaComercialService.listarTodoHistorialFeeComision(),
//				politicaComercialUtilidad.generarTiempoDuracion(now),
//				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial Fee Comision, por estadohistorialfeecomision", response = HistorialFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialFeeComisionxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialFeeComision>> listarHistorialFeeComisionxActivo()  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarTodoHistorialFeeComision().getListaHistorialFeeComision(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial Fee Comision por productofeecomision entre fechas", response = HistorialFeeComision.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = HistorialFeeComision.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialFeeComisionxProductoFeeComisionEntreFechas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistorialFeeComision>>  listarFeeComisionxProductoFeeComisionEntreFechas(
			  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductofeecomision
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechainicial
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechafinal)  throws LogicaImplException{

		return new ResponseEntity<>(politicaComercialService.listarHistorialFeeComisionxProductoFeeComisionEntreFechas(
				codigoproductofeecomision, fechainicial, fechafinal).getListaHistorialFeeComision(), HttpStatus.OK);
	}
}
