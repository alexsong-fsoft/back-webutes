package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Periodo;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

	Periodo findByIdPrdAndPrdActivo(Integer idPrd, boolean estado);

	List<Periodo> findByPrdActivo(boolean estado);

	List<Periodo> findByPrdNumero(Integer prdNumero);

	@Query(nativeQuery = true, value = "SELECT last_value FROM periodo_id_prd_seq")
	Integer obtenerUltimoRegistroPeriodo();
}
