package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.InformeDTO;
import com.utes.spring.web.app.entity.Informe;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.repository.InformeRepository;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.TemaRepository;
import com.utes.spring.web.app.service.InformeService;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.TemaService;

@Service("InformeService")
public class InformeServiceImp implements InformeService {

	@Autowired
	private InformeRepository informeRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private TemaService temaService;

	@Override
	@Transactional
	public boolean create(InformeDTO obj) {
		boolean success = false;
		try {
			Informe informeBD = new Informe();
			this.convertirDtoToEntity(obj, informeBD);
			this.informeRepository.save(informeBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(InformeDTO obj) {
		boolean success = false;
		try {
			Informe informeBD = this.informeRepository.findById(obj.getIdInf()).orElse(null);
			if (informeBD != null) {
				this.convertirDtoToEntity(obj, informeBD);
				this.informeRepository.save(informeBD);
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
			Informe informeBD = this.informeRepository.findById(id).orElse(null);
			if (informeBD != null) {
				this.informeRepository.delete(informeBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<InformeDTO> obtenerListadoInforme(boolean activo) {
		final List<Informe> listInformesBD = this.informeRepository.findByInfActivo(activo);
		final List<InformeDTO> resultado = new ArrayList<InformeDTO>();
		if (listInformesBD != null && !listInformesBD.isEmpty()) {
			for (final Informe informe : listInformesBD) {
				resultado.add(this.convertirEntityToDto(informe, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public InformeDTO obtenerInforme(Integer id) {
		Informe informeBD = this.informeRepository.findById(id).orElse(null);
		if (informeBD != null) {
			return this.convertirEntityToDto(informeBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<InformeDTO> obtenerInformesxTema(Integer idtema) {
		final List<Informe> listInformesBD = this.informeRepository.findByTemaIdTemOrderByInfFechaDesc(idtema);
		final List<InformeDTO> resultado = new ArrayList<InformeDTO>();
		if (listInformesBD != null && !listInformesBD.isEmpty()) {
			for (final Informe informe : listInformesBD) {
				resultado.add(this.convertirEntityToDto(informe, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<InformeDTO> obtenerInformesxTemaPersona(Integer idtema, Integer idpersona) {
		final List<Informe> listInformesBD = this.informeRepository
				.findByTemaIdTemAndPersonaIdPerOrderByInfFechaDesc(idtema, idpersona);
		final List<InformeDTO> resultado = new ArrayList<InformeDTO>();
		if (listInformesBD != null && !listInformesBD.isEmpty()) {
			for (final Informe informe : listInformesBD) {
				resultado.add(this.convertirEntityToDto(informe, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(InformeDTO objectDTO, Informe objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idInf", "persona", "tema");
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
	public InformeDTO convertirEntityToDto(Informe objectEntity, boolean loadOneR, boolean loadAllList) {
		InformeDTO objectDTO = new InformeDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "persona", "tema");
		if (loadOneR) {
			if (objectEntity.getPersona() != null) {
				objectDTO.setPersona(personaService.convertirEntityToDto(objectEntity.getPersona(), false, false));
				objectDTO.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getTema() != null) {
				objectDTO.setTema(temaService.convertirEntityToDto(objectEntity.getTema(), false, false));
				objectDTO.setIdTema(objectEntity.getTema().getIdTem());
			}
		}
		return objectDTO;
	}

}
