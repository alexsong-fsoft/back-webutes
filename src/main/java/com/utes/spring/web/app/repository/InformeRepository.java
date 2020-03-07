package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Informe;

@Repository
public interface InformeRepository extends JpaRepository<Informe, Integer> {

	List<Informe> findByInfActivo(Boolean estado);

	List<Informe> findByTemaIdTemOrderByInfFechaDesc(Integer idTema);

	List<Informe> findByTemaIdTemAndPersonaIdPerOrderByInfFechaDesc(Integer idTema, Integer idPersona);
}
