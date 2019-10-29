package com.ragnax.politicacomercial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.TipoMoneda;


public interface TipoMonedaRepository extends JpaRepository<TipoMoneda, Integer> {
	
	//Traer todo lo activo por id-producto- y tipo de la comision asociada al producto
	@Query("select tm from TipoMoneda tm where tm.codigoTipoMonedaUpperCase = :codigoTipoMonedaUpperCase")
	Page<TipoMoneda> findByCodigoTipoMonedaUpperCase(String codigoTipoMonedaUpperCase, Pageable page);
	
	@Query("select tm from TipoMoneda tm where tm.nombreTipoMonedaLowerCase = :nombreTipoMonedaLowerCase")
	Page<TipoMoneda> findByNombreTipoMonedaLowerCase(String nombreTipoMonedaLowerCase, Pageable page);
	
	List<TipoMoneda> findByEstadoTipoMoneda(Boolean estadoTipoMoneda);
	
}
