package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {

	List<Respuesta> findByPresolicitudIdPsl(Integer idPsl);

	Respuesta findByPresolicitudIdPslAndCuestionarioIdCue(Integer idPsl, Integer idCue);
}
