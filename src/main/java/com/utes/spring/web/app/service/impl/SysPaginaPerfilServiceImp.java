package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SysPaginaPerfilDTO;
import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.entity.SysPagina;
import com.utes.spring.web.app.entity.SysPaginaPerfil;
import com.utes.spring.web.app.entity.SysPerfil;
import com.utes.spring.web.app.repository.SysPaginaPerfilRepository;
import com.utes.spring.web.app.repository.SysPaginaRepository;
import com.utes.spring.web.app.repository.SysPerfilRepository;
import com.utes.spring.web.app.service.SysPaginaPerfilService;
import com.utes.spring.web.app.service.SysPaginaService;
import com.utes.spring.web.app.service.SysPerfilService;

@Service("SysPaginaPerfilService")
public class SysPaginaPerfilServiceImp implements SysPaginaPerfilService {

	@Autowired
	private SysPaginaPerfilRepository sysPaginaPerfilRepository;
	@Autowired
	private SysPaginaRepository sysPaginaRepository;
	@Autowired
	private SysPerfilRepository sysPerfilRepository;
	@Autowired
	private SysPaginaService sysPaginaService;
	@Autowired
	private SysPerfilService sysPerfilService;

	@Override
	@Transactional
	public boolean create(SysPaginaPerfilDTO obj) {
		boolean success = false;
		try {
			SysPaginaPerfil sysPaginaPerfilBD = new SysPaginaPerfil();
			this.convertirDtoToEntity(obj, sysPaginaPerfilBD);
			this.sysPaginaPerfilRepository.save(sysPaginaPerfilBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysPaginaPerfilDTO obj) {
		boolean success = false;
		try {
			SysPaginaPerfil sysPaginaPerfilBD = this.sysPaginaPerfilRepository.findById(obj.getIdPgPrf()).orElse(null);
			if (sysPaginaPerfilBD != null) {
				this.convertirDtoToEntity(obj, sysPaginaPerfilBD);
				this.sysPaginaPerfilRepository.save(sysPaginaPerfilBD);
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
			SysPaginaPerfil sysPaginaPerfilBD = this.sysPaginaPerfilRepository.findById(id).orElse(null);
			if (sysPaginaPerfilBD != null) {
				this.sysPaginaPerfilRepository.delete(sysPaginaPerfilBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPaginaPerfilDTO> obtenerListadoSysPaginaPerfil(boolean activo) {
		final List<SysPaginaPerfil> listSysPaginaPerfilsBD = this.sysPaginaPerfilRepository.findByPgPrfActivo(activo);
		final List<SysPaginaPerfilDTO> resultado = new ArrayList<SysPaginaPerfilDTO>();
		if (listSysPaginaPerfilsBD != null && !listSysPaginaPerfilsBD.isEmpty()) {
			for (final SysPaginaPerfil sysPaginaPerfil : listSysPaginaPerfilsBD) {
				resultado.add(this.convertirEntityToDto(sysPaginaPerfil, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPaginaPerfilDTO obtenerSysPaginaPerfil(Integer id) {
		SysPaginaPerfil sysPaginaPerfilBD = this.sysPaginaPerfilRepository.findById(id).orElse(null);
		if (sysPaginaPerfilBD != null) {
			return this.convertirEntityToDto(sysPaginaPerfilBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorNombrePerfil(String nombreperfil) {
		final List<SysPaginaPerfil> listSysPaginaPerfilsBD = this.sysPaginaPerfilRepository
				.findBySysPerfilPrfNombre(nombreperfil);
		final List<SysPaginaPerfilDTO> resultado = new ArrayList<SysPaginaPerfilDTO>();
		if (listSysPaginaPerfilsBD != null && !listSysPaginaPerfilsBD.isEmpty()) {
			for (final SysPaginaPerfil sysPaginaPerfil : listSysPaginaPerfilsBD) {
				resultado.add(this.convertirEntityToDto(sysPaginaPerfil, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorPerfil(SysPerfilDTO objperfil) {
		final List<SysPaginaPerfil> listSysPaginaPerfilsBD = this.sysPaginaPerfilRepository
				.findBySysPerfilIdPrf(objperfil.getIdPrf());
		final List<SysPaginaPerfilDTO> resultado = new ArrayList<SysPaginaPerfilDTO>();
		if (listSysPaginaPerfilsBD != null && !listSysPaginaPerfilsBD.isEmpty()) {
			for (final SysPaginaPerfil sysPaginaPerfil : listSysPaginaPerfilsBD) {
				resultado.add(this.convertirEntityToDto(sysPaginaPerfil, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPaginaPerfilDTO obtenerPaginaPerfilPorPerfil(SysPerfilDTO objperfil) {
		final List<SysPaginaPerfil> listSysPaginaPerfilsBD = this.sysPaginaPerfilRepository
				.findBySysPerfilIdPrf(objperfil.getIdPrf());
		if (listSysPaginaPerfilsBD != null) {
			return this.convertirEntityToDto(listSysPaginaPerfilsBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorPerfil(SysPerfilDTO objperfil, String tipo) {
		final List<SysPaginaPerfil> listSysPaginaPerfilsBD = this.sysPaginaPerfilRepository
				.findBySysPerfilIdPrfAndSysPaginaPagTipo(objperfil.getIdPrf(), tipo);
		final List<SysPaginaPerfilDTO> resultado = new ArrayList<SysPaginaPerfilDTO>();
		if (listSysPaginaPerfilsBD != null && !listSysPaginaPerfilsBD.isEmpty()) {
			for (final SysPaginaPerfil sysPaginaPerfil : listSysPaginaPerfilsBD) {
				resultado.add(this.convertirEntityToDto(sysPaginaPerfil, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(SysPaginaPerfilDTO objectDTO, SysPaginaPerfil objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPgPrf", "sysPagina", "sysPerfil", "idSysPagina",
				"idSysPerfil");
		if (objectDTO.getIdSysPagina() != null) {
			SysPagina sysPagina = this.sysPaginaRepository.findById(objectDTO.getIdSysPagina()).orElse(null);
			objectEntity.setSysPagina(sysPagina);
		}
		if (objectDTO.getIdSysPerfil() != null) {
			SysPerfil sysPerfil = this.sysPerfilRepository.findById(objectDTO.getIdSysPerfil()).orElse(null);
			objectEntity.setSysPerfil(sysPerfil);
		}
	}

	@Override
	public SysPaginaPerfilDTO convertirEntityToDto(SysPaginaPerfil objectEntity, boolean loadOneR,
			boolean loadAllList) {
		SysPaginaPerfilDTO objectDTO = new SysPaginaPerfilDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "sysPagina", "sysPerfil");
		if (loadOneR) {
			if (objectEntity.getSysPagina() != null) {
				objectDTO.setSysPagina(
						this.sysPaginaService.convertirEntityToDto(objectEntity.getSysPagina(), false, false));
				objectDTO.setIdSysPagina(objectEntity.getSysPagina().getIdPag());
			}
			if (objectEntity.getSysPerfil() != null) {
				objectDTO.setSysPerfil(
						this.sysPerfilService.convertirEntityToDto(objectEntity.getSysPerfil(), false, false));
				objectDTO.setIdSysPerfil(objectEntity.getSysPerfil().getIdPrf());
			}
		}
		return objectDTO;
	}

}
