package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysUsuario;

@Repository
public interface SysUsuarioRepository extends JpaRepository<SysUsuario, Integer> {

	SysUsuario findByUsrUsuarioAndUsrActivo(String usrUsuario, boolean usrActivo);

	SysUsuario findByUsrUsuarioAndUsrClaveAndUsrActivo(String usrUsuario, String usrClave, boolean usrActivo);

	List<SysUsuario> findByUsrUsuarioLikeAndUsrActivo(String usrUsuario, boolean usrActivo);

	SysUsuario findByPersonaIdPer(Integer idPer);

	List<SysUsuario> findBySysPerfilPrfNombre(String prfNombre);

	List<SysUsuario> findBySysPerfilPrfNombreAndPersonaIdPerNot(String prfNombre, Integer idPer);

	SysUsuario findByUsrCorreoAndUsrActivo(String usrCorreo, boolean usrActivo);

//	@Query(value = " SELECT	* 																			"
//			+ " from 	sys_usuario USU inner join sys_perfil PER ON USU.fk_prf = PER.id_prf        "
//			+ " where 	PER.prf_nombre = 'DOCENTE'                                                  "
//			+ " 	AND fk_per NOT IN (select fk_per FROM tema t WHERE t.id_tem = 217)              "
//			+ " 	AND fk_per IN (select fk_per FROM seleccion s WHERE s.fk_prd = 6)               ",
//			nativeQuery = true)
//	List<SysUsuario> obtenerListadoUsuarioPorPerfilAsignadoIdTema(@Param("perfilnombre") String perfilnombre, @Param("idtem") Integer idtem,
//			@Param("idtipoasignado") Integer idtipoasignado, @Param("idestado") Integer idestado, @Param("idperiodo") Integer idperiodo);

	@Query("SELECT usu FROM SysUsuario usu JOIN usu.sysPerfil prf JOIN usu.persona per"
			+ " WHERE prf.prfNombre =:perfil AND per.idPer NOT IN (SELECT t.persona.idPer FROM Tema t WHERE t.idTem =:tema) "
			+ " AND per.idPer IN (SELECT s.persona.idPer FROM Seleccion s WHERE s.periodo.idPrd =:periodo) ")
	List<SysUsuario> obtenerListadoUsuarioPorPerfilAsignadoIdTema(@Param("perfil") String perfilnombre,
			@Param("tema") Integer idtem, @Param("periodo") Integer idperiodo);

}
