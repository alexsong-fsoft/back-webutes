package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.dto.SysPermisoDTO;
import com.utes.spring.web.app.entity.SysPermiso;

@Service
public interface SysPermisoService extends IParsable<SysPermisoDTO, SysPermiso> {

	public boolean create(SysPermisoDTO obj);

	public boolean update(SysPermisoDTO obj);

	public boolean delete(Integer id);

	public List<SysPermisoDTO> obtenerListadoSysPermiso(boolean activo);

	public SysPermisoDTO obtenerSysPermiso(Integer id);

	public List<SysPermisoDTO> obtenerListadoPermisoPorNombrePerfil(String nombreperfil);

	public List<SysPermisoDTO> obtenerListadoPermisoPorPerfil(SysPerfilDTO objperfil);

	public SysPermisoDTO obtenerPermisoPorPerfil(SysPerfilDTO objperfil);

}
