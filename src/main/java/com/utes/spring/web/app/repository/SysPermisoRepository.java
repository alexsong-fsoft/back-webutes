package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysPermiso;

@Repository
public interface SysPermisoRepository extends JpaRepository<SysPermiso, Integer> {

	List<SysPermiso> findByPermActivo(Boolean estado);

	List<SysPermiso> findBySysPerfilPrfNombre(String prfNombre);

	List<SysPermiso> findBySysPerfilIdPrf(Integer idPrf);
}
