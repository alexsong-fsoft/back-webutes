package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.TipoResolucionDTO;
import com.utes.spring.web.app.entity.TipoResolucion;

@Service
public interface TipoResolucionService extends IParsable<TipoResolucionDTO, TipoResolucion> {

	public boolean create(TipoResolucionDTO obj);

	public boolean update(TipoResolucionDTO obj);

	public boolean delete(Integer id);

	public List<TipoResolucionDTO> obtenerListadoTipoResolucion(boolean activo);

	public TipoResolucionDTO obtenerTipoResolucion(Integer id);

}
