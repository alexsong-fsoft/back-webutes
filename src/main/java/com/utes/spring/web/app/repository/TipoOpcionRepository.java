package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.TipoOpcion;

@Repository
public interface TipoOpcionRepository extends JpaRepository<TipoOpcion, Integer> {

	List<TipoOpcion> findByTopActivo(Boolean estado);
}
