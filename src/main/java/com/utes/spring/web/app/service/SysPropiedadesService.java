package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.SysPropiedadesDTO;
import com.utes.spring.web.app.entity.SysPropiedades;

@Service
public interface SysPropiedadesService extends IParsable<SysPropiedadesDTO, SysPropiedades> {

	public boolean create(SysPropiedadesDTO obj);

	public boolean update(SysPropiedadesDTO obj);

	public boolean delete(Integer id);

	public List<SysPropiedadesDTO> obtenerPropiedades();

	public SysPropiedadesDTO obtenerPropiedadesbyPk(Integer id);

	public SysPropiedadesDTO obtenerPropiedad();

}
