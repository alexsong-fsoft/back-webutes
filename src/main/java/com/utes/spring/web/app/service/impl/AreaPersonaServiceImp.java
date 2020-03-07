package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.AreaPersonaDTO;
import com.utes.spring.web.app.entity.Area;
import com.utes.spring.web.app.entity.AreaPersona;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.repository.AreaPersonaRepository;
import com.utes.spring.web.app.repository.AreaRepository;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.service.AreaPersonaService;
import com.utes.spring.web.app.service.AreaService;
import com.utes.spring.web.app.service.PersonaService;

@Service("AreaPersonaService")
public class AreaPersonaServiceImp implements AreaPersonaService {

	@Autowired
	private AreaPersonaRepository areaPersonaRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private AreaRepository areaRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private AreaService areaService;

	@Override
	@Transactional
	public boolean create(AreaPersonaDTO obj) {
		boolean success = false;
		try {
			AreaPersona areaBD = new AreaPersona();
			this.convertirDtoToEntity(obj, areaBD);
			this.areaPersonaRepository.save(areaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(AreaPersonaDTO obj) {
		boolean success = false;
		try {
			AreaPersona areaPersonaBD = this.areaPersonaRepository.findById(obj.getIdArPer()).orElse(null);
			if (areaPersonaBD != null) {
				this.convertirDtoToEntity(obj, areaPersonaBD);
				this.areaPersonaRepository.save(areaPersonaBD);
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
			AreaPersona areaPersonaBD = this.areaPersonaRepository.findById(id).orElse(null);
			if (areaPersonaBD != null) {
				this.areaPersonaRepository.delete(areaPersonaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaPersonaDTO> obtenerListadoAreaPersona(boolean activo) {
		final List<AreaPersona> listAreaPersonasBD = this.areaPersonaRepository.findByArPerActivo(activo);
		final List<AreaPersonaDTO> resultado = new ArrayList<AreaPersonaDTO>();
		if (listAreaPersonasBD != null && !listAreaPersonasBD.isEmpty()) {
			for (final AreaPersona areaPersona : listAreaPersonasBD) {
				resultado.add(this.convertirEntityToDto(areaPersona, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AreaPersonaDTO obtenerAreaPersona(Integer id) {
		final AreaPersona areaPersonaBD = this.areaPersonaRepository.findById(id).orElse(null);
		AreaPersonaDTO resultado = new AreaPersonaDTO();
		if (areaPersonaBD != null) {
			resultado = this.convertirEntityToDto(areaPersonaBD, true, true);
			return resultado;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaPersonaDTO> obtenerListadoAreapersonaxPersona(Integer idper, boolean activo) {
		final List<AreaPersona> listAreaPersonasBD = this.areaPersonaRepository.findByArPerActivoAndPersonaIdPer(activo,
				idper);
		final List<AreaPersonaDTO> resultado = new ArrayList<AreaPersonaDTO>();
		if (listAreaPersonasBD != null && !listAreaPersonasBD.isEmpty()) {
			for (final AreaPersona areaPersona : listAreaPersonasBD) {
				resultado.add(this.convertirEntityToDto(areaPersona, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AreaPersonaDTO obtenerListadoAreapersonaxPersona(Integer idper, Integer idare, boolean activo) {
		final AreaPersona areaPersonaBD = this.areaPersonaRepository
				.findByArPerActivoAndPersonaIdPerAndAreaIdAre(activo, idper, idare);
		AreaPersonaDTO resultado = new AreaPersonaDTO();
		if (areaPersonaBD != null) {
			resultado = this.convertirEntityToDto(areaPersonaBD, true, true);
			return resultado;
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AreaPersonaDTO> obtenerListadoAreapersonaxPersona(String idsAreas, Integer idper, boolean activo) {
		List<Integer> list = new ArrayList<>();
		String[] s = idsAreas.split(",");
		if (!idsAreas.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
			// list = new ArrayList<String>(Arrays.asList(ids.split(",")));
		}
		final List<AreaPersona> listAreaPersonasBD = this.areaPersonaRepository
				.findByArPerActivoAndPersonaIdPerAndAreaIdAreIn(activo, idper, list);
		final List<AreaPersonaDTO> resultado = new ArrayList<AreaPersonaDTO>();
		if (listAreaPersonasBD != null && !listAreaPersonasBD.isEmpty()) {
			for (final AreaPersona areaPersona : listAreaPersonasBD) {
				resultado.add(this.convertirEntityToDto(areaPersona, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(AreaPersonaDTO objectDTO, AreaPersona objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idArPer", "persona", "area", "idPersona", "idArea");
		// if (objectDTO.getPersona().getIdPer() != null) {
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
		// if (objectDTO.getArea().getIdAre() != null) {
		if (objectDTO.getIdArea() != null) {
			Area area = this.areaRepository.findById(objectDTO.getIdArea()).orElse(null);
			objectEntity.setArea(area);
		}
	}

	@Override
	public AreaPersonaDTO convertirEntityToDto(AreaPersona objectEntity, boolean loadOneR, boolean loadAllList) {
		AreaPersonaDTO areaPersonaDto = new AreaPersonaDTO();
		BeanUtils.copyProperties(objectEntity, areaPersonaDto, "persona", "area");
		if (loadOneR) {
			if (objectEntity.getPersona() != null) {
				areaPersonaDto.setPersona(personaService.convertirEntityToDto(objectEntity.getPersona(), false, false));
				areaPersonaDto.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getArea() != null) {
				areaPersonaDto.setArea(areaService.convertirEntityToDto(objectEntity.getArea(), false, false));
				areaPersonaDto.setIdArea(objectEntity.getArea().getIdAre());
			}
		}
		return areaPersonaDto;
	}

}
