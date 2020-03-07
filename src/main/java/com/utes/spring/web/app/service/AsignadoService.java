package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.AsignadoDTO;
import com.utes.spring.web.app.entity.Asignado;

@Service
public interface AsignadoService extends IParsable<AsignadoDTO, Asignado> {

	public boolean create(AsignadoDTO obj);

	public boolean update(AsignadoDTO obj);

	public boolean delete(Integer idasig);

	public List<AsignadoDTO> obtenerListadoAsignado(boolean activo);

	public List<AsignadoDTO> obtenerAsignadoDTOxTemaPersona(Integer idtema, Integer idpersona);

	public List<AsignadoDTO> obtenerAsignadoxTemaCedula(String ced);

	public AsignadoDTO obtenerEntidadAsignadoxTemaCedula(String ced);

	public List<AsignadoDTO> obtenerAsignadoxTema(Integer idtema);

	public List<AsignadoDTO> obtenerAsignadoxTema(Integer idtema, Integer idtipo);

	public AsignadoDTO obtenerAsignadoxTemaPersonaVerifica(Integer idtema, Integer idpersona);

	public List<AsignadoDTO> obtenerAsignadoxIdsTema(String idsTema, Integer idtipo);

	public List<AsignadoDTO> obtenerAsignadoxEstado(Integer idestado);

	public AsignadoDTO obtenerEntidadAsignadoxIdPersona(Integer idpersona, String idtipoasignacion, Integer idtema);

	public AsignadoDTO obtenerEntidadAsignadoxIdPersona(Integer idpersona);

	public AsignadoDTO obtenerEntidadAsignadoxIdPersona(Integer idpersona, Integer idtipoasignacion);

	public List<AsignadoDTO> obtenerListadoAsignadoxIdPersona(Integer idpersona, Integer idtipoasignacion);

	public Integer obtenerCount(Integer idpersona, Integer idtipo, Integer estadoaccion);

	public AsignadoDTO obtenerAsignadoxTemaPersonaVerificaAsignadoRevisor(Integer idtema, Integer idpersona,
			Integer idestadorev);

	public AsignadoDTO obtenerAsignadoxTemaPersonaVerificaAsignadoTipo(Integer idtema, Integer idpersona,
			Integer idtipo, Integer estadorevision);

	public Integer obtenerIdAsignadoxTemaUltimoEstado(Integer idtema, Integer idpersona, Integer idtipo);

	public AsignadoDTO obtenerEntidadAsignadoxId(Integer idasignado);

	public List<AsignadoDTO> obtenerAsignadoxIdsTipos(String idstema, String idtipoasig);

	// public AsignadoDTO obtenerAsignadoxTemaPersonaUpdateEstado(Integer idtema,
	// Integer idtipo, Integer estadorevision);

	// public AsignadoDTO obtenerAsignadoxIdtema(Integer idtema, Integer idtipo);

}
