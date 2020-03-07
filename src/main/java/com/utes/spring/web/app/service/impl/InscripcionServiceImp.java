package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.InscripcionDTO;
import com.utes.spring.web.app.entity.Inscripcion;
import com.utes.spring.web.app.entity.Presolicitud;
import com.utes.spring.web.app.repository.InscripcionRepository;
import com.utes.spring.web.app.service.InscripcionService;
import com.utes.spring.web.app.service.PresolicitudService;

@Service("InscripcionService")
public class InscripcionServiceImp implements InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepository;
	@Autowired
	private PresolicitudService presolicitudService;

	@Override
	@Transactional
	public boolean create(InscripcionDTO obj) {
		boolean success = false;
		try {
			Inscripcion inscripcionBD = new Inscripcion();
			this.convertirDtoToEntity(obj, inscripcionBD);
			this.inscripcionRepository.save(inscripcionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(InscripcionDTO obj) {
		boolean success = false;
		try {
			Inscripcion inscripcionBD = this.inscripcionRepository.findById(obj.getIdIns()).orElse(null);
			if (inscripcionBD != null) {
				this.convertirDtoToEntity(obj, inscripcionBD);
				this.inscripcionRepository.save(inscripcionBD);
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
			Inscripcion inscripcionBD = this.inscripcionRepository.findById(id).orElse(null);
			if (inscripcionBD != null) {
				this.inscripcionRepository.delete(inscripcionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<InscripcionDTO> obtenerListadoInscripcionPorEstado(boolean estado) {
		final List<Inscripcion> listInscripcionsBD = this.inscripcionRepository.findByInsActivo(estado);
		final List<InscripcionDTO> resultado = new ArrayList<InscripcionDTO>();
		if (listInscripcionsBD != null && !listInscripcionsBD.isEmpty()) {
			for (final Inscripcion inscripcion : listInscripcionsBD) {
				resultado.add(this.convertirEntityToDto(inscripcion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<InscripcionDTO> obtenerListadoInscripcion() {
		final List<Inscripcion> listInscripcionsBD = this.inscripcionRepository.findAll();
		final List<InscripcionDTO> resultado = new ArrayList<InscripcionDTO>();
		if (listInscripcionsBD != null && !listInscripcionsBD.isEmpty()) {
			for (final Inscripcion inscripcion : listInscripcionsBD) {
				resultado.add(this.convertirEntityToDto(inscripcion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerUltimoRegistroInscripcion() {
		return this.inscripcionRepository.obtenerUltimoRegistroInscripcion();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerSecuencialInscripcion() {
		return this.inscripcionRepository.obtenerSecuencialInscripcion();
	}

	@Override
	@Transactional(readOnly = true)
	public InscripcionDTO obtenerInscripcionPorId(Integer id) {
		Inscripcion inscripcionBD = this.inscripcionRepository.findById(id).orElse(null);
		if (inscripcionBD != null) {
			return this.convertirEntityToDto(inscripcionBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerInscripcionActivaMaxSecuencial() {
		return this.inscripcionRepository.obtenerInscripcionActivaMaxSecuencial();
	}

	@Override
	@Transactional(readOnly = true)
	public InscripcionDTO obtenerInscripcionPorPeriodo(Integer idperiodo) {
		Inscripcion inscripcionBD = this.inscripcionRepository.findByInsPeriodo(idperiodo);
		if (inscripcionBD != null) {
			return this.convertirEntityToDto(inscripcionBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(InscripcionDTO objectDTO, Inscripcion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idIns", "file", "presolicitudes");
	}

	@Override
	public InscripcionDTO convertirEntityToDto(Inscripcion objectEntity, boolean loadOneR, boolean loadAllList) {
		InscripcionDTO objectDTO = new InscripcionDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "file", "presolicitudes");
		if (loadAllList) {
			if (objectEntity.getPresolicitudes() != null && !objectEntity.getPresolicitudes().isEmpty()) {
				for (Presolicitud presolicitud : objectEntity.getPresolicitudes()) {
					objectDTO.getPresolicitudes()
							.add(presolicitudService.convertirEntityToDto(presolicitud, false, false));
				}
			}
		}
		return objectDTO;
	}

}
