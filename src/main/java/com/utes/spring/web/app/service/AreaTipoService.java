package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.AreaTipoDTO;
import com.utes.spring.web.app.entity.AreaTipo;

@Service
public interface AreaTipoService extends IParsable<AreaTipoDTO, AreaTipo> {

	public boolean create(AreaTipoDTO obj);

	public boolean update(AreaTipoDTO obj);

	public boolean delete(Integer id);

	public List<AreaTipoDTO> obtenerListadoAreaTipo(boolean activo);

	public AreaTipoDTO obtenerAreaTipo(Integer id);

	public List<AreaTipoDTO> obtenerListadoAreaTipo(Integer idtipo, boolean activo);
}
