package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Hito;

@Repository
public interface HitoRepository extends JpaRepository<Hito, Integer> {

	List<Hito> findByHitValida(Boolean estado);

	List<Hito> findByTemaIdTemOrderByHitFechaEntregaAsc(Integer idTema);

	@Query(nativeQuery = true, value = "SELECT max(hit_secuencia)+1 FROM Hito WHERE fk_tem =:idtema ")
	Integer obtenerSecuencialHito(@Param("idtema") Integer idTema);

}
