package com.ragnax.politicacomercial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.TipoValorComision;

public interface TipoValorComisionRepository extends JpaRepository<TipoValorComision, Integer> {
	
	
	@Query("select tvc from TipoValorComision tvc where tvc.nombreTipoValorComision = :nombreTipoValorComision")
	Page<TipoValorComision> findByNombreTipoValorComision(String nombreTipoValorComision, Pageable page);
	List<TipoValorComision> findAll();
	
	
}
