package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.AreaDTO;
import com.utes.spring.web.app.entity.Area;

@Service
public interface AreaService extends IParsable<AreaDTO, Area> {

	public boolean create(AreaDTO obj);

	public boolean update(AreaDTO obj);

	public boolean delete(Integer id);

	public List<AreaDTO> obtenerListadoArea(boolean activo);

	public Page<AreaDTO> obtenerListadoAreaPageable(boolean activo);

	public AreaDTO obtenerArea(Integer id);

	public List<AreaDTO> obtenerListadoAreaPorTipo(Integer idtipo, boolean activo);

	public List<AreaDTO> obtenerListadoArea(String ids, boolean activo);

}
