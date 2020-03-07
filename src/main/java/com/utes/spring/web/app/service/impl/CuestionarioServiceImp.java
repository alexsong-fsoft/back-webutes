package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.CuestionarioDTO;
import com.utes.spring.web.app.entity.Cuestionario;
import com.utes.spring.web.app.entity.Respuesta;
import com.utes.spring.web.app.repository.CuestionarioRepository;
import com.utes.spring.web.app.service.CuestionarioService;
import com.utes.spring.web.app.service.RespuestaService;

@Service("CuestionarioService")
public class CuestionarioServiceImp implements CuestionarioService {

	@Autowired
	private CuestionarioRepository cuestionarioRepository;
	@Autowired
	private RespuestaService respuestaService;

	@Override
	@Transactional
	public boolean create(CuestionarioDTO obj) {
		boolean success = false;
		try {
			Cuestionario cuestionarioBD = new Cuestionario();
			this.convertirDtoToEntity(obj, cuestionarioBD);
			this.cuestionarioRepository.save(cuestionarioBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(CuestionarioDTO obj) {
		boolean success = false;
		try {
			Cuestionario cuestionarioBD = this.cuestionarioRepository.findById(obj.getIdCue()).orElse(null);
			if (cuestionarioBD != null) {
				this.convertirDtoToEntity(obj, cuestionarioBD);
				this.cuestionarioRepository.save(cuestionarioBD);
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
			Cuestionario cuestionarioBD = this.cuestionarioRepository.findById(id).orElse(null);
			if (cuestionarioBD != null) {
				this.cuestionarioRepository.delete(cuestionarioBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CuestionarioDTO> obtenerListadoCuestionarioPorEstado(boolean estado) {
		final List<Cuestionario> listCuestionariosBD = this.cuestionarioRepository.findByCueActivo(estado);
		final List<CuestionarioDTO> resultado = new ArrayList<CuestionarioDTO>();
		if (listCuestionariosBD != null && !listCuestionariosBD.isEmpty()) {
			for (final Cuestionario cuestionario : listCuestionariosBD) {
				resultado.add(this.convertirEntityToDto(cuestionario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public CuestionarioDTO obtenerCuestionario(Integer id) {
		Cuestionario cuestionarioBD = this.cuestionarioRepository.findById(id).orElse(null);
		if (cuestionarioBD != null) {
			return this.convertirEntityToDto(cuestionarioBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CuestionarioDTO> obtenerListadoCuestionario() {
		final List<Cuestionario> listCuestionariosBD = this.cuestionarioRepository.findAll();
		final List<CuestionarioDTO> resultado = new ArrayList<CuestionarioDTO>();
		if (listCuestionariosBD != null && !listCuestionariosBD.isEmpty()) {
			for (final Cuestionario cuestionario : listCuestionariosBD) {
				resultado.add(this.convertirEntityToDto(cuestionario, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CuestionarioDTO> obtenerListadoCuestionarioPorEstadoTipo(boolean estado, String idsTipos,
			Integer idinscripcion) {
		List<Integer> list = new ArrayList<>();
		String[] s = idsTipos.split(",");
		if (!idsTipos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Cuestionario> listCuestionariosBD = this.cuestionarioRepository
				.findByCueActivoAndCueIdInscripcionAndCueIdTipoIn(estado, idinscripcion, list);
		final List<CuestionarioDTO> resultado = new ArrayList<CuestionarioDTO>();
		if (listCuestionariosBD != null && !listCuestionariosBD.isEmpty()) {
			for (final Cuestionario cuestionario : listCuestionariosBD) {
				resultado.add(this.convertirEntityToDto(cuestionario, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(CuestionarioDTO objectDTO, Cuestionario objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idCue", "respuestas");
	}

	@Override
	public CuestionarioDTO convertirEntityToDto(Cuestionario objectEntity, boolean loadOneR, boolean loadAllList) {
		CuestionarioDTO objectDTO = new CuestionarioDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "respuestas");
		if (loadAllList) {
			if (objectEntity.getRespuestas() != null && !objectEntity.getRespuestas().isEmpty()) {
				for (Respuesta respuesta : objectEntity.getRespuestas()) {
					objectDTO.getRespuestas().add(respuestaService.convertirEntityToDto(respuesta, false, false));
				}
			}
		}
		return objectDTO;
	}

}
