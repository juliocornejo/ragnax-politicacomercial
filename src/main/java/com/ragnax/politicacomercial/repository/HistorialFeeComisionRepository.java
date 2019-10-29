package com.ragnax.politicacomercial.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.politicacomercial.entidad.HistorialFeeComision;
import com.ragnax.politicacomercial.entidad.ProductoFeeComision;


public interface HistorialFeeComisionRepository extends JpaRepository<HistorialFeeComision, Integer> {
	
	HistorialFeeComision findByIdProductoFeeComisionAndEstadoFeeComision(ProductoFeeComision objProductoFeeComision, Boolean estadoFeeComision);
	List<HistorialFeeComision> findAllByEstadoFeeComision(Boolean estadoFeeComision);
	List<HistorialFeeComision> findAllByIdProductoFeeComisionAndFechaInicioFeeComisionBetween(ProductoFeeComision fkIdProductoFeeComision, Timestamp limiteInicialFechaInicioFeeComision, Timestamp limiteFinalFechaInicioFeeComision);

}
