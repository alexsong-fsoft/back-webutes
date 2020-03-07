package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {

	List<Area> findByAreActivoOrderByAreNombreAsc(Boolean estado);

	Page<Area> findByAreActivoOrderByAreNombreAsc(Boolean estado, Pageable pageable);

	List<Area> findByAreActivoAndIdAreIn(Boolean estado, List<Integer> ids);

	@Query("SELECT a FROM Area a JOIN a.areaTipo at WHERE a.areActivo =:estado AND at.idAreT =:idtipo ")
	List<Area> findByAreasPorTipo(@Param("estado") Boolean estado, @Param("idtipo") Integer idTipo);
}
