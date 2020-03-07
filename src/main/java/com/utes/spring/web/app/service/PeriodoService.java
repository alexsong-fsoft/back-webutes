package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.PeriodoDTO;
import com.utes.spring.web.app.entity.Periodo;

@Service
public interface PeriodoService extends IParsable<PeriodoDTO, Periodo> {

	public boolean create(PeriodoDTO obj);

	public boolean update(PeriodoDTO obj);

	public boolean delete(Integer id);

	public List<PeriodoDTO> obtenerListadoPeriodo(boolean estado);

	public List<PeriodoDTO> obtenerListadoPeriodo();

	public List<PeriodoDTO> obtenerListadoPeriodobyNumero(Integer numero);

	public PeriodoDTO obtenerPeriodoPorId(Integer idperiodo);

	public Integer obtenerUltimoRegistroPeriodo();

	public PeriodoDTO obtenerPeriodoPorIdActivo(Integer idperiodo, boolean activado);

}
