package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.projection.TemaProjection;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Integer> {

	List<Tema> findByTemIdEstadoNotIn(List<Integer> temIdEstado, Sort sort);

	List<Tema> findByTemIdEstadoIn(List<Integer> temIdEstado, Sort sort);

	Page<Tema> findByTemIdEstadoIn(List<Integer> temIdEstado, Pageable pageable);

	List<Tema> findByTemIdEstadoInAndPersonaSysUsuarioUsrUsuario(List<Integer> temIdEstado, String usrUsuario,
			Sort sort);

	List<Tema> findByTemIdEstado(Integer temIdEstado, Sort sort);

	Tema findByTemNombre(String temNombre);

	List<Tema> findByIdTemIn(List<Integer> idTem, Sort sort);

	List<Tema> findByIdTemInAndTemIdEstadoIn(List<Integer> idTem, List<Integer> temIdEstado, Sort sort);

	Page<Tema> findByIdTemInAndTemIdEstadoIn(List<Integer> idTem, List<Integer> temIdEstado, Pageable pageable);

	@Query("SELECT a FROM Tema a JOIN a.persona at JOIN at.sysUsuario u"
			+ " WHERE a.temIdEstado =:temIdEstado AND u.usrUsuario =:nameuser ")
	List<Tema> findByUsuarioEstado(@Param("temIdEstado") Integer temIdEstado, @Param("nameuser") String nameuser);

	@Query(nativeQuery = true, value = " SELECT 	id_tem as idTem,  fk_con as fkCon,  fk_per as fkPer,  tem_idtipo as temIdTipo,  tem_idestado as temIdEstado,  tem_nombre as temNombre,  tem_descripcion as temDescripcion,  		"
			+ " 	tem_tema as temTema,  tem_numest as temNumEst,  tem_autora as temAutorA,  tem_autorb as temAutorB,  tem_fechapublicado as temFechaPublicado,  tem_auspiciante as temAuspiciante,            "
			+ " 	tem_lectorplan as temLectorPlan,  tem_lectorproyecto as temLectorProyecto,  tem_activo as temActivo,  tem_fechacreado as temFechaCreado,  tem_fechaeditado as temFechaEditado,              "
			+ " 	tem_porcavance as temPorcAvance,  tem_aprobado as temAprobado,  tem_alcance as temAlcance,  tem_objetivo as temObjetivo,  tem_fechaenviado as temFechaEnviado,  tem_nota as temNota,        "
			+ " 	tem_observacion as temObservacion,  tem_fechainicio as temFechaInicio,  tem_fechaentrega as temFechaEntrega,  tem_idperiodo as temIdPeriodo,  tem_fecharesolucion as temFechaResolucion     "
			+ " FROM 	TEMA                                                                                                                                                                                    "
			+ " WHERE 	id_tem not in(Select fk_tem FROM asignado)                                                                                                                                              "
			+ " 	and id_tem != :idTema                                                                                                                                                                           ")
	List<TemaProjection> findByIdExceptoActual(@Param("idTema") Integer idTema);

	List<Tema> findByConvocatoriaIdCon(Integer idCon, Sort sort);

	List<Tema> findByTemIdEstadoInAndConvocatoriaIdConAndPersonaSysUsuarioUsrUsuario(List<Integer> temIdEstado,
			Integer idCon, String usrUsuario);

	@Query(nativeQuery = true, value = " SELECT 	t.id_tem as idTem,  t.fk_con as fkCon,  t.fk_per as fkPer,  t.tem_idtipo as temIdTipo,  t.tem_idestado as temIdEstado,  t.tem_nombre as temNombre,  t.tem_descripcion as temDescripcion,  		"
			+ " 	t.tem_tema as temTema,  t.tem_numest as temNumEst,  t.tem_autora as temAutorA,  t.tem_autorb as temAutorB,  t.tem_fechapublicado as temFechaPublicado,  t.tem_auspiciante as temAuspiciante,        "
			+ " 	t.tem_lectorplan as temLectorPlan,  t.tem_lectorproyecto as temLectorProyecto,  t.tem_activo as temActivo,  t.tem_fechacreado as temFechaCreado, t. tem_fechaeditado as temFechaEditado,            "
			+ " 	t.tem_porcavance as temPorcAvance,  t.tem_aprobado as temAprobado,  t.tem_alcance as temAlcance,  t.tem_objetivo as temObjetivo,  t.tem_fechaenviado as temFechaEnviado,  t.tem_nota as temNota,    "
			+ " 	t.tem_observacion as temObservacion,  t.tem_fechainicio as temFechaInicio,  t.tem_fechaentrega as temFechaEntrega, t.tem_idperiodo as temIdPeriodo,  t.tem_fecharesolucion as temFechaResolucion    "
			+ " FROM 	tema t                                                                                                                                                                                          "
			+ " 	INNER JOIN convocatoria c ON t.fk_con = c.id_con                                                                                                                                                    "
			+ " 	INNER JOIN persona p ON t.fk_per = p.id_per                                                                                                                                                         "
			+ " 	INNER JOIN sys_usuario u ON p.id_per = u.fk_per                                                                                                                                                     ")
	List<TemaProjection> findByIdExceptoActual2(@Param("idTema") Integer idTema);

//	@Query(value = "SELECT name AS name, age AS age FROM Person", nativeQuery = true)
//	List<PersonSummary> findAllProjectedNativeQuery();
}
