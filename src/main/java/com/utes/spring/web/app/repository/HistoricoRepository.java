package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

	List<Historico> findByHisTemaOrderByHisFechaCambioAsc(Integer idTema);

	List<Historico> findByHisTemaAndHisPersonaOrderByHisFechaCambioAsc(Integer idTema, Integer idPersona);

}
