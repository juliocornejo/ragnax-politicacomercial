package com.ragnax.politicacomercial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.politicacomercial.entidad.Pais;
import com.ragnax.politicacomercial.entidad.ProductoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoFeeComision;
import com.ragnax.politicacomercial.entidad.TipoNegocio;

public interface ProductoFeeComisionRepository extends JpaRepository<ProductoFeeComision, Integer> {
	
	
	@Query("select pfc from ProductoFeeComision pfc where pfc.codigoProductoFeeComision = :codigoProductoFeeComision")
	Page<ProductoFeeComision> findByCodigoProductoFeeComision(String codigoProductoFeeComision, Pageable pageable);
	
	//Traer todo lo activo por id-producto- y tipo de la comision asociada al producto
	ProductoFeeComision findByIdTipoNegocioAndIdTipoFeeComisionAndIdPaisAndNombreProductoServicio(TipoNegocio fkIdTipoNegocio, TipoFeeComision fkIdTipoFeeComision, Pais fkIdPais, String nombreProductoServicio);
	
//	ProductoFeeComision findByIdTipoNegocioAndIdTipoFeeComisionAndNombreProductoServicioAndEstadoProductoFeeComision(TipoNegocio fkIdTipoNegocio, TipoFeeComision fkIdTipoFeeComision, String nombreProductoServicio, Boolean estadoProductoFeeComision);
	
	List<ProductoFeeComision> findByIdTipoNegocioAndEstadoProductoFeeComision(TipoNegocio fkIdTipoNegocio, Boolean estadoProductoFeeComision);
	                                 
	Page<ProductoFeeComision> findAll(Pageable pageable);
}
