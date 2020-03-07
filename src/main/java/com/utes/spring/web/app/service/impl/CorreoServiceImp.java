package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.CorreoDTO;
import com.utes.spring.web.app.entity.Correo;
import com.utes.spring.web.app.repository.CorreoRepository;
import com.utes.spring.web.app.service.CorreoService;

@Service("CorreoService")
public class CorreoServiceImp implements CorreoService {

	@Autowired
	private CorreoRepository correoRepository;

	@Override
	@Transactional
	public boolean create(CorreoDTO obj) {
		boolean success = false;
		try {
			Correo CorreoBD = new Correo();
			this.convertirDtoToEntity(obj, CorreoBD);
			this.correoRepository.save(CorreoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(CorreoDTO obj) {
		boolean success = false;
		try {
			Correo correoBD = this.correoRepository.findById(obj.getIdCorreo()).orElse(null);
			if (correoBD != null) {
				this.convertirDtoToEntity(obj, correoBD);
				this.correoRepository.save(correoBD);
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
			Correo correoBD = this.correoRepository.findById(id).orElse(null);
			if (correoBD != null) {
				this.correoRepository.delete(correoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CorreoDTO> obtenerListadoCorreoPorId(Integer idcorreo) {
		final List<Correo> listCorreosBD = this.correoRepository.findByIdCorreo(idcorreo);
		final List<CorreoDTO> resultado = new ArrayList<CorreoDTO>();
		if (listCorreosBD != null && !listCorreosBD.isEmpty()) {
			for (final Correo correo : listCorreosBD) {
				resultado.add(this.convertirEntityToDto(correo, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public CorreoDTO obtenerCorreoPorId(Integer idcorreo) {
		Correo correoBD = this.correoRepository.findById(idcorreo).orElse(null);
		if (correoBD != null) {
			return this.convertirEntityToDto(correoBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CorreoDTO> obtenerCorreo(boolean estado) {
		final List<Correo> listCorreosBD = this.correoRepository.findByCorreoActivo(estado);
		final List<CorreoDTO> resultado = new ArrayList<CorreoDTO>();
		if (listCorreosBD != null && !listCorreosBD.isEmpty()) {
			for (final Correo correo : listCorreosBD) {
				resultado.add(this.convertirEntityToDto(correo, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(CorreoDTO objectDTO, Correo objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity);

	}

	@Override
	public CorreoDTO convertirEntityToDto(Correo objectEntity, boolean loadOneR, boolean loadAllList) {
		CorreoDTO correoDto = new CorreoDTO();
		BeanUtils.copyProperties(objectEntity, correoDto);
		return correoDto;
	}
}
