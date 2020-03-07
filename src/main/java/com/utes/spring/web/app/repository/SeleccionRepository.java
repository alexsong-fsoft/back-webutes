package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Seleccion;

@Repository
public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {

	List<Seleccion> findByPeriodoIdPrd(Integer idPrd);

	List<Seleccion> findByPersonaIdPerAndPeriodoPrdNumero(Integer idPer, Integer prdNumero);

	List<Seleccion> findByPersonaIdPerAndPeriodoIdPrd(Integer idPer, Integer idPrd);
}
