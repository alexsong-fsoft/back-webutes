package com.utes.spring.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utes.spring.web.app.entity.SysPropiedades;

@Repository
public interface SysPropiedadesRepository extends JpaRepository<SysPropiedades, Integer> {

}
