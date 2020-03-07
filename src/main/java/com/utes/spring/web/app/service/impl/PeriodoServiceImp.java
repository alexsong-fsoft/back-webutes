package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.PeriodoDTO;
import com.utes.spring.web.app.entity.Periodo;
import com.utes.spring.web.app.entity.Seleccion;
import com.utes.spring.web.app.repository.PeriodoRepository;
import com.utes.spring.web.app.service.PeriodoService;
import com.utes.spring.web.app.service.SeleccionService;

@Service("PeriodoService")
public class PeriodoServiceImp implements PeriodoService {

	@Autowired
	private PeriodoRepository periodoRepository;
	@Autowired
	private SeleccionService seleccionService;

	@Override
	@Transactional
	public boolean create(PeriodoDTO obj) {
		boolean success = false;
		try {
			Periodo periodoBD = new Periodo();
			this.convertirDtoToEntity(obj, periodoBD);
			this.periodoRepository.save(periodoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(PeriodoDTO obj) {
		boolean success = false;
		try {
			Periodo periodoBD = this.periodoRepository.findById(obj.getIdPrd()).orElse(null);
			if (periodoBD != null) {
				this.convertirDtoToEntity(obj, periodoBD);
				this.periodoRepository.save(periodoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean delete(Integer id) {
		boolean success = false;
		try {
			Periodo periodoBD = this.periodoRepository.findById(id).orElse(null);
			if (periodoBD != null) {
				this.periodoRepository.delete(periodoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PeriodoDTO> obtenerListadoPeriodo(boolean estado) {
		final List<Periodo> listPeriodosBD = this.periodoRepository.findByPrdActivo(estado);
		final List<PeriodoDTO> resultado = new ArrayList<PeriodoDTO>();
		if (listPeriodosBD != null && !listPeriodosBD.isEmpty()) {
			for (final Periodo periodo : listPeriodosBD) {
				resultado.add(this.convertirEntityToDto(periodo, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PeriodoDTO> obtenerListadoPeriodo() {
		final List<Periodo> listPeriodosBD = this.periodoRepository.findAll();
		final List<PeriodoDTO> resultado = new ArrayList<PeriodoDTO>();
		if (listPeriodosBD != null && !listPeriodosBD.isEmpty()) {
			for (final Periodo periodo : listPeriodosBD) {
				resultado.add(this.convertirEntityToDto(periodo, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PeriodoDTO> obtenerListadoPeriodobyNumero(Integer numero) {
		final List<Periodo> listPeriodosBD = this.periodoRepository.findByPrdNumero(numero);
		final List<PeriodoDTO> resultado = new ArrayList<PeriodoDTO>();
		if (listPeriodosBD != null && !listPeriodosBD.isEmpty()) {
			for (final Periodo periodo : listPeriodosBD) {
				resultado.add(this.convertirEntityToDto(periodo, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public PeriodoDTO obtenerPeriodoPorId(Integer idperiodo) {
		Periodo periodoBD = this.periodoRepository.findById(idperiodo).orElse(null);
		if (periodoBD != null) {
			return this.convertirEntityToDto(periodoBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerUltimoRegistroPeriodo() {
		return this.periodoRepository.obtenerUltimoRegistroPeriodo();
	}

	@Override
	@Transactional(readOnly = true)
	public PeriodoDTO obtenerPeriodoPorIdActivo(Integer idperiodo, boolean activado) {
		Periodo periodoBD = this.periodoRepository.findByIdPrdAndPrdActivo(idperiodo, activado);
		if (periodoBD != null) {
			return this.convertirEntityToDto(periodoBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(PeriodoDTO objectDTO, Periodo objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPrd", "selecciones");
	}

	@Override
	public PeriodoDTO convertirEntityToDto(Periodo objectEntity, boolean loadOneR, boolean loadAllList) {
		PeriodoDTO objectDTO = new PeriodoDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "selecciones");
		if (loadAllList) {
			if (objectEntity.getSelecciones() != null && !objectEntity.getSelecciones().isEmpty()) {
				for (Seleccion seleccion : objectEntity.getSelecciones()) {
					objectDTO.getSelecciones().add(seleccionService.convertirEntityToDto(seleccion, false, false));
				}
			}
		}
		return objectDTO;
	}

}
