package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Resolucion;

@Repository
public interface ResolucionRepository extends JpaRepository<Resolucion, Integer> {

	List<Resolucion> findByRslActivo(Boolean estado);

	List<Resolucion> findByTemaIdTem(Integer idTem, Sort sort);

	List<Resolucion> findByTemaIdTemAndTipoResolucionIdTrsl(Integer idTem, Integer idTrsl, Sort sort);

	List<Resolucion> findByPersonaIdPer(Integer idPer, Sort sort);
}
