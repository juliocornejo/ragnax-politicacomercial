package com.ragnax.politicacomercial.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.TipoNegocio;

public interface TipoNegocioRepository extends JpaRepository<TipoNegocio, Integer> {
	
	@Query("select tn from TipoNegocio tn where tn.nombreTipoNegocio = :nombreTipoNegocio")
	Page<TipoNegocio> findByNombreTipoNegocio(String nombreTipoNegocio, Pageable page);
//	TipoNegocio findByNombreTipoNegocio(String nombreTipoNegocio);
	Page<TipoNegocio> findAll(Pageable pageable);
}
