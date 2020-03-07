package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Asignado;

@Repository
public interface AsignadoRepository extends JpaRepository<Asignado, Integer> {

	List<Asignado> findByAsgActivo(boolean activo);

	List<Asignado> findByPersonaIdPerAndTemaIdTem(Integer idPer, Integer idTem);

	List<Asignado> findByPersonaPerCedula(String perCedula);

	List<Asignado> findByTemaIdTem(Integer idTem);

	List<Asignado> findByAsgActivoAndPersonaIdPer(boolean activo, Integer idPer);

	List<Asignado> findByAsgActivoAndPersonaIdPerAndAsgIdTipo(boolean activo, Integer idPer, Integer asgIdTipo);

	List<Asignado> findByAsgIdTipoAndAsgActivoAndTemaIdTem(Integer asgIdTipo, boolean asgActivo, Integer idTem);

	List<Asignado> findByAsgIdTipoAndTemaIdTemIn(Integer asgIdTipo, List<Integer> listIdTem);

	List<Asignado> findByAsgIdTipoInAndTemaIdTemIn(List<Integer> listAsgIdTipo, List<Integer> listIdTem);

	List<Asignado> findByAsgIdTipo(Integer asgIdTipo);

	List<Asignado> findByAsgIdTipoInAndPersonaIdPerAndTemaIdTem(List<Integer> listAsgIdTipo, Integer idPer,
			Integer idTem);

	List<Asignado> findByAsgIdEstadoTemaAndPersonaIdPerAndTemaIdTem(Integer asgIdEstadoTema, Integer idPer,
			Integer idTem);

	List<Asignado> findByAsgIdTipoAndAsgIdEstadoTemaAndPersonaIdPerAndTemaIdTem(Integer asgIdTipo,
			Integer asgIdEstadoTema, Integer idPer, Integer idTem);

	@Query(nativeQuery = true, value = "SELECT count(asg_idtipo) FROM asignado WHERE fk_per =:idpersona and asg_idtipo=:idtipo and asg_idestadotema=:idestadotema limit 1 ")
	Integer obtenerCountAsignado(@Param("idpersona") Integer idpersona, @Param("idtipo") Integer idtipo,
			@Param("idestadotema") Integer idestadotema);

	@Query(nativeQuery = true, value = "SELECT id_asg FROM asignado WHERE fk_per =:idpersona and fk_tem=:idtema order by 1 desc limit 1 ")
	Integer obtenerIdAsignadoxTemaUltimoEstado(@Param("idpersona") Integer idpersona, @Param("idtema") Integer idtema);

}
