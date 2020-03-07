package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.entity.Persona;

@Service
public interface PersonaService extends IParsable<PersonaDTO, Persona> {

	public boolean create(PersonaDTO obj);

	public boolean update(PersonaDTO obj);

	public boolean delete(Integer id);

	public List<PersonaDTO> obtenerListadoPersona();

	public PersonaDTO obtenerPersonaPorId(Integer id);

	public PersonaDTO obtenerPersonaPorCedula(String cedula);

}
