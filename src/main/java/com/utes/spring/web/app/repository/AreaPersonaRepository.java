package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.AreaPersona;

@Repository
public interface AreaPersonaRepository extends JpaRepository<AreaPersona, Integer> {

	List<AreaPersona> findByArPerActivo(Boolean estado);

	List<AreaPersona> findByArPerActivoAndPersonaIdPer(Boolean estado, Integer personaId);

	AreaPersona findByArPerActivoAndPersonaIdPerAndAreaIdAre(Boolean estado, Integer personaId, Integer areaId);

	List<AreaPersona> findByArPerActivoAndPersonaIdPerAndAreaIdAreIn(Boolean estado, Integer personaId,
			List<Integer> areasId);

}
