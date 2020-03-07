package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.entity.AreaPersona;
import com.utes.spring.web.app.entity.Asignado;
import com.utes.spring.web.app.entity.Informe;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Presolicitud;
import com.utes.spring.web.app.entity.Seleccion;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.service.AreaPersonaService;
import com.utes.spring.web.app.service.AsignadoService;
import com.utes.spring.web.app.service.InformeService;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.PresolicitudService;
import com.utes.spring.web.app.service.SeleccionService;
import com.utes.spring.web.app.service.SysUsuarioService;
import com.utes.spring.web.app.service.TemaService;

@Service("PersonaService")
public class PersonaServiceImp implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private AreaPersonaService areaPersonaService;
	@Autowired
	private AsignadoService asignadoService;
	@Autowired
	private TemaService temaService;
	@Autowired
	private PresolicitudService presolicitudService;
	@Autowired
	private InformeService informeService;
	@Autowired
	private SeleccionService seleccionService;
	@Autowired
	private SysUsuarioService sysUsuarioService;

	@Override
	@Transactional
	public boolean create(PersonaDTO obj) {
		boolean success = false;
		try {
			Persona personaBD = new Persona();
			this.convertirDtoToEntity(obj, personaBD);
			this.personaRepository.save(personaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(PersonaDTO obj) {
		boolean success = false;
		try {
			Persona personaBD = this.personaRepository.findById(obj.getIdPer()).orElse(null);
			if (personaBD != null) {
				this.convertirDtoToEntity(obj, personaBD);
				this.personaRepository.save(personaBD);
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
			Persona personaBD = this.personaRepository.findById(id).orElse(null);
			if (personaBD != null) {
				this.personaRepository.delete(personaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PersonaDTO> obtenerListadoPersona() {
		Sort sort = new Sort(Direction.ASC, "perApellido");
		final List<Persona> listPersonasBD = this.personaRepository.findAll(sort);
		final List<PersonaDTO> resultado = new ArrayList<PersonaDTO>();
		if (listPersonasBD != null && !listPersonasBD.isEmpty()) {
			for (final Persona persona : listPersonasBD) {
				resultado.add(this.convertirEntityToDto(persona, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public PersonaDTO obtenerPersonaPorId(Integer id) {
		Persona personaBD = this.personaRepository.findById(id).orElse(null);
		if (personaBD != null) {
			return this.convertirEntityToDto(personaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public PersonaDTO obtenerPersonaPorCedula(String cedula) {
		Persona personaBD = this.personaRepository.findByPerCedula(cedula);
		if (personaBD != null) {
			return this.convertirEntityToDto(personaBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(PersonaDTO objectDTO, Persona objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPer", "areaPersonas", "asignados", "temas",
				"presolicitudes", "informes", "selecciones", "resoluciones", "sysUsuarios");
	}

	@Override
	public PersonaDTO convertirEntityToDto(Persona objectEntity, boolean loadOneR, boolean loadAllList) {
		PersonaDTO objectDTO = new PersonaDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "areaPersonas", "asignados", "temas", "presolicitudes",
				"informes", "selecciones", "resoluciones", "sysUsuario");
		if (loadOneR) {
			if (objectEntity.getSysUsuario() != null) {
				objectDTO.setSysUsuario(
						this.sysUsuarioService.convertirEntityToDto(objectEntity.getSysUsuario(), false, false));
			}
		}
		if (loadAllList) {
			if (objectEntity.getAreaPersonas() != null && !objectEntity.getAreaPersonas().isEmpty()) {
				for (AreaPersona areaPersona : objectEntity.getAreaPersonas()) {
					objectDTO.getAreaPersonas().add(areaPersonaService.convertirEntityToDto(areaPersona, false, false));
				}
			}
			if (objectEntity.getAsignados() != null && !objectEntity.getAsignados().isEmpty()) {
				for (Asignado asignado : objectEntity.getAsignados()) {
					objectDTO.getAsignados().add(asignadoService.convertirEntityToDto(asignado, false, false));
				}
			}
			if (objectEntity.getTemas() != null && !objectEntity.getTemas().isEmpty()) {
				for (Tema tema : objectEntity.getTemas()) {
					objectDTO.getTemas().add(temaService.convertirEntityToDto(tema, false, false));
				}
			}
			if (objectEntity.getPresolicitudes() != null && !objectEntity.getPresolicitudes().isEmpty()) {
				for (Presolicitud presolicitud : objectEntity.getPresolicitudes()) {
					objectDTO.getPresolicitudes()
							.add(presolicitudService.convertirEntityToDto(presolicitud, false, false));
				}
			}
			if (objectEntity.getInformes() != null && !objectEntity.getInformes().isEmpty()) {
				for (Informe informe : objectEntity.getInformes()) {
					objectDTO.getInformes().add(informeService.convertirEntityToDto(informe, false, false));
				}
			}
			if (objectEntity.getSelecciones() != null && !objectEntity.getSelecciones().isEmpty()) {
				for (Seleccion seleccion : objectEntity.getSelecciones()) {
					objectDTO.getSelecciones().add(seleccionService.convertirEntityToDto(seleccion, false, false));
				}
			}
		}
		return objectDTO;
	}

}
