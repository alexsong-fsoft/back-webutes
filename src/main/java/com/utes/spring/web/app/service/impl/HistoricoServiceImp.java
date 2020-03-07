package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.HistoricoDTO;
import com.utes.spring.web.app.entity.Historico;
import com.utes.spring.web.app.repository.HistoricoRepository;
import com.utes.spring.web.app.service.HistoricoService;

@Service("HistoricoService")
public class HistoricoServiceImp implements HistoricoService {

	@Autowired
	private HistoricoRepository historicoRepository;

	@Override
	@Transactional
	public boolean create(HistoricoDTO obj) {
		boolean success = false;
		try {
			Historico historicoBD = new Historico();
			this.convertirDtoToEntity(obj, historicoBD);
			this.historicoRepository.save(historicoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(HistoricoDTO obj) {
		boolean success = false;
		try {
			Historico historicoBD = this.historicoRepository.findById(obj.getPkHis()).orElse(null);
			if (historicoBD != null) {
				this.convertirDtoToEntity(obj, historicoBD);
				this.historicoRepository.save(historicoBD);
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
			Historico historicoBD = this.historicoRepository.findById(id).orElse(null);
			if (historicoBD != null) {
				this.historicoRepository.delete(historicoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HistoricoDTO> obtenerHistoricoxTema(Integer idtema) {
		final List<Historico> listHistoricosBD = this.historicoRepository.findByHisTemaOrderByHisFechaCambioAsc(idtema);
		final List<HistoricoDTO> resultado = new ArrayList<HistoricoDTO>();
		if (listHistoricosBD != null && !listHistoricosBD.isEmpty()) {
			for (final Historico historico : listHistoricosBD) {
				resultado.add(this.convertirEntityToDto(historico, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public HistoricoDTO obtenerHistorico(Integer id) {
		Historico historicoBD = this.historicoRepository.findById(id).orElse(null);
		if (historicoBD != null) {
			return this.convertirEntityToDto(historicoBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HistoricoDTO> obtenerHistoricoxTema(Integer idtema, Integer idpersona) {
		final List<Historico> listHistoricosBD = this.historicoRepository
				.findByHisTemaAndHisPersonaOrderByHisFechaCambioAsc(idtema, idpersona);
		final List<HistoricoDTO> resultado = new ArrayList<HistoricoDTO>();
		if (listHistoricosBD != null && !listHistoricosBD.isEmpty()) {
			for (final Historico historico : listHistoricosBD) {
				resultado.add(this.convertirEntityToDto(historico, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public HistoricoDTO obtenerEntidadHistorico(Integer idtema) {
		final List<Historico> listHistoricosBD = this.historicoRepository.findByHisTemaOrderByHisFechaCambioAsc(idtema);
		if (listHistoricosBD != null && !listHistoricosBD.isEmpty()) {
			return this.convertirEntityToDto(listHistoricosBD.get(0), true, true);
		}
		return null;
	}

	@Override
	public HistoricoDTO obtenerEntidadHistorico(Integer idtema, Integer idpersona) {
		final List<Historico> listHistoricosBD = this.historicoRepository
				.findByHisTemaAndHisPersonaOrderByHisFechaCambioAsc(idtema, idpersona);
		if (listHistoricosBD != null && !listHistoricosBD.isEmpty()) {
			return this.convertirEntityToDto(listHistoricosBD.get(0), true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<HistoricoDTO> obtenerHistorico() {
		Sort sort = new Sort(Direction.ASC, "hisFechaCambio");
		final List<Historico> listHistoricosBD = this.historicoRepository.findAll(sort);
		final List<HistoricoDTO> resultado = new ArrayList<HistoricoDTO>();
		if (listHistoricosBD != null && !listHistoricosBD.isEmpty()) {
			for (final Historico historico : listHistoricosBD) {
				resultado.add(this.convertirEntityToDto(historico, false, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(HistoricoDTO objectDTO, Historico objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "pkHis");
	}

	@Override
	public HistoricoDTO convertirEntityToDto(Historico objectEntity, boolean loadOneR, boolean loadAllList) {
		HistoricoDTO objectDTO = new HistoricoDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO);
		return objectDTO;
	}
}
