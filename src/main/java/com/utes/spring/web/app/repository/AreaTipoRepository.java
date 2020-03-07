package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.AreaTipo;

@Repository
public interface AreaTipoRepository extends JpaRepository<AreaTipo, Integer> {

	List<AreaTipo> findByAretActivoOrderByAretNombreAsc(Boolean estado);

}
