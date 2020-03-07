package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysConfiguracion;

@Repository
public interface SysConfiguracionRepository extends JpaRepository<SysConfiguracion, Integer> {

	List<SysConfiguracion> findByConfActivo(Boolean estado);

	SysConfiguracion findByConfCampo(String confCampo);

	List<SysConfiguracion> findByConfTipo(String confTipo, Sort sort);

}
