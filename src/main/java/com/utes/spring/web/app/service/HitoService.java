package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.HitoDTO;
import com.utes.spring.web.app.entity.Hito;

@Service
public interface HitoService extends IParsable<HitoDTO, Hito> {

	public boolean create(HitoDTO obj);

	public boolean update(HitoDTO obj);

	public boolean delete(Integer id);

	public List<HitoDTO> obtenerListadoHito(boolean activo);

	public HitoDTO obtenerHito(Integer id);

	public List<HitoDTO> obtenerHitoxTema(Integer idtema);

	public HitoDTO obtenerEntidadaHitoxTema(Integer idtema);

	public Integer obtenerSecuencialHito(Integer idtema);

}
