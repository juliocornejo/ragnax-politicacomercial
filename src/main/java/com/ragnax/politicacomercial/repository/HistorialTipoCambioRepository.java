package com.ragnax.politicacomercial.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.politicacomercial.entidad.HistorialTipoCambio;
import com.ragnax.politicacomercial.entidad.TipoCambio;

public interface HistorialTipoCambioRepository extends JpaRepository<HistorialTipoCambio, Integer> {
	
	HistorialTipoCambio findByIdTipoCambioAndEstadoHistorialTipoCambio(TipoCambio fkIdTipoCambio, Boolean estadoHistorialTipoCambio);
	List<HistorialTipoCambio> findAllByEstadoHistorialTipoCambio(Boolean estadoHistorialTipoCambio);
	List<HistorialTipoCambio> findAllByIdTipoCambioAndFechaInicioTipoCambioBetween(TipoCambio fkIdTipoCambio, Timestamp limiteInicialFechaInicioFeeComision, Timestamp limiteFinalFechaInicioFeeComision);

}
