package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SeleccionDTO;
import com.utes.spring.web.app.entity.Seleccion;

@Service
public interface SeleccionService extends IParsable<SeleccionDTO, Seleccion> {

	public boolean create(SeleccionDTO obj);

	public boolean update(SeleccionDTO obj);

	public boolean delete(Integer id);

	public List<SeleccionDTO> obtenerListadoSeleccion(boolean activo);

	public SeleccionDTO obtenerSeleccion(Integer id);

	public List<SeleccionDTO> obtenerListadoPeriodo(Integer fkperiodo);

	public SeleccionDTO obtenerSeleccionPorPeriodoPersona(Integer periodonum, Integer fkpersona);

	public SeleccionDTO obtenerSeleccionPorIdPeriodoPersona(Integer idperiodo, Integer fkpersona);

}
