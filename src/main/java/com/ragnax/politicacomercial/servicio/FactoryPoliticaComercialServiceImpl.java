package com.ragnax.politicacomercial.servicio;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ragnax.politicacomercial.controller.response.PoliticaComercial;
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
import com.ragnax.politicacomercial.repository.FactoryPoliticaComercialDAO;
import com.ragnax.politicacomercial.servicio.utilidades.UtilidadesPoliticaComercial;

import vijnana.utilidades.component.utilidades.AppDate;
import vijnana.utilidades.component.utilidades.DateMapper;
import vijnana.utilidades.component.utilidades.TipoFormatoFecha;

@Service
@CacheConfig(cacheNames = { "buscarTipoMoneda", "listarTodoTipoMoneda", "buscarTipoNegocio", 
		"listarTodoTipoNegocio", "buscarTipoFeeComision", "listarTodoTipoFeeComision", "buscarTipoValorComision",
		"listarTodoTipoValorComision", "buscarPaisxCodigoPortal", "listarTodoPais", "buscarTipoCambioxCodigo", 
		"listarTipoCambioxTipoMonedaBase",
		"listarTodoTipoCambio", "buscarProductoFeeComisionxCodigo",
		"listarTodoProductoFeeComision"})

public class FactoryPoliticaComercialServiceImpl implements FactoryPoliticaComercialService {
	//Segun se necesite se van creando llamadas al repositorio para devolver entities.
	@Autowired
	private FactoryPoliticaComercialDAO factoryPoliticaComercialDAO;

	private static final boolean estadoActivoConsulta = true;
	private static final boolean estadoInactivoConsulta= false;

	/***********************************************************/
	/****** TipoMoneda TipoMoneda TipoMoneda *******************/
	/***********************************************************/
	public PoliticaComercial crearTipoMoneda(TipoMoneda objTipoMoneda) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();
		
		try {

			Pageable pageByCodigoMoneda = PageRequest.of(0, 1, Sort.by("codigoTipoMonedaUpperCase").descending());
			/*Codigo debe existir por el id, y el nombre no debe existir*/
			Page<TipoMoneda> pageCodigoTipoMoneda  = factoryPoliticaComercialDAO.getTipoMonedaRepository().findByCodigoTipoMonedaUpperCase(objTipoMoneda.getCodigoTipoMonedaUpperCase().toUpperCase(), pageByCodigoMoneda);

			Pageable pageByNombreMoneda = PageRequest.of(0, 1, Sort.by("nombreTipoMonedaLowerCase").descending());

			Page<TipoMoneda> pageNombreTipoMoneda  = factoryPoliticaComercialDAO.getTipoMonedaRepository().findByNombreTipoMonedaLowerCase(objTipoMoneda.getNombreTipoMoneda().toLowerCase(), pageByNombreMoneda);

			if(pageCodigoTipoMoneda.isEmpty() && pageNombreTipoMoneda.getContent().isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoMoneda").descending());

				Page<TipoMoneda> pageIdTipoMoneda = factoryPoliticaComercialDAO.getTipoMonedaRepository().findAll(pageByidDesc);

				Integer idTipoMoneda = (!pageIdTipoMoneda.isEmpty()) ? (Integer) pageIdTipoMoneda.getContent().get(0).getIdTipoMoneda() + 1 : 1; 
				/*Siempre hacer mayusculas los codigos**/
				objTipoMoneda.setCodigoTipoMonedaUpperCase(objTipoMoneda.getCodigoTipoMonedaUpperCase().toUpperCase());
				objTipoMoneda.setNombreTipoMonedaLowerCase(objTipoMoneda.getNombreTipoMoneda().toLowerCase());
				objTipoMoneda.setEstadoTipoMoneda(true);
				objTipoMoneda.setIdTipoMoneda(idTipoMoneda);

				factoryPoliticaComercialDAO.getTipoMonedaRepository().save(objTipoMoneda);

				TipoMoneda codTipoMoneda = buscarTipoMoneda(objTipoMoneda).getTipoMoneda(); 

				politicaComercial.setTipoMoneda(codTipoMoneda);
			}else {
				throw new LogicaImplException("No se puede crear TipoMoneda, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial actualizarTipoMoneda(Integer id, TipoMoneda objTipoMoneda) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			buscarTipoMoneda(new TipoMoneda(id));

			Pageable pageByCodigoMoneda = PageRequest.of(0, 1, Sort.by("codigoTipoMonedaUpperCase").descending());
			/*Codigo debe existir por el id, y el nombre no debe existir*/
			Page<TipoMoneda> pageCodigoTipoMoneda  = factoryPoliticaComercialDAO.getTipoMonedaRepository().findByCodigoTipoMonedaUpperCase(objTipoMoneda.getCodigoTipoMonedaUpperCase().toUpperCase(), pageByCodigoMoneda);

			Pageable pageByNombreMoneda = PageRequest.of(0, 1, Sort.by("nombreTipoMonedaLowerCase").descending());

			Page<TipoMoneda> pageNombreTipoMoneda  = factoryPoliticaComercialDAO.getTipoMonedaRepository().findByNombreTipoMonedaLowerCase(objTipoMoneda.getNombreTipoMoneda().toLowerCase(), pageByNombreMoneda);
			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if((!pageCodigoTipoMoneda.isEmpty() && pageCodigoTipoMoneda.getContent().get(0).getIdTipoMoneda()==id && pageNombreTipoMoneda.isEmpty())
					|| (buscarTipoMoneda(new TipoMoneda(id)).getTipoMoneda()!=null && pageNombreTipoMoneda.isEmpty() && (pageCodigoTipoMoneda.isEmpty()&& pageNombreTipoMoneda.isEmpty()))){
				objTipoMoneda.setIdTipoMoneda(id);

				objTipoMoneda.setCodigoTipoMonedaUpperCase(objTipoMoneda.getCodigoTipoMonedaUpperCase().toUpperCase());

				objTipoMoneda.setNombreTipoMonedaLowerCase(objTipoMoneda.getNombreTipoMoneda().toLowerCase());

				factoryPoliticaComercialDAO.getTipoMonedaRepository().save(objTipoMoneda);

				politicaComercial.setTipoMoneda(objTipoMoneda);
			}
			else {
				throw new LogicaImplException("No se puede actualizar TipoMoneda, parametros ya existen en un identificador distinto");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="buscarTipoMoneda")
	public PoliticaComercial buscarTipoMoneda(TipoMoneda objTipoMoneda) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		
		try {	

			Optional<TipoMoneda> optPerTipoMoneda = factoryPoliticaComercialDAO.getTipoMonedaRepository().findById(objTipoMoneda.getIdTipoMoneda());

			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoMoneda!=null && optPerTipoMoneda.isPresent()){

				politicaComercial.setTipoMoneda(optPerTipoMoneda.get());

			}else {
				throw new LogicaImplException("No existe TipoMoneda con identificador:" +objTipoMoneda.getIdTipoMoneda());
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}	

	@Cacheable(value="listarTodoTipoMoneda")
	public PoliticaComercial listarTodoTipoMoneda() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			List<TipoMoneda> listaTipoMoneda = factoryPoliticaComercialDAO.getTipoMonedaRepository().findAll();

			if(listaTipoMoneda !=null && !listaTipoMoneda.isEmpty()){
				politicaComercial.setListaTipoMoneda(listaTipoMoneda);
			}else {
				throw new LogicaImplException("No existe lista de TipoMoneda");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	/***********************************************************/
	/****** TipoNegocio TipoNegocio TipoNegocio ****************/
	/***********************************************************/
	public PoliticaComercial crearTipoNegocio(TipoNegocio objTipoNegocio) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoNegocio").descending());

			Page<TipoNegocio> pageNombreTipoNegocio  = factoryPoliticaComercialDAO.getTipoNegocioRepository().findByNombreTipoNegocio(objTipoNegocio.getNombreTipoNegocio(), pageByNombreDesc); 

			if(pageNombreTipoNegocio.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoNegocio").descending());

				Page<TipoNegocio> pageIdTipoNegocio = factoryPoliticaComercialDAO.getTipoNegocioRepository().findAll(pageByidDesc);

				Integer idTipoNegocio = (!pageIdTipoNegocio.isEmpty()) ? (Integer) pageIdTipoNegocio.getContent().get(0).getIdTipoNegocio() + 1 : 1; 

				objTipoNegocio.setIdTipoNegocio(idTipoNegocio);

				factoryPoliticaComercialDAO.getTipoNegocioRepository().save(objTipoNegocio);

				pageNombreTipoNegocio  = factoryPoliticaComercialDAO.getTipoNegocioRepository().findByNombreTipoNegocio(objTipoNegocio.getNombreTipoNegocio(), pageByNombreDesc);

				politicaComercial.setTipoNegocio(pageNombreTipoNegocio.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoNegocio, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial actualizarTipoNegocio(Integer id, TipoNegocio objTipoNegocio) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {

			buscarTipoNegocio(new TipoNegocio(id));

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoNegocio").descending());

			Page<TipoNegocio> pageNombreTipoNegocio  = factoryPoliticaComercialDAO.getTipoNegocioRepository().findByNombreTipoNegocio(objTipoNegocio.getNombreTipoNegocio(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
					//... solo actualizar estado****/
			if((!pageNombreTipoNegocio.isEmpty() && pageNombreTipoNegocio.getContent().get(0).getIdTipoNegocio()==id)
					|| (buscarTipoNegocio(new TipoNegocio(id)).getTipoNegocio()!=null && pageNombreTipoNegocio.isEmpty())){
				objTipoNegocio.setIdTipoNegocio(id);

				factoryPoliticaComercialDAO.getTipoNegocioRepository().save(objTipoNegocio);

				politicaComercial.setTipoNegocio(objTipoNegocio);
			}
			else {
				throw new LogicaImplException("No se puede actualizar TipoNegocio, nombreTipoNegocio ya existe en un identificador distinto");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="buscarTipoNegocio")
	public PoliticaComercial buscarTipoNegocio(TipoNegocio objTipoNegocio) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoNegocio> optPerTipoNegocio = factoryPoliticaComercialDAO.getTipoNegocioRepository().findById(objTipoNegocio.getIdTipoNegocio());

			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoNegocio!=null && optPerTipoNegocio.isPresent()){

				politicaComercial.setTipoNegocio(optPerTipoNegocio.get());

			}else {
				throw new LogicaImplException("No existe TipoNegocio con identificador:" +objTipoNegocio.getIdTipoNegocio());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	@Cacheable(value="listarTodoTipoNegocio")
	public PoliticaComercial listarTodoTipoNegocio() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<TipoNegocio> listaTipoNegocio = factoryPoliticaComercialDAO.getTipoNegocioRepository().findAll();

			if(listaTipoNegocio!=null && !listaTipoNegocio.isEmpty()){
				politicaComercial.setListaTipoNegocio(listaTipoNegocio);
			}else {
				throw new LogicaImplException("No existe lista de TipoNegocio");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}
	/***********************************************************/
	/******TipoFeeComision TipoFeeComision TipoFeeComision *****/
	/***********************************************************/
	public PoliticaComercial crearTipoFeeComision(TipoFeeComision objTipoFeeComision) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoFeeComision").descending());

			Page<TipoFeeComision> pageNombreTipoFeeComision  = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findByNombreTipoFeeComision(objTipoFeeComision.getNombreTipoFeeComision(), pageByNombreDesc); 

			if(pageNombreTipoFeeComision.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoFeeComision").descending());

				Page<TipoFeeComision> pageIdTipoFeeComision = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findAll(pageByidDesc);

				Integer idTipoFeeComision = (!pageIdTipoFeeComision.isEmpty()) ? (Integer) pageIdTipoFeeComision.getContent().get(0).getIdTipoFeeComision() + 1 : 1; 

				objTipoFeeComision.setIdTipoFeeComision(idTipoFeeComision);

				objTipoFeeComision.setEstadoTipoFeeComision(true);

				factoryPoliticaComercialDAO.getTipoFeeComisionRepository().save(objTipoFeeComision);

				pageNombreTipoFeeComision  = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findByNombreTipoFeeComision(objTipoFeeComision.getNombreTipoFeeComision(), pageByNombreDesc);

				politicaComercial.setTipoFeeComision(pageNombreTipoFeeComision.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoFeeComision, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial actualizarTipoFeeComision(Integer id, TipoFeeComision objTipoFeeComision) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {

			buscarTipoFeeComision(new TipoFeeComision(id));

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoFeeComision").descending());

			Page<TipoFeeComision> pageNombreTipoFeeComision  = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findByNombreTipoFeeComision(objTipoFeeComision.getNombreTipoFeeComision(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoFeeComision.idTipoFeeComision = id 
					//... solo actualizar estado****/
			if((!pageNombreTipoFeeComision.isEmpty() && pageNombreTipoFeeComision.getContent().get(0).getIdTipoFeeComision()==id)
					|| (buscarTipoFeeComision(new TipoFeeComision(id)).getTipoFeeComision()!=null && pageNombreTipoFeeComision.isEmpty())){
				objTipoFeeComision.setIdTipoFeeComision(id);

				factoryPoliticaComercialDAO.getTipoFeeComisionRepository().save(objTipoFeeComision);

				politicaComercial.setTipoFeeComision(objTipoFeeComision);
			}
			else {
				throw new LogicaImplException("No se puede actualizar TipoFeeComision, nombreTipoPoliticaComercial ya existe en un identificador distinto");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="buscarTipoFeeComision")
	public PoliticaComercial buscarTipoFeeComision(TipoFeeComision objTipoFeeComision) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoFeeComision> optPerTipoFeeComision = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findById(objTipoFeeComision.getIdTipoFeeComision());

			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoFeeComision!=null && optPerTipoFeeComision.isPresent()){

				politicaComercial.setTipoFeeComision(optPerTipoFeeComision.get());

			}else {
				throw new LogicaImplException("No existe TipoFeeComision con identificador:" +objTipoFeeComision.getIdTipoFeeComision());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	public PoliticaComercial buscarTipoFeeComisionxNombre(TipoFeeComision objTipoFeeComision) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoFeeComision").descending());

			Page<TipoFeeComision> pageNombreTipoFeeComision  = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findByNombreTipoFeeComision(objTipoFeeComision.getNombreTipoFeeComision(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoFeeComision.idTipoFeeComision = id 
				//... solo actualizar estado****/
			if(!pageNombreTipoFeeComision.isEmpty()){

				politicaComercial.setTipoFeeComision(pageNombreTipoFeeComision.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe TipoFeeComision con nombre:" +objTipoFeeComision.getNombreTipoFeeComision());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	@Cacheable(value="listarTodoTipoFeeComision")
	public PoliticaComercial listarTodoTipoFeeComision() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<TipoFeeComision> listaTipoFeeComision = factoryPoliticaComercialDAO.getTipoFeeComisionRepository().findAll();

			if(listaTipoFeeComision!=null && !listaTipoFeeComision.isEmpty()){
				politicaComercial.setListaTipoFeeComision(listaTipoFeeComision);
			}else {
				throw new LogicaImplException("No existe lista de TipoFeeComision");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	/***********************************************************/
	/*****TipoValorComision TipoValorComision TipoValorComision*/
	/***********************************************************/
	public PoliticaComercial crearTipoValorComision(TipoValorComision objTipoValorComision) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoValorComision").descending());

			Page<TipoValorComision> pageNombreTipoValorComision  = factoryPoliticaComercialDAO.getTipoValorComisionRepository().findByNombreTipoValorComision(objTipoValorComision.getNombreTipoValorComision(), pageByNombreDesc); 

			if(pageNombreTipoValorComision.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoValorComision").descending());

				Page<TipoValorComision> pageIdTipoValorComision = factoryPoliticaComercialDAO.getTipoValorComisionRepository().findAll(pageByidDesc);
				
				Integer idTipoValorComision = (!pageIdTipoValorComision.isEmpty()) ? (Integer)  pageIdTipoValorComision.getContent().get(0).getIdTipoValorComision() + 1 : 1;

				objTipoValorComision.setIdTipoValorComision(idTipoValorComision);

				factoryPoliticaComercialDAO.getTipoValorComisionRepository().save(objTipoValorComision);

				pageNombreTipoValorComision  = factoryPoliticaComercialDAO.getTipoValorComisionRepository().findByNombreTipoValorComision(objTipoValorComision.getNombreTipoValorComision(), pageByNombreDesc);

				politicaComercial.setTipoValorComision(pageNombreTipoValorComision.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoValorComision, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="buscarTipoValorComision")
	public PoliticaComercial buscarTipoValorComision(TipoValorComision objTipoValorComision) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoValorComision> optPerTipoValorComision = factoryPoliticaComercialDAO.getTipoValorComisionRepository().findById(objTipoValorComision.getIdTipoValorComision());

			/***Si existe reemplazar por el nuevo*/
			if(optPerTipoValorComision!=null && optPerTipoValorComision.isPresent()){

				politicaComercial.setTipoValorComision(optPerTipoValorComision.get());

			}else {
				throw new LogicaImplException("No existe TipoValorComision con identificador:" +objTipoValorComision.getIdTipoValorComision());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	@Cacheable(value="listarTodoTipoValorComision")
	public PoliticaComercial listarTodoTipoValorComision() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<TipoValorComision> listaTipoValorComision = factoryPoliticaComercialDAO.getTipoValorComisionRepository().findAll();

			if(listaTipoValorComision!=null && !listaTipoValorComision.isEmpty()){
				politicaComercial.setListaTipoValorComision(listaTipoValorComision);
			}else {
				throw new LogicaImplException("No existe lista de TipoValorComision");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}
	
	/***********************************************************/
	/******Pais Pais *******************************************/
	/***********************************************************/
	public PoliticaComercial crearPais(Pais objPais) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
//		Integer idPais =1;
		try {
			Pageable pageByCodigoPortalPais = PageRequest.of(0, 1, Sort.by("codigoPortalPaisLowerCase").descending());

			Page<Pais> pageCodigoPortalPais  = factoryPoliticaComercialDAO.getPaisRepository().findByCodigoPortalPaisLowerCase(objPais.getCodigoPortalPaisLowerCase(), pageByCodigoPortalPais);

			Pageable pageByNombrePortalPais = PageRequest.of(0, 1, Sort.by("nombrePaisLowerCase").descending());

			Page<Pais> pageNombrePortalPais  = factoryPoliticaComercialDAO.getPaisRepository().findByNombrePaisLowerCase(objPais.getNombrePais().toLowerCase(), pageByNombrePortalPais);

			if(pageCodigoPortalPais.isEmpty() && pageNombrePortalPais.isEmpty()){
//				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idPais").descending());
//
//				Page<Pais> pageIdPais = factoryPoliticaComercialDAO.getPaisRepository().findAll(pageByidDesc);
//
//				if(!pageIdPais.isEmpty()) {
//					idPais = ((Integer) pageIdPais.getContent().get(0).getIdPais() > 0) ?
//							(Integer) pageIdPais.getContent().get(0).getIdPais()+ 1: null;
//
//					if(idPais==null)
//						throw new LogicaImplException("No se puede crear Pais, error al obtener idPais");
//				}
//
//				objPais.setIdPais(idPais);
				objPais.setEstadoPais(true);
				
				objPais.setNombrePaisLowerCase(objPais.getNombrePais().toLowerCase());

				factoryPoliticaComercialDAO.getPaisRepository().save(objPais);

				pageCodigoPortalPais  = factoryPoliticaComercialDAO.getPaisRepository().findByCodigoPortalPaisLowerCase(objPais.getCodigoPortalPaisLowerCase(), pageByCodigoPortalPais); 

				politicaComercial.setPais(pageCodigoPortalPais.getContent().get(0));
			}else {
				throw new LogicaImplException("No se puede crear TipoFeeComision, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial actualizarPais(String codigopais, Pais objPais) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			Pageable pageByCodigoPortalPais = PageRequest.of(0, 1, Sort.by("codigoPortalPaisLowerCase").descending());

			Page<Pais> pageCodigoPortalPais  = factoryPoliticaComercialDAO.getPaisRepository().findByCodigoPortalPaisLowerCase(codigopais.toLowerCase(), pageByCodigoPortalPais);

			// Si existe el codigo y el nombre del pais no existe en ningun otro pais
			Pageable pageByNombrePortalPais = PageRequest.of(0, 1, Sort.by("nombrePaisLowerCase").descending());

			Page<Pais> pageNombrePortalPais  = (pageCodigoPortalPais.getContent().get(0).getCodigoPortalPaisLowerCase().equals(codigopais.toLowerCase())) ? 
					factoryPoliticaComercialDAO.getPaisRepository().findByNombrePaisLowerCase(objPais.getNombrePais().toLowerCase(), pageByNombrePortalPais) : null;

					if(pageNombrePortalPais!=null && pageNombrePortalPais.isEmpty() || (pageNombrePortalPais.getContent().get(0).getCodigoPortalPaisLowerCase().equals(codigopais))){

						objPais.setNombrePaisLowerCase(objPais.getNombrePais().toLowerCase());

						factoryPoliticaComercialDAO.getPaisRepository().save(objPais);

						politicaComercial.setPais(objPais);
					}else {
						throw new LogicaImplException("No se puede actualizar Pais, nombre de pais ya existe");
					}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="buscarPaisxCodigoPortal")
	public PoliticaComercial buscarPaisxCodigoPortal(Pais objPais) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {

			Pageable pageByCodigoPortalPais = PageRequest.of(0, 1, Sort.by("codigoPortalPaisLowerCase").descending());

			Page<Pais> pageCodigoPortalPais  = factoryPoliticaComercialDAO.getPaisRepository().findByCodigoPortalPaisLowerCase(objPais.getCodigoPortalPaisLowerCase().toLowerCase(), pageByCodigoPortalPais);
			/***Si existe reemplazar por el nuevo*/
			if(!pageCodigoPortalPais.isEmpty()){
				politicaComercial.setPais(pageCodigoPortalPais.getContent().get(0));
			}else {
				throw new LogicaImplException("No existe Pais con identificador:" +objPais.getCodigoPortalPaisLowerCase());
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}	

	@Cacheable(value="listarTodoPais")
	public PoliticaComercial listarTodoPais() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			List<Pais> listaPais = factoryPoliticaComercialDAO.getPaisRepository().findAll();

			if(listaPais !=null && !listaPais.isEmpty()){
				politicaComercial.setListaPais(listaPais);
			}else {
				throw new LogicaImplException("No existe lista de TipoMoneda");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	/***********************************************************/
	/******TipoCambio TipoCambio TipoCambio ********************/
	/***********************************************************/
	public PoliticaComercial generarCodigoTipoCambio(TipoCambio objTipoCambio) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			//Validar que no existan los las moneda base y la moneda de cambio
			if((buscarTipoMoneda(objTipoCambio.getIdTipoMonedaBase()).getTipoMoneda().getEstadoTipoMoneda() && 
					buscarTipoMoneda(objTipoCambio.getIdTipoMonedaCambio()).getTipoMoneda().getEstadoTipoMoneda())){
				//Obtener Moneda Base
				//Obtener Moneda de Cambio
				String codigoTipoCambio = UtilidadesPoliticaComercial.obtenerCodigoTipoCambio(objTipoCambio);

				Pageable pageByCodigoTipoCambio = PageRequest.of(0, 1, Sort.by("codigoTipoCambio").descending());

				Page<TipoCambio> pageCodigoTipoCambio  = factoryPoliticaComercialDAO.getTipoCambioRepository().
						findByCodigoTipoCambio(codigoTipoCambio, pageByCodigoTipoCambio);

				TipoCambio tipoCambio = (pageCodigoTipoCambio.isEmpty()) ? factoryPoliticaComercialDAO.getTipoCambioRepository().
						findByIdTipoMonedaBaseAndIdTipoMonedaCambio(objTipoCambio.getIdTipoMonedaBase(), objTipoCambio.getIdTipoMonedaCambio()) : null;

						if(tipoCambio!= null) {
							throw new LogicaImplException();
						}
						objTipoCambio.setCodigoTipoCambio(codigoTipoCambio);
						politicaComercial.setTipoCambio(objTipoCambio);

			}else {
				throw new LogicaImplException("No se puede crear TipoCambio, moneda cambio invalida");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}
	
	public PoliticaComercial crearTipoCambio(TipoCambio objTipoCambio) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			if(objTipoCambio.getCodigoTipoCambio().equals(UtilidadesPoliticaComercial.obtenerCodigoTipoCambio(objTipoCambio))) {

				Pageable pageByCodigoDesc = PageRequest.of(0, 1, Sort.by("codigoTipoCambio").descending());
				/*****Buscar el ProductoFeeComision por codigo *****/
				Page<TipoCambio> pageCodigoTipoCambio  = factoryPoliticaComercialDAO.getTipoCambioRepository().findByCodigoTipoCambio(
						objTipoCambio.getCodigoTipoCambio(), pageByCodigoDesc);

				TipoCambio metTipoCambio = (pageCodigoTipoCambio.isEmpty()) ? factoryPoliticaComercialDAO.getTipoCambioRepository().
						findByIdTipoMonedaBaseAndIdTipoMonedaCambio(objTipoCambio.getIdTipoMonedaBase(), objTipoCambio.getIdTipoMonedaCambio()) : null;

				if(metTipoCambio!=null) {
					throw new LogicaImplException();
				}
				factoryPoliticaComercialDAO.getTipoCambioRepository().save(objTipoCambio);

				objTipoCambio = buscarTipoCambioxCodigo(objTipoCambio).getTipoCambio();

				politicaComercial.setTipoCambio(objTipoCambio);

			}else {
				throw new LogicaImplException("No se puede crear TipoFeeComision, codigo de tipo de cambio ya existe");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}	
		return politicaComercial;
	}

	@Cacheable(value="buscarTipoCambioxCodigo")
	public PoliticaComercial buscarTipoCambioxCodigo(TipoCambio objTipoCambio) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			Pageable pageByCodigoTipoCambio = PageRequest.of(0, 1, Sort.by("codigoTipoCambio").descending());

			Page<TipoCambio> pageCodigoTipoCambio  = factoryPoliticaComercialDAO.getTipoCambioRepository().findByCodigoTipoCambio(objTipoCambio.getCodigoTipoCambio(), pageByCodigoTipoCambio);
			/***Si existe reemplazar por el nuevo*/
			if(!pageCodigoTipoCambio.isEmpty()){

				politicaComercial.setTipoCambio(pageCodigoTipoCambio.getContent().get(0));

			}else {
				throw new LogicaImplException("No existe TipoNegocio con identificador:" +objTipoCambio.getCodigoTipoCambio());
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}	

	@Cacheable(value="listarTipoCambioxTipoMonedaBase")
	public PoliticaComercial listarTipoCambioxTipoMonedaBase(TipoCambio objTipoCambio) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<TipoCambio> listaTipoCambio = factoryPoliticaComercialDAO.getTipoCambioRepository().
					findByIdTipoMonedaBase(objTipoCambio.getIdTipoMonedaBase());

			if(listaTipoCambio !=null && !listaTipoCambio.isEmpty()){
				politicaComercial.setListaTipoCambio(listaTipoCambio);
			}else {
				throw new LogicaImplException("No se puede buscar TipoCambio, parametros no existen en un identificador valido");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="listarTodoTipoCambio")
	public PoliticaComercial listarTodoTipoCambio() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<TipoCambio> listaTipoCambio = factoryPoliticaComercialDAO.getTipoCambioRepository().findAll();

			if(listaTipoCambio !=null && !listaTipoCambio.isEmpty()){
				politicaComercial.setListaTipoCambio(listaTipoCambio);
			}else {
				throw new LogicaImplException("No existe lista de TipoCambio");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	/***********************************************************/
	/******ProductoPoliticaComercial ProductoPoliticaComercial *************/
	/***********************************************************/
	
//public PoliticaComercial generarCodigoTipoCambio(TipoCambio objTipoCambio) throws LogicaImplException{
//		
//		PoliticaComercial politicaComercial = new PoliticaComercial();
//		try {
//			if((objTipoCambio.getIdTipoMonedaBase().getIdTipoMoneda()>0 && objTipoCambio.getIdTipoMonedaCambio().getIdTipoMoneda()>0)){
//				if(buscarTipoMoneda(objTipoCambio.getIdTipoMonedaBase()).getTipoMoneda().getEstadoTipoMoneda()){ //Obtener Moneda Base
//					if(buscarTipoMoneda(objTipoCambio.getIdTipoMonedaCambio()).getTipoMoneda().getEstadoTipoMoneda()){ //Obtener Moneda de Cambio
//
//						String codigoTipoCambio = UtilidadesPoliticaComercial.obtenerCodigoTipoCambio(objTipoCambio);
//
//						Pageable pageByCodigoTipoCambio = PageRequest.of(0, 1, Sort.by("codigoTipoCambio").descending());
//
//						Page<TipoCambio> pageCodigoTipoCambio  = factoryPoliticaComercialDAO.getTipoCambioRepository().
//								findByCodigoTipoCambio(codigoTipoCambio, pageByCodigoTipoCambio);
//
//						if(pageCodigoTipoCambio.isEmpty()){
//							TipoCambio tipoCambio = factoryPoliticaComercialDAO.getTipoCambioRepository().
//									findByIdTipoMonedaBaseAndIdTipoMonedaCambio(
//											objTipoCambio.getIdTipoMonedaBase(), 
//											objTipoCambio.getIdTipoMonedaCambio());
//							if(tipoCambio== null || tipoCambio.getCodigoTipoCambio()==null || tipoCambio.getCodigoTipoCambio().equals("")){
//								objTipoCambio.setCodigoTipoCambio(codigoTipoCambio);
//								politicaComercial.setTipoCambio(objTipoCambio);
//							}else {
//								throw new LogicaImplException("No se puede crear TipoCambio, parametros ya existen en identificador valido");
//							}
//
//						}else {
//							throw new LogicaImplException("No se puede crear TipoCambio, codigo ya existe con identificador valido");
//						}
//					}else {
//						throw new LogicaImplException("No se puede crear TipoCambio, moneda cambio invalida");
//					}
//				}else {
//					throw new LogicaImplException("No se puede crear TipoCambio, moneda base invalida");
//				}
//			}else {
//				throw new LogicaImplException("No se puede crear TipoCambio, datos de moneda invalidos");
//			}
//		} catch (Exception e) {
//			throw new LogicaImplException(e.getMessage());
//		}
//
//		return politicaComercial;
//	}
	
	public PoliticaComercial generarNuevoCodigoProductoFeeComision(ProductoFeeComision objProductoFeeComision) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			//Tipo de Fee Activo y Tipo de Negocio Activo 

			String codigoProductoFeeComision = UtilidadesPoliticaComercial.obtenerCodigoProductoFeeComision(objProductoFeeComision);

			if(buscarTipoFeeComision(objProductoFeeComision.getIdTipoFeeComision()).getTipoFeeComision().getEstadoTipoFeeComision() &&
					buscarTipoFeeComision(objProductoFeeComision.getIdTipoFeeComision()).getTipoFeeComision().getEstadoTipoFeeComision() && 
					buscarTipoNegocio(objProductoFeeComision.getIdTipoNegocio()).getTipoNegocio().getEstadoTipoNegocio() &&
					codigoProductoFeeComision!=null && !"".equals(codigoProductoFeeComision)) {
				/**Buscar si el codigo existe*/
				Pageable pageByCodigoDesc = PageRequest.of(0, 1, Sort.by("codigoProductoFeeComision").descending());
				/*****Buscar el ProductoFeeComision por codigo *****/
				Page<ProductoFeeComision> pageCodigoProducto  = factoryPoliticaComercialDAO.getProductoFeeComisionRepository().findByCodigoProductoFeeComision(
						codigoProductoFeeComision, pageByCodigoDesc);

				ProductoFeeComision productoFeeComision = (pageCodigoProducto.isEmpty()) ? factoryPoliticaComercialDAO.getProductoFeeComisionRepository().
						findByIdTipoNegocioAndIdTipoFeeComisionAndIdPaisAndNombreProductoServicio( objProductoFeeComision.getIdTipoNegocio(), objProductoFeeComision.getIdTipoFeeComision(),
								objProductoFeeComision.getIdPais(), objProductoFeeComision.getNombreProductoServicio()) : null; 

						if(productoFeeComision != null){

							throw new LogicaImplException("No se puede crear ProductoFeeComision, codigo ya existe con identificador valido");

						}

						objProductoFeeComision.setCodigoProductoFeeComision(codigoProductoFeeComision);

						politicaComercial.setProductoFeeComision(objProductoFeeComision);


			}else {
				throw new LogicaImplException("No se puede crear ProductoFeeComision, tipo de negocio inactivo");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial crearProductoFeeComision(ProductoFeeComision objProductoFeeComision) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			/****Siempre validar que no exista el codigo ******/
			/****Siempre validar que no tipofee y tiponegocio + nombre ******/

			if(objProductoFeeComision.getCodigoProductoFeeComision().equals(UtilidadesPoliticaComercial.
					obtenerCodigoProductoFeeComision(objProductoFeeComision))) {
				Pageable pageByCodigoDesc = PageRequest.of(0, 1, Sort.by("codigoProductoFeeComision").descending());
				/*****Buscar el ProductoFeeComision por codigo *****/
				Page<ProductoFeeComision> pageCodigoProducto  = factoryPoliticaComercialDAO.getProductoFeeComisionRepository().findByCodigoProductoFeeComision(
						objProductoFeeComision.getCodigoProductoFeeComision(), pageByCodigoDesc);

				//Con el nombre obtenido constrastar si existe con ese idTipoNegocio y idTipoFee 
				ProductoFeeComision productoFeeComision = (pageCodigoProducto.isEmpty()) ? factoryPoliticaComercialDAO.getProductoFeeComisionRepository().
						findByIdTipoNegocioAndIdTipoFeeComisionAndIdPaisAndNombreProductoServicio( objProductoFeeComision.getIdTipoNegocio(), objProductoFeeComision.getIdTipoFeeComision(), 
								objProductoFeeComision.getIdPais(), objProductoFeeComision.getNombreProductoServicio()) : null;
						//debe ir el codigo del productoFeeComision
						if(productoFeeComision!=null){
							throw new LogicaImplException("No se puede crear ProductoFeeComision, parametros ya existen en identificador valido");
						}
						objProductoFeeComision.setEstadoProductoFeeComision(true);

						factoryPoliticaComercialDAO.getProductoFeeComisionRepository().save(objProductoFeeComision);

						productoFeeComision= buscarProductoFeeComisionxCodigoProductoServicio(objProductoFeeComision).getProductoFeeComision();

						politicaComercial.setProductoFeeComision(productoFeeComision);
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial actualizarProductoFeeComision(String codigoProductoFeeComision, ProductoFeeComision objProductoFeeComision) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			//Tiene que existir el productoPoliticaComercial - tiponegoci - tipofee - nombre
			
			if(objProductoFeeComision.getCodigoProductoFeeComision()!=null && codigoProductoFeeComision.equals(
					UtilidadesPoliticaComercial.obtenerCodigoProductoFeeComision(objProductoFeeComision)) && 
					buscarProductoFeeComisionxCodigoProductoServicio(new ProductoFeeComision(codigoProductoFeeComision)).getProductoFeeComision()!=null){

					objProductoFeeComision.setCodigoProductoFeeComision(codigoProductoFeeComision);

					factoryPoliticaComercialDAO.getProductoFeeComisionRepository().save(objProductoFeeComision);

					politicaComercial.setProductoFeeComision(objProductoFeeComision);
				
			}else {
				throw new LogicaImplException("No se puede actualizar ProductoFeeComision, parametros existen en un identificador distinto");
			}
			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	@Cacheable(value="buscarProductoFeeComisionxCodigoProductoServicio")
	public PoliticaComercial buscarProductoFeeComisionxCodigoProductoServicio(ProductoFeeComision objProductoFeeComision) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {

			Pageable pageByCodigoDesc = PageRequest.of(0, 1, Sort.by("codigoProductoFeeComision").descending());
			/*****Buscar el ProductoFeeComision por codigo *****/
			Page<ProductoFeeComision> pageCodigoProducto  = factoryPoliticaComercialDAO.getProductoFeeComisionRepository().findByCodigoProductoFeeComision(
					objProductoFeeComision.getCodigoProductoFeeComision(), pageByCodigoDesc);

			if(!pageCodigoProducto.isEmpty()){

				politicaComercial.setProductoFeeComision(pageCodigoProducto.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe ProductoFeeComision con codigo:" +objProductoFeeComision.getCodigoProductoFeeComision());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	//sin cache

	@Cacheable(value="listarTodoProductoFeeComision")
	public PoliticaComercial listarTodoProductoFeeComision() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<ProductoFeeComision> listaProductoFeeComision = factoryPoliticaComercialDAO.getProductoFeeComisionRepository().findAll();

			if(listaProductoFeeComision !=null && !listaProductoFeeComision.isEmpty()){
				politicaComercial.setListaProductoFeeComision(listaProductoFeeComision);
			}else {
				throw new LogicaImplException("No existe lista de ProductoFeeComision");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}


	public PoliticaComercial listarProductoFeeComisionxTipoNegocioxEstado(ProductoFeeComision objProductoFeeComision) throws LogicaImplException {
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {
			List<ProductoFeeComision> listaProductoFeeComision = factoryPoliticaComercialDAO.getProductoFeeComisionRepository().findByIdTipoNegocioAndEstadoProductoFeeComision(
					objProductoFeeComision.getIdTipoNegocio(), objProductoFeeComision.getEstadoProductoFeeComision());

			if(listaProductoFeeComision !=null && !listaProductoFeeComision.isEmpty()){
				politicaComercial.setListaProductoFeeComision(listaProductoFeeComision);
			}else {
				throw new LogicaImplException("No existe lista de ProductoFeeComision");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}
	
	/***********************************************************/
	/******HistorialTipoCambio HistorialTipoCambio ***********/
	/******No setear las fecha de inicio o final ***************/
	/**Cuando se crea un HistorialTipoCambio, se consulta el ultimo activo asociado al producto, se hace inactivo y luego crear el nuevo history*/
	public PoliticaComercial crearHistorialTipoCambio(HistorialTipoCambio objHistorialTipoCambio) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		String ahoraYYYY_MM_ddTHH_MM_SSZ = AppDate.obtenerFechaEnFormato(new Date(), TipoFormatoFecha.YYYY_MM_ddTHH_MM_SSZ);

		try {	

			HistorialTipoCambio repHistorialTipoCambio = (objHistorialTipoCambio!=null) ?
					factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().findByIdTipoCambioAndEstadoHistorialTipoCambio
					(buscarTipoCambioxCodigo(objHistorialTipoCambio.getIdTipoCambio()).getTipoCambio(), estadoActivoConsulta) : null;

					/**Solo Puede haber activo un tipo de HistorialTipoCambio por TipoCambio*/
					if(repHistorialTipoCambio!=null && repHistorialTipoCambio.getIdHistorialTipoCambio()>0){
						/***aqui a la respuesta del repositorio, actualizar el estado a inactivo***/

						repHistorialTipoCambio.setEstadoHistorialTipoCambio(estadoInactivoConsulta);
						repHistorialTipoCambio.setFechaFinalTipoCambio(DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(ahoraYYYY_MM_ddTHH_MM_SSZ));
						factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().save(repHistorialTipoCambio);
					}
					/******* Obtener el ultimo de la lista de HistorialTipoCambio ******/
					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idHistorialTipoCambio").descending());

					Page<HistorialTipoCambio> pageIdHistorialTipoCambio = factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().findAll(pageByidDesc);

					Integer idHistorialTipoCambio = (!pageIdHistorialTipoCambio.isEmpty()) ? (Integer) pageIdHistorialTipoCambio.getContent().get(0).getIdHistorialTipoCambio() + 1 : 1; 

					/******* Obtener el ultimo de la lista de HistorialTipoCambio ******/

					//siempre guardar objHistorialTipoCambio
					objHistorialTipoCambio.setIdHistorialTipoCambio(idHistorialTipoCambio);
					objHistorialTipoCambio.setFechaInicioTipoCambio(DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(ahoraYYYY_MM_ddTHH_MM_SSZ));
					objHistorialTipoCambio.setEstadoHistorialTipoCambio(estadoActivoConsulta);

					factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().save(objHistorialTipoCambio);

					repHistorialTipoCambio = buscarHistorialTipoCambioxTipoCambioxActivo(objHistorialTipoCambio).getHistorialTipoCambio();

					politicaComercial.setHistorialTipoCambio(repHistorialTipoCambio);

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial buscarHistorialTipoCambioxTipoCambioxActivo(HistorialTipoCambio objHistorialTipoCambio) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();
		try {

			HistorialTipoCambio repHistorialTipoCambio = factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().findByIdTipoCambioAndEstadoHistorialTipoCambio
					(objHistorialTipoCambio.getIdTipoCambio(), estadoActivoConsulta);

			/***Si existe reemplazar por el nuevo*/
			if(repHistorialTipoCambio!=null && repHistorialTipoCambio.getIdHistorialTipoCambio()>0){

				politicaComercial.setHistorialTipoCambio(repHistorialTipoCambio);

			}else {
				throw new LogicaImplException("No existe HistorialTipoCambio con identificador:" +objHistorialTipoCambio.getIdHistorialTipoCambio());
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}	

	//desde el historial de comisiones obtener los activos
	public PoliticaComercial listarHistorialTipoCambioxActivo() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			List<HistorialTipoCambio> repListaHistorialTipoCambio = factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().
					findAllByEstadoHistorialTipoCambio(estadoActivoConsulta);

			if(repListaHistorialTipoCambio!=null && !repListaHistorialTipoCambio.isEmpty()){
				politicaComercial.setListaHistorialTipoCambio(repListaHistorialTipoCambio);
			}else {
				throw new LogicaImplException("No existe lista de HistorialTipoCambio");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	//desde el historial de comisiones obtener los activos
	public PoliticaComercial listarHistorialTipoCambioxTipoCambioEntreFechas(String codigoTipoCambio, String sFechaInicial, String sFechaFinal) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {

			buscarTipoCambioxCodigo(new TipoCambio(codigoTipoCambio));

			Timestamp tsInicial = DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(sFechaInicial);

			Timestamp tsFinal = DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(sFechaFinal);

			List<HistorialTipoCambio> repListaHistorialTipoCambio = factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().
					findAllByIdTipoCambioAndFechaInicioTipoCambioBetween(new TipoCambio(codigoTipoCambio), tsInicial, tsFinal);

			if(repListaHistorialTipoCambio!=null && !repListaHistorialTipoCambio.isEmpty()){
				politicaComercial.setListaHistorialTipoCambio(repListaHistorialTipoCambio);
			}else {
				throw new LogicaImplException("No existe TipoCambio asociado al codigo:"+codigoTipoCambio);
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	public PoliticaComercial listarTodoHistorialTipoCambio() throws LogicaImplException {
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			List<HistorialTipoCambio> repListaHistorialTipoCambio = factoryPoliticaComercialDAO.getHistorialTipoCambioRepository().findAll();

			if(repListaHistorialTipoCambio!=null && !repListaHistorialTipoCambio.isEmpty()){
				politicaComercial.setListaHistorialTipoCambio(repListaHistorialTipoCambio);
			}else {
				throw new LogicaImplException("No existe lista de HistorialTipoCambio");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}
	
	/***********************************************************/
	/******HistorialFeeComision HistorialFeeComision ***********/
	/******No setear las fecha de inicio o final ***************/
	/**Cuando se crea un HistorialFeeComision, se consulta el ultimo activo asociado al producto, se hace inactivo y luego crear el nuevo history*/
	public PoliticaComercial crearHistorialFeeComision(HistorialFeeComision objHistorialFeeComision) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();


		String ahoraYYYY_MM_ddTHH_MM_SSZ = AppDate.obtenerFechaEnFormato(new Date(), TipoFormatoFecha.YYYY_MM_ddTHH_MM_SSZ);

		try {
			TipoValorComision feeTipoValorComision = buscarTipoValorComision(objHistorialFeeComision.getIdTipoValorComision()).getTipoValorComision();

			ProductoFeeComision feeProductoPoliticaComercial = buscarProductoFeeComisionxCodigoProductoServicio(objHistorialFeeComision.getIdProductoFeeComision()).getProductoFeeComision();

			if(objHistorialFeeComision.getPorcentajeFeeComision().doubleValue() < feeTipoValorComision.getLimiteValorComision()) {

				HistorialFeeComision repHistorialFeeComision = (objHistorialFeeComision!=null) ?
						factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().findByIdProductoFeeComisionAndEstadoFeeComision
						(feeProductoPoliticaComercial, estadoActivoConsulta) : null;

						/**Solo Puede haber activo un tipo de HistorialPoliticaComercial por ProductoFeeComision*/

						if(repHistorialFeeComision!=null && repHistorialFeeComision.getIdHistorialFeeComision()>0){
							/***aqui a la respuesta del repositorio, actualizar el estado a inactivo***/

							repHistorialFeeComision.setEstadoFeeComision(estadoInactivoConsulta);
							repHistorialFeeComision.setFechaFinalFeeComision(DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(ahoraYYYY_MM_ddTHH_MM_SSZ));
							factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().save(repHistorialFeeComision);

						}

						/******* Obtener el ultimo de la lista de HistorialFeeComision ******/
						Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idHistorialFeeComision").descending());

						Page<HistorialFeeComision> pageIdHistorialFeeComision = factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().findAll(pageByidDesc);

						Integer idHistorialFeeComision = (!pageIdHistorialFeeComision.isEmpty()) ? (Integer) pageIdHistorialFeeComision.getContent().get(0).getIdHistorialFeeComision() + 1 : 1;
						/******* Obtener el ultimo de la lista de HistorialFeeComision ******/

						//siempre guardar objHistorialFeeComision
						objHistorialFeeComision.setIdHistorialFeeComision(idHistorialFeeComision);
						objHistorialFeeComision.setIdProductoFeeComision(feeProductoPoliticaComercial);
						objHistorialFeeComision.setIdTipoValorComision(feeTipoValorComision);
						objHistorialFeeComision.setFechaInicioFeeComision(DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(ahoraYYYY_MM_ddTHH_MM_SSZ));
						objHistorialFeeComision.setEstadoFeeComision(estadoActivoConsulta);

						factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().save(objHistorialFeeComision);

						repHistorialFeeComision = factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().findByIdProductoFeeComisionAndEstadoFeeComision
								(objHistorialFeeComision.getIdProductoFeeComision(), estadoActivoConsulta);

						politicaComercial.setHistorialFeeComision(repHistorialFeeComision);
			}else {
				throw new LogicaImplException("No se puede crear HistorialFeeComision, valor de comision es invalido");
			}




		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return politicaComercial;
	}

	public PoliticaComercial buscarHistorialFeeComisionxProductoFeeComisionxActivo(HistorialFeeComision objHistorialFeeComision) throws LogicaImplException{

		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			/***buscar por el codigo productoFeeComision****/

			HistorialFeeComision repHistorialFeeComision = factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().findByIdProductoFeeComisionAndEstadoFeeComision
					(buscarProductoFeeComisionxCodigoProductoServicio(objHistorialFeeComision.getIdProductoFeeComision()).getProductoFeeComision(), estadoActivoConsulta);
			if(repHistorialFeeComision!=null && repHistorialFeeComision.getIdHistorialFeeComision()>0){

				politicaComercial.setHistorialFeeComision(repHistorialFeeComision);

			}else {
				throw new LogicaImplException("No existe HistorialFeeComision con identificador activo :" +objHistorialFeeComision.getIdProductoFeeComision().getCodigoProductoFeeComision());
			}


			/***Si existe reemplazar por el nuevo*/

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}	

	public PoliticaComercial listarTodoHistorialFeeComision() throws LogicaImplException {
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			List<HistorialFeeComision> repListaHistorialFeeComision = factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().findAll();

			if(repListaHistorialFeeComision!=null && !repListaHistorialFeeComision.isEmpty()){
				politicaComercial.setListaHistorialFeeComision(repListaHistorialFeeComision);
			}else {
				throw new LogicaImplException("No existe lista de HistorialFeeComision");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	//desde el historial de comisiones obtener los activos
	public PoliticaComercial listarHistorialFeeComisionxActivo() throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			List<HistorialFeeComision> repListaHistorialFeeComision = factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().
					findAllByEstadoFeeComision(estadoActivoConsulta);

			if(repListaHistorialFeeComision!=null && !repListaHistorialFeeComision.isEmpty()){
				politicaComercial.setListaHistorialFeeComision(repListaHistorialFeeComision);
			}else {
				throw new LogicaImplException("No existe lista de HistorialFeeComision");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}

	//desde el historial de comisiones obtener los activos
	public PoliticaComercial listarHistorialFeeComisionxProductoFeeComisionEntreFechas(String codigoProductoFeeComision, String sFechaInicial, String sFechaFinal) throws LogicaImplException{
		
		PoliticaComercial politicaComercial = new PoliticaComercial();

		try {
			Timestamp tsInicial = DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(sFechaInicial);

			Timestamp tsFinal = DateMapper.mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(sFechaFinal);

			ProductoFeeComision feeProductoPoliticaComercial = buscarProductoFeeComisionxCodigoProductoServicio(new ProductoFeeComision(codigoProductoFeeComision)).getProductoFeeComision();

			if(!feeProductoPoliticaComercial.getCodigoProductoFeeComision().equals("")) {
				List<HistorialFeeComision> repListaHistorialFeeComision = factoryPoliticaComercialDAO.getHistorialFeeComisionRepository().
						findAllByIdProductoFeeComisionAndFechaInicioFeeComisionBetween(feeProductoPoliticaComercial, tsInicial, tsFinal);

				if(repListaHistorialFeeComision!=null && !repListaHistorialFeeComision.isEmpty()){
					politicaComercial.setListaHistorialFeeComision(repListaHistorialFeeComision);
				}else {
					throw new LogicaImplException("No existe lista de HistorialFeeComision");
				}
			}else {
				throw new LogicaImplException("No existe lista HistorialFeeComision, codigo de ProductoFeeComision invalido");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return politicaComercial;
	}


	/**Generar el metodo de limpieza de cache local y publicar en swagger**/
	public void limpiarCacheLocal() {
		evictBuscarTipoMoneda();
		evictListarTodoTipoMoneda();
		evictBuscarTipoNegocio();
		evictListarTodoTipoNegocio();
		evictBuscarTipoFeeComision();
		evictListarTodoTipoFeeComision(); 
		evictBuscarTipoValorComision();
		evictListarTodoTipoValorComision();
		evictBuscarPaisxCodigoPortal();
		evictListarTodoPais();
		evictBuscarTipoCambioxCodigo();
		evictListarTipoCambioxTipoMonedaBase();
		evictListarTodoTipoCambio(); 
		
		evictBuscarProductoFeeComisionxCodigo();
		evictListarTodoProductoFeeComision();
	}

	@CacheEvict(value="buscarTipoMoneda", allEntries=true)
	private void evictBuscarTipoMoneda() {
		System.out.println("Evicting buscarTipoMoneda");
	}

	@CacheEvict(value="listarTodoTipoMoneda", allEntries=true)
	private void evictListarTodoTipoMoneda() {
		System.out.println("Evicting listarTodoTipoMoneda");
	}
	
	@CacheEvict(value="buscarTipoNegocio", allEntries=true)
    private void evictBuscarTipoNegocio() {
        System.out.println("Evicting buscarTipoNegocio");
    }
	
	@CacheEvict(value="listarTodoTipoNegocio", allEntries=true)
	private void evictListarTodoTipoNegocio() {
        System.out.println("Evicting listarTodoTipoNegocio");
    }
	
	@CacheEvict(value="buscarTipoFeeComision", allEntries=true)
	private void evictBuscarTipoFeeComision() {
        System.out.println("Evicting buscarTipoFeeComision");
    }
	
	@CacheEvict(value="listarTodoTipoFeeComision", allEntries=true)
	private void evictListarTodoTipoFeeComision() {
        System.out.println("Evicting listarTodoTipoFeeComision");
    }
	
	@CacheEvict(value="buscarTipoValorComision", allEntries=true)
    private void evictBuscarTipoValorComision() {
        System.out.println("Evicting buscarTipoValorComision");
    }
	
	@CacheEvict(value="listarTodoTipoValorComision", allEntries=true)
	private void evictListarTodoTipoValorComision() {
        System.out.println("Evicting listarTodoTipoValorComision");
    }
	
	@CacheEvict(value="buscarPaisxCodigoPortal", allEntries=true)
	private void evictBuscarPaisxCodigoPortal() {
		System.out.println("Evicting buscarPaisxCodigoPortal");
	}
	
	@CacheEvict(value="listarTodoPais", allEntries=true)
	private void evictListarTodoPais() {
		System.out.println("Evicting listarTodoPais");
	}
	
	@CacheEvict(value="buscarTipoCambioxCodigo", allEntries=true)
	private void evictBuscarTipoCambioxCodigo() {
		System.out.println("Evicting buscarTipoCambioxCodigo");
	}
	
	@CacheEvict(value="listarTipoCambioxTipoMonedaBase", allEntries=true)
	private void evictListarTipoCambioxTipoMonedaBase() {
		System.out.println("Evicting listarTipoCambioxTipoMonedaBase");
	}
	
	@CacheEvict(value="listarTodoTipoCambio", allEntries=true)
	private void evictListarTodoTipoCambio() {
		System.out.println("Evicting listarTodoTipoCambio");
	}
	
	@CacheEvict(value="buscarProductoFeeComisionxCodigo", allEntries=true)
	private void evictBuscarProductoFeeComisionxCodigo() {
        System.out.println("Evicting buscarProductoFeeComisionxCodigo");
    }
	
	@CacheEvict(value="listarTodoProductoFeeComision", allEntries=true)
	private void evictListarTodoProductoFeeComision() {
        System.out.println("Evicting listarTodoProductoFeeComision");
    }
	
}
