package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.InscripcionDTO;
import com.utes.spring.web.app.entity.Inscripcion;

@Service
public interface InscripcionService extends IParsable<InscripcionDTO, Inscripcion> {

	public boolean create(InscripcionDTO obj);

	public boolean update(InscripcionDTO obj);

	public boolean delete(Integer id);

	public List<InscripcionDTO> obtenerListadoInscripcionPorEstado(boolean estado);

	public List<InscripcionDTO> obtenerListadoInscripcion();

	public Integer obtenerUltimoRegistroInscripcion();

	public Integer obtenerSecuencialInscripcion();

	public InscripcionDTO obtenerInscripcionPorId(Integer id);

	public Integer obtenerInscripcionActivaMaxSecuencial();

	public InscripcionDTO obtenerInscripcionPorPeriodo(Integer idperiodo);

}
