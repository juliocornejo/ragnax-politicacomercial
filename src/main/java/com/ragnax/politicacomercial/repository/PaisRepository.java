package com.ragnax.politicacomercial.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.Pais;


public interface PaisRepository extends JpaRepository<Pais, Integer> {
	
	@Query("select p from Pais p where p.codigoPortalPaisLowerCase = :codigoPortalPaisLowerCase")
	Page<Pais> findByCodigoPortalPaisLowerCase(String codigoPortalPaisLowerCase, Pageable page);
	
	@Query("select p from Pais p where p.nombrePaisLowerCase = :nombrePaisLowerCase")
	Page<Pais> findByNombrePaisLowerCase(String nombrePaisLowerCase, Pageable page);
	
}
