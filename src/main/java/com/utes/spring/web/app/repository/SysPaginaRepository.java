package com.utes.spring.web.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysPagina;

@Repository
public interface SysPaginaRepository extends JpaRepository<SysPagina, Integer> {

	List<SysPagina> findByPagTipo(Character pagTipo, Sort sort);
}
