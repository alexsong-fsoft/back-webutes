package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SysConfiguracionDTO;
import com.utes.spring.web.app.entity.SysConfiguracion;

@Service
public interface SysConfiguracionService extends IParsable<SysConfiguracionDTO, SysConfiguracion> {

	public boolean create(SysConfiguracionDTO obj);

	public boolean update(SysConfiguracionDTO obj);

	public boolean delete(Integer id);

	public List<SysConfiguracionDTO> obtenerListadoSysConfiguracion(boolean activo);

	public SysConfiguracionDTO obtenerConfiguracionbyPk(Integer id);

	public SysConfiguracionDTO obtenerConfiguracionbyCampo(String campo);

	public List<SysConfiguracionDTO> obtenerConfiguracionbyTipo(String tipo);

	public boolean activaProcesoByCampo(String campo);

}
