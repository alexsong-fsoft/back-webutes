package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.Correo;

@Repository
public interface CorreoRepository extends JpaRepository<Correo, Integer> {

	List<Correo> findByIdCorreo(Integer id);

	List<Correo> findByCorreoActivo(boolean estado);
}
