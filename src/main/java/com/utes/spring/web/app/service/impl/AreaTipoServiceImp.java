package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.AreaTipoDTO;
import com.utes.spring.web.app.entity.Area;
import com.utes.spring.web.app.entity.AreaTipo;
import com.utes.spring.web.app.repository.AreaTipoRepository;
import com.utes.spring.web.app.service.AreaService;
import com.utes.spring.web.app.service.AreaTipoService;

@Service("AreaTipoService")
public class AreaTipoServiceImp implements AreaTipoService {

	@Autowired
	private AreaTipoRepository areaTipoRepository;
	@Autowired
	private AreaService areaService;

	@Override
	@Transactional
	public boolean create(AreaTipoDTO obj) {
		boolean success = false;
		try {
			AreaTipo areaTipoBD = new AreaTipo();
			this.convertirDtoToEntity(obj, areaTipoBD);
			this.areaTipoRepository.save(areaTipoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(AreaTipoDTO obj) {
		boolean success = false;
		try {
			AreaTipo areaTipoBD = this.areaTipoRepository.findById(obj.getIdAreT()).orElse(null);
			if (areaTipoBD != null) {
				this.convertirDtoToEntity(obj, areaTipoBD);
				this.areaTipoRepository.save(areaTipoBD);
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
			AreaTipo areaTipoBD = this.areaTipoRepository.findById(id).orElse(null);
			if (areaTipoBD != null) {
				this.areaTipoRepository.delete(areaTipoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaTipoDTO> obtenerListadoAreaTipo(boolean activo) {
		final List<AreaTipo> listAreaTipoBD = this.areaTipoRepository.findByAretActivoOrderByAretNombreAsc(activo);
		final List<AreaTipoDTO> resultado = new ArrayList<AreaTipoDTO>();
		if (listAreaTipoBD != null && !listAreaTipoBD.isEmpty()) {
			for (final AreaTipo areaTipo : listAreaTipoBD) {
				resultado.add(this.convertirEntityToDto(areaTipo, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AreaTipoDTO obtenerAreaTipo(Integer id) {
		AreaTipo areaTipoBD = this.areaTipoRepository.findById(id).orElse(null);
		if (areaTipoBD != null) {
			return this.convertirEntityToDto(areaTipoBD, true, true);
		}
		return null;
	}

	@Override
	public List<AreaTipoDTO> obtenerListadoAreaTipo(Integer idtipo, boolean activo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertirDtoToEntity(AreaTipoDTO areaTipoDto, AreaTipo areaTipoEntity) {
		BeanUtils.copyProperties(areaTipoDto, areaTipoEntity, "idAreT", "areas");
	}

	@Override
	public AreaTipoDTO convertirEntityToDto(AreaTipo areaTipoEntity, boolean loadOneR, boolean loadAllList) {
		AreaTipoDTO areaTipoDto = new AreaTipoDTO();
		BeanUtils.copyProperties(areaTipoEntity, areaTipoDto, "areas");
		if (loadAllList) {
			if (areaTipoEntity.getAreas() != null && !areaTipoEntity.getAreas().isEmpty()) {
				for (Area area : areaTipoEntity.getAreas()) {
					areaTipoDto.getAreas().add(areaService.convertirEntityToDto(area, false, false));
				}
			}
		}
		return areaTipoDto;
	}
}
