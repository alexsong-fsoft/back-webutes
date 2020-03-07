package com.utes.spring.web.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.InscripcionDTO;
import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.dto.PresolicitudDTO;
import com.utes.spring.web.app.entity.Presolicitud;

@Service
public interface PresolicitudService extends IParsable<PresolicitudDTO, Presolicitud> {

	public boolean create(PresolicitudDTO obj);

	public boolean update(PresolicitudDTO obj);

	public boolean delete(Integer id);

	public List<PresolicitudDTO> obtenerListadoPresolicitud();

	public Page<PresolicitudDTO> obtenerListadoPresolicitudPageable();

	public List<PresolicitudDTO> obtenerListadoPresolicitudPorCedula(PersonaDTO objpersona);

	public PresolicitudDTO obtenerPresolicitudPorCedula(PersonaDTO objpersona, Integer idinscipcion);

	public PresolicitudDTO obtenerPresolicitudPorId(Integer id);

	public List<PresolicitudDTO> obtenerPresolicitudPorEstado(Integer idestado);

	public List<PresolicitudDTO> obtenerListadoPresolicitudPorEstado2(Integer idestado);

	public List<PresolicitudDTO> obtenerListadoPresolicitudPorIdsPersona(String ids);

	public List<PresolicitudDTO> obtenerListadoPresolicitudPorCedulaId(PersonaDTO objpersona,
			InscripcionDTO objinscripcion);

	public PresolicitudDTO obtenerPresolicitudPorPersonaId(Integer idper, Integer idinscripcion);

	public PresolicitudDTO obtenerListadoPresolicitudPorId(Integer idpresolicitud);

	public List<PresolicitudDTO> obtenerListadoPresolicitudConsulta(Integer idins, Integer idopc, Integer idestado,
			Date fini, Date ffin);

	public PresolicitudDTO obtenerPresolicitudPorPersonaIdInscripcion(Integer idper, Integer idinscrip);

	public Integer obtenerIdPresolicidutxUltimoRegistrado(Integer idpersona);

	public List<PresolicitudDTO> obtenerListadoPresolicitudbyOpcionEstado(Integer idopcion, String idestados);

	public List<PresolicitudDTO> obtenerListadoPresolicitudPorEstados(String opciones, String idestados);

}
