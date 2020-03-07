package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.TipoResolucion;

@Repository
public interface TipoResolucionRepository extends JpaRepository<TipoResolucion, Integer> {

	List<TipoResolucion> findByTrslActive(boolean trslActive, Sort sort);
}
