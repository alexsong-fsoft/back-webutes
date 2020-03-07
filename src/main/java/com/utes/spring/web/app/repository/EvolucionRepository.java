package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Evolucion;

@Repository
public interface EvolucionRepository extends JpaRepository<Evolucion, Integer> {

	List<Evolucion> findByEvlActivo(Boolean estado);

	List<Evolucion> findByTemaIdTemOrderByEvlFechaCitaDesc(Integer idTema);

	List<Evolucion> findByTemaIdTem(Integer idTema);

	@Query(nativeQuery = true, value = "SELECT max(evl_secuencia)+1 FROM evolucion WHERE fk_tem =:idtema ")
	Integer obtenerSecuencialEvolucion(@Param("idtema") Integer idTema);

	List<Evolucion> findByEvlIdEstadoAndTemaIdTemOrderByIdEvlDesc(Integer evlIdEstado, Integer idTema);
}
