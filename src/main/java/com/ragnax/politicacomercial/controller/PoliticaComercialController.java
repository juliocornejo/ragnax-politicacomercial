package com.ragnax.politicacomercial.controller;

import java.time.Duration;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
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

import com.ragnax.politicacomercial.controller.response.Response;
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
import com.ragnax.politicacomercial.servicio.utilidades.UtilidadesPoliticaComercial;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = { "${servicio.app.controller}" })
public class PoliticaComercialController {
	
	/****@GetMapping  no soporta Errors****/
	@Autowired
	FactoryPoliticaComercialService factoryPoliticaComercialService;

	
	@GetMapping(value = "${servicio.app.uri.limpiarCache}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void clearAllCaches() {
		factoryPoliticaComercialService.limpiarCacheLocal();
	}
	
	/***************************************************/
	/*************** TipoMoneda ***************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Moneda", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearTipoMoneda(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoMoneda objTipoMoneda, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();
		
		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearTipoMoneda(
				objTipoMoneda), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Tipo de Moneda", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de actualizacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  actualizarTipoMoneda(
			HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoMoneda objTipoMoneda,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.actualizarTipoMoneda(
				Integer.parseInt(id), objTipoMoneda), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Tipo de Moneda", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarTipoMoneda(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarTipoMoneda(
				new TipoMoneda(Integer.parseInt(id))), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Listar Todos los Tipos de Monedas", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoMoneda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoTipoMoneda(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoTipoMoneda(), 
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** TipoNegocio *** *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Negocio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearTipoNegocio(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoNegocio objTipoNegocio, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();
		
		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearTipoNegocio(
				objTipoNegocio), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Negocio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de actualizacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  actualizarTipoNegocio(
			HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoNegocio objTipoNegocio,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.actualizarTipoNegocio(
				Integer.parseInt(id), objTipoNegocio), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Negocio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarTipoNegocio(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarTipoNegocio(
				new TipoNegocio(Integer.parseInt(id))), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Tipos de Negocio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarTodoTipoNegocio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoTipoNegocio(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoTipoNegocio(), 
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoFeeComision *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Fee Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearTipoFeeComision(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoFeeComision objTipoFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearTipoFeeComision(
				objTipoFeeComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Actualizar Tipo de Fee Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de actualizacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  actualizarTipoFeeComision(
			HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid TipoFeeComision objTipoFeeComision,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.actualizarTipoFeeComision(
				Integer.parseInt(id), objTipoFeeComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Fee-comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarTipoFeeComision(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarTipoFeeComision(
				new TipoFeeComision(Integer.parseInt(id))), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todo Tipo de Fee-comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoTipoFeeComision(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoTipoFeeComision(),
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** TipoValorComision *******************/
	/***************************************************/
	@ApiOperation(value = "Crear Tipo de Valor Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoValorComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearTipoValorComision(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoValorComision objTipoValorComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearTipoValorComision(
				objTipoValorComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Tipo de Valor para Fee-comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoValorComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarTipoValorComision(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String id)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarTipoValorComision(
				new TipoValorComision(Integer.parseInt(id))), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todo Tipo Valor Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoValorComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoTipoValorComision(HttpServletRequest request)  throws LogicaImplException{
		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoTipoValorComision(),
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	/***************************************************/
	/*************** Pais ******************************/
	/***************************************************/
	@ApiOperation(value = "Crear Pais", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearPais(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Pais objPais, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearPais(
				objPais), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Pais", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de actualizacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  actualizarPais(
			HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid Pais objPais,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoportal, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.actualizarPais(
				codigoportal , objPais), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Pais por el codigo de portal/pais", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	}) 
	@GetMapping(value = "${servicio.app.uri.buscarPaisxCodigoPortal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarPaisxCodigoPortal(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoportal)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarPaisxCodigoPortal(
				new  Pais(codigoportal)) , UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Listar Todos los Paises", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoPais(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoPais(), 
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** TipoCambio ***************/
	/***************************************************/
	@ApiOperation(value = "Generar Codigo Tipo de Cambio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarCodigoTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  generarCodigoTipoCambioxTipoMonedaBasexTipoMonedaCambio(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoCambio objTipoCambio, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.generarCodigoTipoCambio(
				objTipoCambio), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear Tipo de Cambio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearTipoCambio(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoCambio objTipoCambio, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearTipoCambio(
				objTipoCambio), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Tipo de Cambio x codigo", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarTipoCambioxCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarTipoCambioxCodigo(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigotipocambio)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarTipoCambioxCodigo(
				new TipoCambio(codigotipocambio)), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Tipos de Cambio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoTipoCambio(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoTipoCambio(), 
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Listar Todos los Tipos de Cambio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTipoCambioxTipoMonedaBase}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTipoCambioxTipoMonedaBase(HttpServletRequest request,
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String idtipomonedabase)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTipoCambioxTipoMonedaBase(
				new TipoCambio(new TipoMoneda(Integer.parseInt(idtipomonedabase)),null)), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);

	}
	
	/***************************************************/
	/*************** ProductoFeeComision ***************/
	/***************************************************/
	@ApiOperation(value = "Generar Codigo de Producto de Fee-comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.generarCodigoProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  generarCodigoProductoFeeComision(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ProductoFeeComision objProductoFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.generarNuevoCodigoProductoFeeComision(
				objProductoFeeComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Crear Producto de Fee-comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearProductoFeeComision(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ProductoFeeComision objProductoFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearProductoFeeComision(
				objProductoFeeComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Actualizar Producto de Fee Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de actualizacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PutMapping(value = "${servicio.app.uri.actualizarProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  actualizarProductoFeeComision(
			HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) @RequestBody @Valid ProductoFeeComision objProductoFeeComision,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductofeecomision, 
			@ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.actualizarProductoFeeComision(
				codigoproductofeecomision, objProductoFeeComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Buscar Producto de Fee-comision por tipo de negocio, tipo de fee, producto de servicio y estado", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	}) 
	@GetMapping(value = "${servicio.app.uri.buscarProductoFeeComisionxCodigoProductoServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarProductoFeeComisionxCodigoProductoServicio(HttpServletRequest request,  
			@ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductoservicio)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarProductoFeeComisionxCodigoProductoServicio(
				new ProductoFeeComision(codigoproductoservicio)) , UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Producto de Fee-comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoProductoFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoProductoFeeComision(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(),factoryPoliticaComercialService.listarTodoProductoFeeComision(), 
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}

	
	@ApiOperation(value = "Buscar Producto de Fee-comision por tipo de negocio y estado", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})

	@GetMapping(value = "${servicio.app.uri.listarProductoFeeComisionxTipoNegocioxEstado}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarProductoFeeComisionxTipoNegocioxEstado(HttpServletRequest request
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String tiponegocio
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "false") @PathVariable String estadoproductoservicio)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarProductoFeeComisionxTipoNegocioxEstado(
				new ProductoFeeComision(new TipoNegocio(Integer.parseInt(tiponegocio)), Boolean.parseBoolean(estadoproductoservicio))), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** HistorialTipoCambio ********/
	/***************************************************/
	
	@ApiOperation(value = "Crear Historial de Tipo de Cambio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearHistorialTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearHistorialTipoCambio(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid HistorialTipoCambio objHistorialTipoCambio, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();
		/****Limpiar Cache****/
		factoryPoliticaComercialService.limpiarCacheLocal();
		/****Limpiar Cache****/
		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearHistorialTipoCambio(
				objHistorialTipoCambio), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Historial de Tipo de Cambio por tipo de Cambio, solo activos", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarHistorialTipoCambioxTipoCambioxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarHistorialTipoCambioxTipoCambioxActivo(HttpServletRequest request
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigotipocambio)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarHistorialTipoCambioxTipoCambioxActivo(
				new HistorialTipoCambio(new TipoCambio(codigotipocambio))), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial de Tipo de Cambio, solo activos", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialTipoCambioxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarHistorialTipoCambioxActivo(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarHistorialTipoCambioxActivo(),
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial de Tipo de Cambio por tipo de cambio entre fechas", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialTipoCambioxTipoCambioEntreFechas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarHistorialTipoCambioxTipoCambioEntreFechas(HttpServletRequest request
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigotipocambio
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechainicial
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechafinal)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarHistorialTipoCambioxTipoCambioEntreFechas(
				codigotipocambio, fechainicial, fechafinal), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Historial de Tipo de Cambio", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoHistorialTipoCambio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoHistorialTipoCambio(HttpServletRequest request
			)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarTodoHistorialTipoCambio(),
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}
	
	/***************************************************/
	/*************** HistorialFeeComision ********/
	/***************************************************/
	
	@ApiOperation(value = "Crear Historial Fee Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de creacion", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearHistorialFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  crearHistorialFeeComision(HttpServletRequest request,  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid HistorialFeeComision objHistorialFeeComision, @ApiIgnore Errors errors)  throws LogicaImplException{

		Instant start = Instant.now();
		/****Limpiar Cache****/
		factoryPoliticaComercialService.limpiarCacheLocal();
		/****Limpiar Cache****/
		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.crearHistorialFeeComision(
				objHistorialFeeComision), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())), 
				request.getRequestURI()), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar Historial Fee Comision por productofeecomision, solo activos", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.buscarHistorialFeeComisionxCodigoProductoFeeComisionxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  buscarHistorialFeeComisionxProductoFeeComisionxActivo(HttpServletRequest request
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductofeecomision)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.buscarHistorialFeeComisionxProductoFeeComisionxActivo(
				new HistorialFeeComision(new ProductoFeeComision(codigoproductofeecomision), null)), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Todos los Historial Fee Comision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarTodoHistorialFeeComision}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarTodoHistorialFeeComision(HttpServletRequest request
			)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarTodoHistorialFeeComision(),
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial Fee Comision, por estadohistorialfeecomision", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialFeeComisionxActivo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarHistorialFeeComisionxActivo(HttpServletRequest request)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarHistorialFeeComisionxActivo(),
				UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),request.getRequestURI()), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Listar Historial Fee Comision por productofeecomision entre fechas", response = Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos de busqueda", response = Response.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = Response.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Response.class)
	})
	@GetMapping(value = "${servicio.app.uri.listarHistorialFeeComisionxProductoFeeComisionEntreFechas}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response>  listarFeeComisionxProductoFeeComisionEntreFechas(HttpServletRequest request
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String codigoproductofeecomision
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechainicial
			,  @ApiParam(value = "objeto de entrada", required = true, defaultValue = "0") @PathVariable String fechafinal)  throws LogicaImplException{

		Instant start = Instant.now();

		return new ResponseEntity<>(new Response(null,  HttpStatus.OK.value(), factoryPoliticaComercialService.listarHistorialFeeComisionxProductoFeeComisionEntreFechas(
				codigoproductofeecomision, fechainicial, fechafinal), UtilidadesPoliticaComercial.generarTiempoDuracion(Duration.between(start, Instant.now())),
				request.getRequestURI()), HttpStatus.OK);
	}
}
