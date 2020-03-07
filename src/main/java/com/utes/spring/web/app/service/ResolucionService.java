package com.utes.spring.web.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.ResolucionDTO;
import com.utes.spring.web.app.entity.Resolucion;

@Service
public interface ResolucionService extends IParsable<ResolucionDTO, Resolucion> {

	public boolean create(ResolucionDTO obj);

	public boolean update(ResolucionDTO obj);

	public boolean delete(Integer id);

	public List<ResolucionDTO> obtenerListadoResolucion(boolean activo);

	public List<ResolucionDTO> obtenerResolucionxTema(Integer idtema);

	public ResolucionDTO obtenerResolucionxTemaIdTipoRes(Integer idtema, Integer idtipores);

	public ResolucionDTO obtenerResolucionxId(Integer idresolucion);

	public List<ResolucionDTO> obtenerResolucionxTemaEstadoresolucion(Integer idtema, Integer idtiporesolucion);

	public List<ResolucionDTO> obtenerResolucionxPersona(Integer idpersona);

	public List<ResolucionDTO> obtenerResolucionxTema(Integer idtema, Date fini, Date ffin);

}
