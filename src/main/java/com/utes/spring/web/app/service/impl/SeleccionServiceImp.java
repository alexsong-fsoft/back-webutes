package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SeleccionDTO;
import com.utes.spring.web.app.entity.Periodo;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Seleccion;
import com.utes.spring.web.app.repository.PeriodoRepository;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.SeleccionRepository;
import com.utes.spring.web.app.service.PeriodoService;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.SeleccionService;

@Service("SeleccionService")
public class SeleccionServiceImp implements SeleccionService {

	@Autowired
	private SeleccionRepository seleccionRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private PeriodoRepository periodoRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private PeriodoService periodoService;

	@Override
	@Transactional
	public boolean create(SeleccionDTO obj) {
		boolean success = false;
		try {
			Seleccion seleccionBD = new Seleccion();
			this.convertirDtoToEntity(obj, seleccionBD);
			this.seleccionRepository.save(seleccionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SeleccionDTO obj) {
		boolean success = false;
		try {
			Seleccion seleccionBD = this.seleccionRepository.findById(obj.getIdSel()).orElse(null);
			if (seleccionBD != null) {
				this.convertirDtoToEntity(obj, seleccionBD);
				this.seleccionRepository.save(seleccionBD);
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
			Seleccion seleccionBD = this.seleccionRepository.findById(id).orElse(null);
			if (seleccionBD != null) {
				this.seleccionRepository.delete(seleccionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SeleccionDTO> obtenerListadoSeleccion(boolean activo) {
		final List<Seleccion> listSeleccionsBD = this.seleccionRepository.findAll();
		final List<SeleccionDTO> resultado = new ArrayList<SeleccionDTO>();
		if (listSeleccionsBD != null && !listSeleccionsBD.isEmpty()) {
			for (final Seleccion seleccion : listSeleccionsBD) {
				resultado.add(this.convertirEntityToDto(seleccion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SeleccionDTO obtenerSeleccion(Integer id) {
		Seleccion seleccionBD = this.seleccionRepository.findById(id).orElse(null);
		if (seleccionBD != null) {
			return this.convertirEntityToDto(seleccionBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SeleccionDTO> obtenerListadoPeriodo(Integer fkperiodo) {
		final List<Seleccion> listSeleccionsBD = this.seleccionRepository.findByPeriodoIdPrd(fkperiodo);
		final List<SeleccionDTO> resultado = new ArrayList<SeleccionDTO>();
		if (listSeleccionsBD != null && !listSeleccionsBD.isEmpty()) {
			for (final Seleccion seleccion : listSeleccionsBD) {
				resultado.add(this.convertirEntityToDto(seleccion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SeleccionDTO obtenerSeleccionPorPeriodoPersona(Integer periodonum, Integer fkpersona) {
		final List<Seleccion> listSeleccionsBD = this.seleccionRepository
				.findByPersonaIdPerAndPeriodoPrdNumero(fkpersona, periodonum);
		if (listSeleccionsBD != null && !listSeleccionsBD.isEmpty()) {
			return this.convertirEntityToDto(listSeleccionsBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SeleccionDTO obtenerSeleccionPorIdPeriodoPersona(Integer idperiodo, Integer fkpersona) {
		final List<Seleccion> listSeleccionsBD = this.seleccionRepository.findByPersonaIdPerAndPeriodoIdPrd(fkpersona,
				idperiodo);
		if (listSeleccionsBD != null && !listSeleccionsBD.isEmpty()) {
			return this.convertirEntityToDto(listSeleccionsBD.get(0), true, false);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(SeleccionDTO objectDTO, Seleccion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idSel", "persona", "periodo", "idPersona", "idPeriodo");
		if (objectDTO.getIdPeriodo() != null) {
			Periodo periodo = this.periodoRepository.findById(objectDTO.getIdPeriodo()).orElse(null);
			objectEntity.setPeriodo(periodo);
		}
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
	}

	@Override
	public SeleccionDTO convertirEntityToDto(Seleccion objectEntity, boolean loadOneR, boolean loadAllList) {
		SeleccionDTO objectDTO = new SeleccionDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "persona", "periodo");
		if (loadOneR) {
			if (objectEntity.getPeriodo() != null) {
				objectDTO.setPeriodo(this.periodoService.convertirEntityToDto(objectEntity.getPeriodo(), false, false));
				objectDTO.setIdPeriodo(objectEntity.getPeriodo().getIdPrd());
			}
			if (objectEntity.getPersona() != null) {
				objectDTO.setPersona(this.personaService.convertirEntityToDto(objectEntity.getPersona(), false, false));
				objectDTO.setIdPersona(objectEntity.getPersona().getIdPer());
			}
		}
		return objectDTO;
	}
}
