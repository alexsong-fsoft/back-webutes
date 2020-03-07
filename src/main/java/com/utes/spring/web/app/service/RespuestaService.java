package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.RespuestaDTO;
import com.utes.spring.web.app.entity.Respuesta;

@Service
public interface RespuestaService extends IParsable<RespuestaDTO, Respuesta> {

	public boolean create(RespuestaDTO obj);

	public boolean update(RespuestaDTO obj);

	public boolean delete(Integer id);

	public List<RespuestaDTO> obtenerListadoRespuesta();

	public RespuestaDTO obtenerRespuesta(Integer id);

	public List<RespuestaDTO> obtenerListadoRespuestaPorIdPresolicitud(Integer idpresolicitud);

	public RespuestaDTO obtenerRespuestaPorIds(Integer idpresolicitud, Integer idcuestionario);

}
