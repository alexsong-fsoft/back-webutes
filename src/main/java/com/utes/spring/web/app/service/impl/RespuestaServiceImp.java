package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.RespuestaDTO;
import com.utes.spring.web.app.entity.Cuestionario;
import com.utes.spring.web.app.entity.Presolicitud;
import com.utes.spring.web.app.entity.Respuesta;
import com.utes.spring.web.app.repository.CuestionarioRepository;
import com.utes.spring.web.app.repository.PresolicitudRepository;
import com.utes.spring.web.app.repository.RespuestaRepository;
import com.utes.spring.web.app.service.CuestionarioService;
import com.utes.spring.web.app.service.PresolicitudService;
import com.utes.spring.web.app.service.RespuestaService;

@Service("RespuestaService")
public class RespuestaServiceImp implements RespuestaService {

	@Autowired
	private RespuestaRepository respuestaRepository;
	@Autowired
	private PresolicitudRepository presolicitudRepository;
	@Autowired
	private CuestionarioRepository cuestionarioRepository;
	@Autowired
	private PresolicitudService presolicitudService;
	@Autowired
	private CuestionarioService cuestionarioService;

	@Override
	@Transactional
	public boolean create(RespuestaDTO obj) {
		boolean success = false;
		try {
			Respuesta respuestaBD = new Respuesta();
			this.convertirDtoToEntity(obj, respuestaBD);
			this.respuestaRepository.save(respuestaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(RespuestaDTO obj) {
		boolean success = false;
		try {
			Respuesta respuestaBD = this.respuestaRepository.findById(obj.getIdRes()).orElse(null);
			if (respuestaBD != null) {
				this.convertirDtoToEntity(obj, respuestaBD);
				this.respuestaRepository.save(respuestaBD);
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
			Respuesta respuestaBD = this.respuestaRepository.findById(id).orElse(null);
			if (respuestaBD != null) {
				this.respuestaRepository.delete(respuestaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RespuestaDTO> obtenerListadoRespuesta() {
		final List<Respuesta> listRespuestasBD = this.respuestaRepository.findAll();
		final List<RespuestaDTO> resultado = new ArrayList<RespuestaDTO>();
		if (listRespuestasBD != null && !listRespuestasBD.isEmpty()) {
			for (final Respuesta respuesta : listRespuestasBD) {
				resultado.add(this.convertirEntityToDto(respuesta, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public RespuestaDTO obtenerRespuesta(Integer id) {
		Respuesta respuestaBD = this.respuestaRepository.findById(id).orElse(null);
		if (respuestaBD != null) {
			return this.convertirEntityToDto(respuestaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<RespuestaDTO> obtenerListadoRespuestaPorIdPresolicitud(Integer idpresolicitud) {
		final List<Respuesta> listRespuestasBD = this.respuestaRepository.findByPresolicitudIdPsl(idpresolicitud);
		final List<RespuestaDTO> resultado = new ArrayList<RespuestaDTO>();
		if (listRespuestasBD != null && !listRespuestasBD.isEmpty()) {
			for (final Respuesta respuesta : listRespuestasBD) {
				resultado.add(this.convertirEntityToDto(respuesta, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public RespuestaDTO obtenerRespuestaPorIds(Integer idpresolicitud, Integer idcuestionario) {
		final Respuesta respuestaBD = this.respuestaRepository
				.findByPresolicitudIdPslAndCuestionarioIdCue(idpresolicitud, idcuestionario);
		RespuestaDTO resultado = new RespuestaDTO();
		if (respuestaBD != null) {
			resultado = this.convertirEntityToDto(respuestaBD, true, true);
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(RespuestaDTO objectDTO, Respuesta objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idRes", "presolicitud", "cuestionario", "idPresolicitud",
				"idCuestionario");
		if (objectDTO.getIdPresolicitud() != null) {
			Presolicitud presolicitud = this.presolicitudRepository.findById(objectDTO.getIdPresolicitud())
					.orElse(null);
			objectEntity.setPresolicitud(presolicitud);
		}
		if (objectDTO.getIdCuestionario() != null) {
			Cuestionario cuestionario = this.cuestionarioRepository.findById(objectDTO.getIdCuestionario())
					.orElse(null);
			objectEntity.setCuestionario(cuestionario);
		}
	}

	@Override
	public RespuestaDTO convertirEntityToDto(Respuesta objectEntity, boolean loadOneR, boolean loadAllList) {
		RespuestaDTO objectDTO = new RespuestaDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "presolicitud", "cuestionario");
		if (loadOneR) {
			if (objectEntity.getPresolicitud() != null) {
				objectDTO.setPresolicitud(
						this.presolicitudService.convertirEntityToDto(objectEntity.getPresolicitud(), false, false));
				objectDTO.setIdPresolicitud(objectEntity.getPresolicitud().getIdPsl());
			}
			if (objectEntity.getCuestionario() != null) {
				objectDTO.setCuestionario(
						this.cuestionarioService.convertirEntityToDto(objectEntity.getCuestionario(), false, false));
				objectDTO.setIdCuestionario(objectEntity.getCuestionario().getIdCue());
			}
		}
		return objectDTO;
	}

}
