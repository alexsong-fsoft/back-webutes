package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.TipoOpcionDTO;
import com.utes.spring.web.app.entity.TipoOpcion;

@Service
public interface TipoOpcionService extends IParsable<TipoOpcionDTO, TipoOpcion> {

	public boolean create(TipoOpcionDTO obj);

	public boolean update(TipoOpcionDTO obj);

	public boolean delete(Integer id);

	public List<TipoOpcionDTO> obtenerListadoTipoOpcion(boolean activo);

	public TipoOpcionDTO obtenerTipoOpcion(Integer id);

}
