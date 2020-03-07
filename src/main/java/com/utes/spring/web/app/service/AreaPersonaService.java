package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.AreaPersonaDTO;
import com.utes.spring.web.app.entity.AreaPersona;

@Service
public interface AreaPersonaService extends IParsable<AreaPersonaDTO, AreaPersona> {

	public boolean create(AreaPersonaDTO obj);

	public boolean update(AreaPersonaDTO obj);

	public boolean delete(Integer id);

	public List<AreaPersonaDTO> obtenerListadoAreaPersona(boolean activo);

	public AreaPersonaDTO obtenerAreaPersona(Integer id);

	public List<AreaPersonaDTO> obtenerListadoAreapersonaxPersona(Integer idper, boolean activo);

	public AreaPersonaDTO obtenerListadoAreapersonaxPersona(Integer idper, Integer idare, boolean activo);

	public List<AreaPersonaDTO> obtenerListadoAreapersonaxPersona(String ids, Integer idper, boolean activo);
}
