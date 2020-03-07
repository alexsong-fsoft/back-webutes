package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.HitoDTO;
import com.utes.spring.web.app.entity.Hito;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.repository.HitoRepository;
import com.utes.spring.web.app.repository.TemaRepository;
import com.utes.spring.web.app.service.HitoService;
import com.utes.spring.web.app.service.TemaService;

@Service("HitoService")
public class HitoServiceImp implements HitoService {

	@Autowired
	private HitoRepository hitoRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private TemaService temaService;

	@Override
	@Transactional
	public boolean create(HitoDTO obj) {
		boolean success = false;
		try {
			Hito hitoBD = new Hito();
			this.convertirDtoToEntity(obj, hitoBD);
			this.hitoRepository.save(hitoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(HitoDTO obj) {
		boolean success = false;
		try {
			Hito hitoBD = this.hitoRepository.findById(obj.getIdHit()).orElse(null);
			if (hitoBD != null) {
				this.convertirDtoToEntity(obj, hitoBD);
				this.hitoRepository.save(hitoBD);
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
			Hito hitoBD = this.hitoRepository.findById(id).orElse(null);
			if (hitoBD != null) {
				this.hitoRepository.delete(hitoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HitoDTO> obtenerListadoHito(boolean activo) {
		final List<Hito> listHitosBD = this.hitoRepository.findByHitValida(activo);
		final List<HitoDTO> resultado = new ArrayList<HitoDTO>();
		if (listHitosBD != null && !listHitosBD.isEmpty()) {
			for (final Hito hito : listHitosBD) {
				resultado.add(this.convertirEntityToDto(hito, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public HitoDTO obtenerHito(Integer id) {
		Hito hitoBD = this.hitoRepository.findById(id).orElse(null);
		if (hitoBD != null) {
			return this.convertirEntityToDto(hitoBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HitoDTO> obtenerHitoxTema(Integer idtema) {
		final List<Hito> listHitosBD = this.hitoRepository.findByTemaIdTemOrderByHitFechaEntregaAsc(idtema);
		final List<HitoDTO> resultado = new ArrayList<HitoDTO>();
		if (listHitosBD != null && !listHitosBD.isEmpty()) {
			for (final Hito hito : listHitosBD) {
				resultado.add(this.convertirEntityToDto(hito, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public HitoDTO obtenerEntidadaHitoxTema(Integer idtema) {
		final List<Hito> listHitosBD = this.hitoRepository.findByTemaIdTemOrderByHitFechaEntregaAsc(idtema);
		if (listHitosBD != null && !listHitosBD.isEmpty()) {
			return this.convertirEntityToDto(listHitosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerSecuencialHito(Integer idtema) {
		return this.hitoRepository.obtenerSecuencialHito(idtema);
	}

	@Override
	public void convertirDtoToEntity(HitoDTO objectDTO, Hito objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idHit", "tema", "idTema");
		if (objectDTO.getIdTema() != null) {
			Tema tema = this.temaRepository.findById(objectDTO.getIdTema()).orElse(null);
			objectEntity.setTema(tema);
		}
	}

	@Override
	public HitoDTO convertirEntityToDto(Hito objectEntity, boolean loadOneR, boolean loadAllList) {
		HitoDTO objectDTO = new HitoDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "tema");
		if (loadOneR) {
			if (objectEntity.getTema() != null) {
				objectDTO.setTema(temaService.convertirEntityToDto(objectEntity.getTema(), false, false));
				objectDTO.setIdTema(objectEntity.getTema().getIdTem());
			}
		}
		return objectDTO;
	}

}
