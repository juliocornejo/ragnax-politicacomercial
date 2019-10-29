package com.ragnax.politicacomercial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.TipoCambio;
import com.ragnax.politicacomercial.entidad.TipoMoneda;


public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {
	
	//Traer todo lo activo por id-producto- y tipo de la comision asociada al producto
	@Query("select p from TipoCambio p where p.codigoTipoCambio = :codigoTipoCambio")
	Page<TipoCambio> findByCodigoTipoCambio(String codigoTipoCambio, Pageable page);
	
	TipoCambio findByIdTipoMonedaBaseAndIdTipoMonedaCambio(TipoMoneda fkIdTipoMonedaBase, TipoMoneda fkIdTipoMonedaCambio);
	
	List<TipoCambio> findByIdTipoMonedaBase(TipoMoneda fkIdTipoMonedaBase);
	
	List<TipoCambio> findByIdTipoMonedaCambio(TipoMoneda fkIdTipoMonedaCambio);
	
}
