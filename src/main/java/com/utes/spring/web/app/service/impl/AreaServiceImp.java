package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.utes.spring.web.app.dto.AreaDTO;
import com.utes.spring.web.app.entity.Area;
import com.utes.spring.web.app.entity.AreaPersona;
import com.utes.spring.web.app.entity.AreaTipo;
import com.utes.spring.web.app.repository.AreaRepository;
import com.utes.spring.web.app.repository.AreaTipoRepository;
import com.utes.spring.web.app.service.AreaPersonaService;
import com.utes.spring.web.app.service.AreaService;
import com.utes.spring.web.app.service.AreaTipoService;

@Service("AreaService")
public class AreaServiceImp implements AreaService {
	@Autowired
	private AreaRepository areaRepository;
	@Autowired
	private AreaTipoRepository areaTipoRepository;
	@Autowired
	private AreaTipoService areaTipoService;
	@Autowired
	private AreaPersonaService areaPersonaService;

	@Override
	@Transactional
	public boolean create(AreaDTO obj) {
		boolean success = false;
		try {
			Area areaBD = new Area();
			this.convertirDtoToEntity(obj, areaBD);
			this.areaRepository.save(areaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(AreaDTO obj) {
		boolean success = false;
		try {
			Area areaBD = this.areaRepository.findById(obj.getIdAre()).orElse(null);
			if (areaBD != null) {
				this.convertirDtoToEntity(obj, areaBD);
				this.areaRepository.save(areaBD);
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
			Area areaBD = this.areaRepository.findById(id).orElse(null);
			if (areaBD != null) {
				this.areaRepository.delete(areaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaDTO> obtenerListadoArea(boolean activo) {
		final List<Area> listAreasBD = this.areaRepository.findByAreActivoOrderByAreNombreAsc(activo);
		final List<AreaDTO> resultado = new ArrayList<AreaDTO>();
		if (listAreasBD != null && !listAreasBD.isEmpty()) {
			for (final Area area : listAreasBD) {
				resultado.add(this.convertirEntityToDto(area, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<AreaDTO> obtenerListadoAreaPageable(boolean activo) {
		int page = 0;
		try {
			page = Integer.parseInt(
					(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())
							.getHeader("Page"));
		} catch (final Exception e) {

		}
		Pageable pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC, "areNombre"));
		final Page<Area> listAreasBD = this.areaRepository.findByAreActivoOrderByAreNombreAsc(activo, pageable);
		final Page<AreaDTO> resultado = listAreasBD.map(this::convertirEntityToDtoForPage);
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AreaDTO obtenerArea(Integer id) {
		Area areaBD = this.areaRepository.findById(id).orElse(null);
		if (areaBD != null) {
			return this.convertirEntityToDto(areaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaDTO> obtenerListadoAreaPorTipo(Integer idtipo, boolean activo) {
		final List<Area> listAreasBD = this.areaRepository.findByAreasPorTipo(activo, idtipo);
		final List<AreaDTO> resultado = new ArrayList<AreaDTO>();
		if (listAreasBD != null && !listAreasBD.isEmpty()) {
			for (final Area area : listAreasBD) {
				resultado.add(this.convertirEntityToDto(area, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaDTO> obtenerListadoArea(String ids, boolean activo) {
		List<Integer> list = new ArrayList<>();
		String[] s = ids.split(",");
		if (!ids.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Area> listAreasBD = this.areaRepository.findByAreActivoAndIdAreIn(activo, list);
		final List<AreaDTO> resultado = new ArrayList<AreaDTO>();
		if (listAreasBD != null && !listAreasBD.isEmpty()) {
			for (final Area area : listAreasBD) {
				resultado.add(this.convertirEntityToDto(area, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(AreaDTO objectDto, Area ojectEntity) {
		BeanUtils.copyProperties(objectDto, ojectEntity, "idAre", "areaTipo", "areaPersonas", "idAreaTipo");
		if (objectDto.getIdAreaTipo() != null) {
			AreaTipo areaTipo = this.areaTipoRepository.findById(objectDto.getIdAreaTipo()).orElse(null);
			ojectEntity.setAreaTipo(areaTipo);
		}
	}

	@Override
	public AreaDTO convertirEntityToDto(Area objectEntity, boolean loadOneR, boolean loadAllList) {
		AreaDTO objectDto = new AreaDTO();
		BeanUtils.copyProperties(objectEntity, objectDto, "areaTipo", "areaPersonas");
		if (loadOneR) {
			if (objectEntity.getAreaTipo() != null) {
				objectDto.setAreaTipo(areaTipoService.convertirEntityToDto(objectEntity.getAreaTipo(), false, false));
				objectDto.setIdAreaTipo(objectEntity.getAreaTipo().getIdAreT());
			}
		}
		if (loadAllList) {
			if (objectEntity.getAreaPersonas() != null && !objectEntity.getAreaPersonas().isEmpty()) {
				for (AreaPersona areaPersona : objectEntity.getAreaPersonas()) {
					objectDto.getAreaPersonas().add(areaPersonaService.convertirEntityToDto(areaPersona, false, false));
				}
			}
		}
		return objectDto;
	}

	private AreaDTO convertirEntityToDtoForPage(Area objectEntity) {
		return this.convertirEntityToDto(objectEntity, true, false);
	}

}
