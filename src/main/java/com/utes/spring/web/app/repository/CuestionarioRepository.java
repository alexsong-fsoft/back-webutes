package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Cuestionario;

@Repository
public interface CuestionarioRepository extends JpaRepository<Cuestionario, Integer> {

	List<Cuestionario> findByCueActivo(boolean estado);

	List<Cuestionario> findByCueActivoAndCueIdInscripcionAndCueIdTipoIn(boolean estado, Integer idInscripcion,
			List<Integer> listIdTipo);

}
