package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Convocatoria;

@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Integer> {

//	@Query("SELECT Max(c.conSecuencia)+1 From Convcatoria c")
//	Integer obtenerConvocatoriaSecuencia();

	@Query(nativeQuery = true, value = "SELECT last_value FROM convocatoria_id_con_seq")
	Integer obtenerUltimoRegistroConvocatoria();

	@Query(nativeQuery = true, value = "select max(con_secuencia)+1 from convocatoria")
	Integer obtenerSecuencialConvocatoria();

	List<Convocatoria> findByConActivo(boolean activo);

	Convocatoria findByIdConAndConActivo(Integer id, boolean activo);

	Convocatoria findByConPeriodo(Integer conPeriodo);
}
