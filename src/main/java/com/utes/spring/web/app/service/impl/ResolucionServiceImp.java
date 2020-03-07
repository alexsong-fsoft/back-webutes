package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.ResolucionDTO;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Resolucion;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.entity.TipoResolucion;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.ResolucionRepository;
import com.utes.spring.web.app.repository.TemaRepository;
import com.utes.spring.web.app.repository.TipoResolucionRepository;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.ResolucionService;
import com.utes.spring.web.app.service.TemaService;
import com.utes.spring.web.app.service.TipoResolucionService;

@Service("ResolucionService")
public class ResolucionServiceImp implements ResolucionService {

	@Autowired
	private ResolucionRepository resolucionRepository;
	@Autowired
	private TipoResolucionRepository tipoResolucionRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private TipoResolucionService tipoResolucionService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private TemaService temaService;

	@Override
	@Transactional
	public boolean create(ResolucionDTO obj) {
		boolean success = false;
		try {
			Resolucion resolucionBD = new Resolucion();
			this.convertirDtoToEntity(obj, resolucionBD);
			this.resolucionRepository.save(resolucionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(ResolucionDTO obj) {
		boolean success = false;
		try {
			Resolucion resolucionBD = this.resolucionRepository.findById(obj.getIdRsl()).orElse(null);
			if (resolucionBD != null) {
				this.convertirDtoToEntity(obj, resolucionBD);
				this.resolucionRepository.save(resolucionBD);
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
			Resolucion resolucionBD = this.resolucionRepository.findById(id).orElse(null);
			if (resolucionBD != null) {
				this.resolucionRepository.delete(resolucionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResolucionDTO> obtenerListadoResolucion(boolean activo) {
		final List<Resolucion> listResolucionsBD = this.resolucionRepository.findByRslActivo(activo);
		final List<ResolucionDTO> resultado = new ArrayList<ResolucionDTO>();
		if (listResolucionsBD != null && !listResolucionsBD.isEmpty()) {
			for (final Resolucion resolucion : listResolucionsBD) {
				resultado.add(this.convertirEntityToDto(resolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResolucionDTO> obtenerResolucionxTema(Integer idtema) {
		Sort sort = new Sort(Direction.ASC, "rslFechaResolucion");
		final List<Resolucion> listResolucionsBD = this.resolucionRepository.findByTemaIdTem(idtema, sort);
		final List<ResolucionDTO> resultado = new ArrayList<ResolucionDTO>();
		if (listResolucionsBD != null && !listResolucionsBD.isEmpty()) {
			for (final Resolucion resolucion : listResolucionsBD) {
				resultado.add(this.convertirEntityToDto(resolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ResolucionDTO obtenerResolucionxTemaIdTipoRes(Integer idtema, Integer idtipores) {
		Sort sort = new Sort(Direction.ASC, "rslFechaResolucion");
		final List<Resolucion> listResolucionsBD = this.resolucionRepository
				.findByTemaIdTemAndTipoResolucionIdTrsl(idtema, idtipores, sort);
		if (listResolucionsBD != null && !listResolucionsBD.isEmpty()) {
			return this.convertirEntityToDto(listResolucionsBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ResolucionDTO obtenerResolucionxId(Integer idresolucion) {
		Resolucion resolucionBD = this.resolucionRepository.findById(idresolucion).orElse(null);
		if (resolucionBD != null) {
			return this.convertirEntityToDto(resolucionBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResolucionDTO> obtenerResolucionxTemaEstadoresolucion(Integer idtema, Integer idtiporesolucion) {
		Sort sort = new Sort(Direction.ASC, "rslFechaResolucion");
		final List<Resolucion> listResolucionsBD = this.resolucionRepository
				.findByTemaIdTemAndTipoResolucionIdTrsl(idtema, idtiporesolucion, sort);
		final List<ResolucionDTO> resultado = new ArrayList<ResolucionDTO>();
		if (listResolucionsBD != null && !listResolucionsBD.isEmpty()) {
			for (final Resolucion resolucion : listResolucionsBD) {
				resultado.add(this.convertirEntityToDto(resolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResolucionDTO> obtenerResolucionxPersona(Integer idpersona) {
		Sort sort = new Sort(Direction.ASC, "rslFechaResolucion");
		final List<Resolucion> listResolucionsBD = this.resolucionRepository.findByPersonaIdPer(idpersona, sort);
		final List<ResolucionDTO> resultado = new ArrayList<ResolucionDTO>();
		if (listResolucionsBD != null && !listResolucionsBD.isEmpty()) {
			for (final Resolucion resolucion : listResolucionsBD) {
				resultado.add(this.convertirEntityToDto(resolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ResolucionDTO> obtenerResolucionxTema(Integer idtema, Date fini, Date ffin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertirDtoToEntity(ResolucionDTO objectDTO, Resolucion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idRsl", "tipoResolucion", "persona", "tema");
		if (objectDTO.getIdTipoResolucion() != null) {
			TipoResolucion tipoResolucion = this.tipoResolucionRepository.findById(objectDTO.getIdTipoResolucion())
					.orElse(null);
			objectEntity.setTipoResolucion(tipoResolucion);
		}
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
		if (objectDTO.getIdTema() != null) {
			Tema tema = this.temaRepository.findById(objectDTO.getIdTema()).orElse(null);
			objectEntity.setTema(tema);
		}
	}

	@Override
	public ResolucionDTO convertirEntityToDto(Resolucion objectEntity, boolean loadOneR, boolean loadAllList) {
		ResolucionDTO objectDTO = new ResolucionDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "tipoResolucion", "persona", "tema");
		if (loadOneR) {
			if (objectEntity.getTipoResolucion() != null) {
				objectDTO.setTipoResolucion(this.tipoResolucionService
						.convertirEntityToDto(objectEntity.getTipoResolucion(), false, false));
				objectDTO.setIdTipoResolucion(objectEntity.getTipoResolucion().getIdTrsl());
			}
			if (objectEntity.getPersona() != null) {
				objectDTO.setPersona(this.personaService.convertirEntityToDto(objectEntity.getPersona(), false, false));
				objectDTO.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getTema() != null) {
				objectDTO.setTema(this.temaService.convertirEntityToDto(objectEntity.getTema(), false, false));
				objectDTO.setIdTema(objectEntity.getTema().getIdTem());
			}
		}
		return objectDTO;
	}

}
