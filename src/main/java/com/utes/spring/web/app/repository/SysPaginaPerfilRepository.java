package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysPaginaPerfil;

@Repository
public interface SysPaginaPerfilRepository extends JpaRepository<SysPaginaPerfil, Integer> {

	List<SysPaginaPerfil> findByPgPrfActivo(Boolean estado);

	List<SysPaginaPerfil> findBySysPerfilPrfNombre(String prfNombre);

	List<SysPaginaPerfil> findBySysPerfilIdPrf(Integer idPrf);

	List<SysPaginaPerfil> findBySysPerfilIdPrfAndSysPaginaPagTipo(Integer idPrf, String pagTipo);
}
