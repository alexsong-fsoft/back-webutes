package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.entity.SysPerfil;

@Service
public interface SysPerfilService extends IParsable<SysPerfilDTO, SysPerfil> {

	public boolean create(SysPerfilDTO obj);

	public boolean update(SysPerfilDTO obj);

	public boolean delete(Integer id);

	public List<SysPerfilDTO> obtenerListadoPerfil();

	public List<SysPerfilDTO> obtenerListadoPerfilPorNombreUsuario(String nombreusuario);

	public SysPerfilDTO obtenerPerfilPorNombreUsuario(String nombreusuario);

	public SysPerfilDTO obtenerPerfilPorId(Integer id);

	public List<SysPerfilDTO> obtenerListadoPerfilPorNombreUsuario2(String nombreusuario);

	public SysPerfilDTO obtenerPerfilPorNombre(String nombreperfil);

}
