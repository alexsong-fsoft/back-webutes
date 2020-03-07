package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Presolicitud;

@Repository
public interface PresolicitudRepository extends JpaRepository<Presolicitud, Integer> {

	List<Presolicitud> findByPersonaPerCedula(String cedula, Sort sort);

	List<Presolicitud> findByPersonaPerCedulaAndInscripcionIdIns(String cedula, Integer idIns, Sort sort);

	List<Presolicitud> findByPersonaIdPerAndInscripcionIdIns(Integer idPer, Integer idIns, Sort sort);

	List<Presolicitud> findByPslIdEstado(Integer pslIdEstado);

	List<Presolicitud> findByPersonaIdPerIn(List<Integer> ids);

	List<Presolicitud> findByPslIdOpcionAndPslIdEstadoIn(Integer pslIdOpcion, List<Integer> listPslIdEstado);

	List<Presolicitud> findByPslIdOpcionInAndPslIdEstadoIn(List<Integer> listPslIdOpcion,
			List<Integer> listPslIdEstado);

	@Query(nativeQuery = true, value = "SELECT id_psl FROM presolicitud WHERE fk_per =:idpersona order by 1 desc limit 1 ")
	Integer obtenerIdPresolicidutxUltimoRegistrado(@Param("idpersona") Integer idpersona);

}
