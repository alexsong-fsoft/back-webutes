package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.EvolucionDTO;
import com.utes.spring.web.app.entity.Evolucion;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.repository.EvolucionRepository;
import com.utes.spring.web.app.repository.TemaRepository;
import com.utes.spring.web.app.service.EvolucionService;
import com.utes.spring.web.app.service.TemaService;

@Service("EvolucionService")
public class EvolucionServiceImp implements EvolucionService {

	@Autowired
	private EvolucionRepository evolucionRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private TemaService temaService;

	@Override
	@Transactional
	public boolean create(EvolucionDTO obj) {
		boolean success = false;
		try {
			Evolucion evolucionBD = new Evolucion();
			this.convertirDtoToEntity(obj, evolucionBD);
			this.evolucionRepository.save(evolucionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(EvolucionDTO obj) {
		boolean success = false;
		try {
			Evolucion evolucionBD = this.evolucionRepository.findById(obj.getIdEvl()).orElse(null);
			if (evolucionBD != null) {
				this.convertirDtoToEntity(obj, evolucionBD);
				this.evolucionRepository.save(evolucionBD);
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
			Evolucion evolucionBD = this.evolucionRepository.findById(id).orElse(null);
			if (evolucionBD != null) {
				this.evolucionRepository.delete(evolucionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EvolucionDTO> obtenerListadoEvolucion(boolean activo) {
		final List<Evolucion> listEvolucionsBD = this.evolucionRepository.findByEvlActivo(activo);
		final List<EvolucionDTO> resultado = new ArrayList<EvolucionDTO>();
		if (listEvolucionsBD != null && !listEvolucionsBD.isEmpty()) {
			for (final Evolucion evolucion : listEvolucionsBD) {
				resultado.add(this.convertirEntityToDto(evolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<EvolucionDTO> obtenerEvolucionxTema(Integer idTema) {
		final List<Evolucion> listEvolucionsBD = this.evolucionRepository
				.findByTemaIdTemOrderByEvlFechaCitaDesc(idTema);
		final List<EvolucionDTO> resultado = new ArrayList<EvolucionDTO>();
		if (listEvolucionsBD != null && !listEvolucionsBD.isEmpty()) {
			for (final Evolucion evolucion : listEvolucionsBD) {
				resultado.add(this.convertirEntityToDto(evolucion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public EvolucionDTO obtenerEntidadaEvolucionxTema(Integer idtema) {
		final List<Evolucion> listEvolucionsBD = this.evolucionRepository.findByTemaIdTem(idtema);
		EvolucionDTO resultado = new EvolucionDTO();
		if (listEvolucionsBD != null && !listEvolucionsBD.isEmpty()) {
			resultado = this.convertirEntityToDto(listEvolucionsBD.get(0), true, false);
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerSecuencialEvolucion(Integer idtema) {
		return this.evolucionRepository.obtenerSecuencialEvolucion(idtema);
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerUltimoRegistroporTema(Integer idtema, Integer idestadoevolucion) {
		final List<Evolucion> listEvolucionsBD = this.evolucionRepository
				.findByEvlIdEstadoAndTemaIdTemOrderByIdEvlDesc(idestadoevolucion, idtema);
		EvolucionDTO resultado = new EvolucionDTO();
		if (listEvolucionsBD != null && !listEvolucionsBD.isEmpty()) {
			resultado = this.convertirEntityToDto(listEvolucionsBD.get(0), true, false);
			return resultado.getEvlIdEstado();
		}
		return 0;
	}

	@Override
	@Transactional(readOnly = true)
	public EvolucionDTO obtenerEntidadaEvolucionPorId(Integer idevolucion) {
		Evolucion evolucionBD = this.evolucionRepository.findById(idevolucion).orElse(null);
		if (evolucionBD != null) {
			return this.convertirEntityToDto(evolucionBD, true, true);
		}
		return null;
	}

	@Override
	public List<EvolucionDTO> obtenerEntidadaEvolucionPorFecha(Date fechacita, Integer idtema, String horacita) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertirDtoToEntity(EvolucionDTO objectDTO, Evolucion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idEvl", "tema", "idTema");
		if (objectDTO.getIdTema() != null) {
			Tema tema = this.temaRepository.findById(objectDTO.getIdTema()).orElse(null);
			objectEntity.setTema(tema);
		}
	}

	@Override
	public EvolucionDTO convertirEntityToDto(Evolucion objectEntity, boolean loadOneR, boolean loadAllList) {
		EvolucionDTO evolucionDto = new EvolucionDTO();
		BeanUtils.copyProperties(objectEntity, evolucionDto, "tema");
		if (loadOneR) {
			if (objectEntity.getTema() != null) {
				evolucionDto.setTema(this.temaService.convertirEntityToDto(objectEntity.getTema(), false, false));
			}
		}
		return evolucionDto;
	}

}
