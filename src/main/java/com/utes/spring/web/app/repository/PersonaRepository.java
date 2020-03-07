package com.utes.spring.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utes.spring.web.app.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	Persona findByPerCedula(String perCedula);
}
