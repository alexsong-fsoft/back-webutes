package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SysPaginaDTO;
import com.utes.spring.web.app.entity.SysPagina;
import com.utes.spring.web.app.entity.SysPaginaPerfil;
import com.utes.spring.web.app.repository.SysPaginaRepository;
import com.utes.spring.web.app.service.SysPaginaPerfilService;
import com.utes.spring.web.app.service.SysPaginaService;

@Service("SysPaginaService")
public class SysPaginaServiceImp implements SysPaginaService {

	@Autowired
	private SysPaginaRepository sysPaginaRepository;
	@Autowired
	private SysPaginaPerfilService sysPaginaPerfilService;

	@Override
	@Transactional
	public boolean create(SysPaginaDTO obj) {
		boolean success = false;
		try {
			SysPagina sysPaginaBD = new SysPagina();
			this.convertirDtoToEntity(obj, sysPaginaBD);
			this.sysPaginaRepository.save(sysPaginaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysPaginaDTO obj) {
		boolean success = false;
		try {
			SysPagina sysPaginaBD = this.sysPaginaRepository.findById(obj.getIdPag()).orElse(null);
			if (sysPaginaBD != null) {
				this.convertirDtoToEntity(obj, sysPaginaBD);
				this.sysPaginaRepository.save(sysPaginaBD);
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
			SysPagina sysPaginaBD = this.sysPaginaRepository.findById(id).orElse(null);
			if (sysPaginaBD != null) {
				this.sysPaginaRepository.delete(sysPaginaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPaginaDTO> obtenerListadoPagina() {
		// " order by idPag,pagPrincipal,pagOrden asc"
		Sort sort = new Sort(Direction.ASC, "idPag", "pagPrincipal", "pagOrden");
		final List<SysPagina> listSysPaginasBD = this.sysPaginaRepository.findAll(sort);
		final List<SysPaginaDTO> resultado = new ArrayList<SysPaginaDTO>();
		if (listSysPaginasBD != null && !listSysPaginasBD.isEmpty()) {
			for (final SysPagina sysPagina : listSysPaginasBD) {
				resultado.add(this.convertirEntityToDto(sysPagina, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPaginaDTO obtenerListadoPaginaPorId(Integer idpagina) {
		SysPagina sysPaginaBD = this.sysPaginaRepository.findById(idpagina).orElse(null);
		if (sysPaginaBD != null) {
			return this.convertirEntityToDto(sysPaginaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPaginaDTO> obtenerListadoPaginaPadres() {
		Sort sort = new Sort(Direction.ASC, "pagOrden");
		final List<SysPagina> listSysPaginasBD = this.sysPaginaRepository.findByPagTipo('P', sort);
		final List<SysPaginaDTO> resultado = new ArrayList<SysPaginaDTO>();
		if (listSysPaginasBD != null && !listSysPaginasBD.isEmpty()) {
			for (final SysPagina sysPagina : listSysPaginasBD) {
				resultado.add(this.convertirEntityToDto(sysPagina, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(SysPaginaDTO objectDTO, SysPagina objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPag", "sysPaginaPerfiles");
	}

	@Override
	public SysPaginaDTO convertirEntityToDto(SysPagina objectEntity, boolean loadOneR, boolean loadAllList) {
		SysPaginaDTO objectDTO = new SysPaginaDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "sysPaginaPerfiles");
		if (loadAllList) {
			if (objectEntity.getSysPaginaPerfiles() != null && !objectEntity.getSysPaginaPerfiles().isEmpty()) {
				for (SysPaginaPerfil sysPaginaPerfil : objectEntity.getSysPaginaPerfiles()) {
					objectDTO.getSysPaginaPerfiles()
							.add(this.sysPaginaPerfilService.convertirEntityToDto(sysPaginaPerfil, false, false));
				}
			}
		}
		return objectDTO;
	}

}
