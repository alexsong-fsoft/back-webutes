package com.utes.spring.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysPerfil;

@Repository
public interface SysPerfilRepository extends JpaRepository<SysPerfil, Integer> {

	SysPerfil findByPrfNombre(String prfNombre);
}
