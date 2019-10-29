package com.ragnax.politicacomercial.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.TipoFeeComision;

public interface TipoFeeComisionRepository extends JpaRepository<TipoFeeComision, Integer> {
	
	
	@Query("select tfc from TipoFeeComision tfc where tfc.nombreTipoFeeComision = :nombreTipoFeeComision")
	Page<TipoFeeComision> findByNombreTipoFeeComision(String nombreTipoFeeComision, Pageable page);
	List<TipoFeeComision> findAll();
	
	
}
