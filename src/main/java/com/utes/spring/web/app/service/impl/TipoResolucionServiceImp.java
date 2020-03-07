package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.TipoResolucionDTO;
import com.utes.spring.web.app.entity.Resolucion;
import com.utes.spring.web.app.entity.TipoResolucion;
import com.utes.spring.web.app.repository.TipoResolucionRepository;
import com.utes.spring.web.app.service.ResolucionService;
import com.utes.spring.web.app.service.TipoResolucionService;

@Service("TipoResolucionService")
public class TipoResolucionServiceImp implements TipoResolucionService {

	@Autowired
	private TipoResolucionRepository tipoResolucionRepository;
	@Autowired
	private ResolucionService resolucionService;

	@Override
	@Transactional
	public boolean create(TipoResolucionDTO obj) {
		boolean success = false;
		try {
			TipoResolucion tipoResolucionBD = new TipoResolucion();
			this.convertirDtoToEntity(obj, tipoResolucionBD);
			this.tipoResolucionRepository.save(tipoResolucionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(TipoResolucionDTO obj) {
		boolean success = false;
		try {
			TipoResolucion tipoResolucionBD = this.tipoResolucionRepository.findById(obj.getIdTrsl()).orElse(null);
			if (tipoResolucionBD != null) {
				this.convertirDtoToEntity(obj, tipoResolucionBD);
				this.tipoResolucionRepository.save(tipoResolucionBD);
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
			TipoResolucion tipoResolucionBD = this.tipoResolucionRepository.findById(id).orElse(null);
			if (tipoResolucionBD != null) {
				this.tipoResolucionRepository.delete(tipoResolucionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoResolucionDTO> obtenerListadoTipoResolucion(boolean activo) {
		Sort sort = new Sort(Direction.ASC, "trslTitulo");
		final List<TipoResolucion> listTipoResolucionsBD = this.tipoResolucionRepository.findByTrslActive(activo, sort);
		final List<TipoResolucionDTO> resultado = new ArrayList<TipoResolucionDTO>();
		if (listTipoResolucionsBD != null && !listTipoResolucionsBD.isEmpty()) {
			for (final TipoResolucion tipoResolucion : listTipoResolucionsBD) {
				resultado.add(this.convertirEntityToDto(tipoResolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public TipoResolucionDTO obtenerTipoResolucion(Integer id) {
		TipoResolucion tipoResolucionBD = this.tipoResolucionRepository.findById(id).orElse(null);
		if (tipoResolucionBD != null) {
			return this.convertirEntityToDto(tipoResolucionBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(TipoResolucionDTO objectDTO, TipoResolucion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idTrsl", "resoluciones");

	}

	@Override
	public TipoResolucionDTO convertirEntityToDto(TipoResolucion objectEntity, boolean loadOneR, boolean loadAllList) {
		TipoResolucionDTO objectDTO = new TipoResolucionDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "resoluciones");
		if (loadAllList) {
			if (objectEntity.getResoluciones() != null && !objectEntity.getResoluciones().isEmpty()) {
				for (Resolucion resolucion : objectEntity.getResoluciones()) {
					objectDTO.getResoluciones()
							.add(this.resolucionService.convertirEntityToDto(resolucion, false, false));
				}
			}
		}
		return objectDTO;
	}

}
