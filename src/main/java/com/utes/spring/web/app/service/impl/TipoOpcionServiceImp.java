package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.TipoOpcionDTO;
import com.utes.spring.web.app.entity.TipoOpcion;
import com.utes.spring.web.app.repository.TipoOpcionRepository;
import com.utes.spring.web.app.service.TipoOpcionService;

@Service("TipoOpcionService")
public class TipoOpcionServiceImp implements TipoOpcionService {

	@Autowired
	private TipoOpcionRepository tipoOpcionRepository;

	@Override
	@Transactional
	public boolean create(TipoOpcionDTO obj) {
		boolean success = false;
		try {
			TipoOpcion tipoOpcionBD = new TipoOpcion();
			this.convertirDtoToEntity(obj, tipoOpcionBD);
			this.tipoOpcionRepository.save(tipoOpcionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(TipoOpcionDTO obj) {
		boolean success = false;
		try {
			TipoOpcion tipoOpcionBD = this.tipoOpcionRepository.findById(obj.getPkTop()).orElse(null);
			if (tipoOpcionBD != null) {
				this.convertirDtoToEntity(obj, tipoOpcionBD);
				this.tipoOpcionRepository.save(tipoOpcionBD);
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
			TipoOpcion tipoOpcionBD = this.tipoOpcionRepository.findById(id).orElse(null);
			if (tipoOpcionBD != null) {
				this.tipoOpcionRepository.delete(tipoOpcionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoOpcionDTO> obtenerListadoTipoOpcion(boolean activo) {
		final List<TipoOpcion> listTipoOpcionsBD = this.tipoOpcionRepository.findByTopActivo(activo);
		final List<TipoOpcionDTO> resultado = new ArrayList<TipoOpcionDTO>();
		if (listTipoOpcionsBD != null && !listTipoOpcionsBD.isEmpty()) {
			for (final TipoOpcion tipoOpcion : listTipoOpcionsBD) {
				resultado.add(this.convertirEntityToDto(tipoOpcion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public TipoOpcionDTO obtenerTipoOpcion(Integer id) {
		TipoOpcion tipoOpcionBD = this.tipoOpcionRepository.findById(id).orElse(null);
		if (tipoOpcionBD != null) {
			return this.convertirEntityToDto(tipoOpcionBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(TipoOpcionDTO objectDTO, TipoOpcion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "pkTop");

	}

	@Override
	public TipoOpcionDTO convertirEntityToDto(TipoOpcion objectEntity, boolean loadOneR, boolean loadAllList) {
		TipoOpcionDTO objectDTO = new TipoOpcionDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO);
		return objectDTO;
	}

}
