package com.utes.spring.web.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.EvolucionDTO;
import com.utes.spring.web.app.entity.Evolucion;

@Service
public interface EvolucionService extends IParsable<EvolucionDTO, Evolucion> {

	public boolean create(EvolucionDTO obj);

	public boolean update(EvolucionDTO obj);

	public boolean delete(Integer id);

	public List<EvolucionDTO> obtenerListadoEvolucion(boolean activo);

	public List<EvolucionDTO> obtenerEvolucionxTema(Integer idtema);

	public EvolucionDTO obtenerEntidadaEvolucionxTema(Integer idtema);

	public Integer obtenerSecuencialEvolucion(Integer idtema);

	public Integer obtenerUltimoRegistroporTema(Integer idtema, Integer idestadoevolucion);

	public EvolucionDTO obtenerEntidadaEvolucionPorId(Integer idevolucion);

	public List<EvolucionDTO> obtenerEntidadaEvolucionPorFecha(Date fechacita, Integer idtema, String horacita);

}
