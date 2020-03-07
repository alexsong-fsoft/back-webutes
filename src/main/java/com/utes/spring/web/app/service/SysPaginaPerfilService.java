package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SysPaginaPerfilDTO;
import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.entity.SysPaginaPerfil;

@Service
public interface SysPaginaPerfilService extends IParsable<SysPaginaPerfilDTO, SysPaginaPerfil> {

	public boolean create(SysPaginaPerfilDTO obj);

	public boolean update(SysPaginaPerfilDTO obj);

	public boolean delete(Integer id);

	public List<SysPaginaPerfilDTO> obtenerListadoSysPaginaPerfil(boolean activo);

	public SysPaginaPerfilDTO obtenerSysPaginaPerfil(Integer id);

	public List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorNombrePerfil(String nombreperfil);

	public List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorPerfil(SysPerfilDTO objperfil);

	public SysPaginaPerfilDTO obtenerPaginaPerfilPorPerfil(SysPerfilDTO objperfil);

	public List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorPerfil(SysPerfilDTO objperfil, String tipo);

}
