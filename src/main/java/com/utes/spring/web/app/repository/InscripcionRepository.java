package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

	List<Inscripcion> findByInsActivo(boolean estado);

	Inscripcion findByInsPeriodo(Integer periodo);

	@Query(nativeQuery = true, value = "SELECT last_value FROM inscripcion_id_ins_seq")
	Integer obtenerUltimoRegistroInscripcion();

	@Query(nativeQuery = true, value = "select max(ins_secuencia)+1 from inscripcion")
	Integer obtenerSecuencialInscripcion();

	@Query(nativeQuery = true, value = "select id_ins  from inscripcion where ins_activo=true order by ins_secuencia desc limit 1")
	Integer obtenerInscripcionActivaMaxSecuencial();
}
