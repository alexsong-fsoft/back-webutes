package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SysPaginaDTO;
import com.utes.spring.web.app.entity.SysPagina;

@Service
public interface SysPaginaService extends IParsable<SysPaginaDTO, SysPagina> {

	public boolean create(SysPaginaDTO obj);

	public boolean update(SysPaginaDTO obj);

	public boolean delete(Integer id);

	public List<SysPaginaDTO> obtenerListadoPagina();

	public SysPaginaDTO obtenerListadoPaginaPorId(Integer idpagina);

	public List<SysPaginaDTO> obtenerListadoPaginaPadres();

	// public List<SysPaginaDTO> obtenerListadoPaginaporId(String idpagina);

}
