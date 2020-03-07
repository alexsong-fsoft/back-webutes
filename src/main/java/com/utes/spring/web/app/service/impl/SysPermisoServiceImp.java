package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.dto.SysPermisoDTO;
import com.utes.spring.web.app.entity.SysPerfil;
import com.utes.spring.web.app.entity.SysPermiso;
import com.utes.spring.web.app.repository.SysPerfilRepository;
import com.utes.spring.web.app.repository.SysPermisoRepository;
import com.utes.spring.web.app.service.SysPerfilService;
import com.utes.spring.web.app.service.SysPermisoService;

@Service("SysPermisoService")
public class SysPermisoServiceImp implements SysPermisoService {

	@Autowired
	private SysPermisoRepository sysPermisoRepository;
	@Autowired
	private SysPerfilRepository sysPerfilRepository;
	@Autowired
	private SysPerfilService sysPerfilService;

	@Override
	@Transactional
	public boolean create(SysPermisoDTO obj) {
		boolean success = false;
		try {
			SysPermiso sysPermisoBD = new SysPermiso();
			this.convertirDtoToEntity(obj, sysPermisoBD);
			this.sysPermisoRepository.save(sysPermisoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysPermisoDTO obj) {
		boolean success = false;
		try {
			SysPermiso sysPermisoBD = this.sysPermisoRepository.findById(obj.getIdPerm()).orElse(null);
			if (sysPermisoBD != null) {
				this.convertirDtoToEntity(obj, sysPermisoBD);
				this.sysPermisoRepository.save(sysPermisoBD);
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
			SysPermiso sysPermisoBD = this.sysPermisoRepository.findById(id).orElse(null);
			if (sysPermisoBD != null) {
				this.sysPermisoRepository.delete(sysPermisoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPermisoDTO> obtenerListadoSysPermiso(boolean activo) {
		final List<SysPermiso> listSysPermisosBD = this.sysPermisoRepository.findByPermActivo(activo);
		final List<SysPermisoDTO> resultado = new ArrayList<SysPermisoDTO>();
		if (listSysPermisosBD != null && !listSysPermisosBD.isEmpty()) {
			for (final SysPermiso sysPermiso : listSysPermisosBD) {
				resultado.add(this.convertirEntityToDto(sysPermiso, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPermisoDTO obtenerSysPermiso(Integer id) {
		SysPermiso sysPermisoBD = this.sysPermisoRepository.findById(id).orElse(null);
		if (sysPermisoBD != null) {
			return this.convertirEntityToDto(sysPermisoBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPermisoDTO> obtenerListadoPermisoPorNombrePerfil(String nombreperfil) {
		final List<SysPermiso> listSysPermisosBD = this.sysPermisoRepository.findBySysPerfilPrfNombre(nombreperfil);
		final List<SysPermisoDTO> resultado = new ArrayList<SysPermisoDTO>();
		if (listSysPermisosBD != null && !listSysPermisosBD.isEmpty()) {
			for (final SysPermiso sysPermiso : listSysPermisosBD) {
				resultado.add(this.convertirEntityToDto(sysPermiso, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPermisoDTO> obtenerListadoPermisoPorPerfil(SysPerfilDTO objperfil) {
		final List<SysPermiso> listSysPermisosBD = this.sysPermisoRepository.findBySysPerfilIdPrf(objperfil.getIdPrf());
		final List<SysPermisoDTO> resultado = new ArrayList<SysPermisoDTO>();
		if (listSysPermisosBD != null && !listSysPermisosBD.isEmpty()) {
			for (final SysPermiso sysPermiso : listSysPermisosBD) {
				resultado.add(this.convertirEntityToDto(sysPermiso, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPermisoDTO obtenerPermisoPorPerfil(SysPerfilDTO objperfil) {
		final List<SysPermiso> listSysPermisosBD = this.sysPermisoRepository.findBySysPerfilIdPrf(objperfil.getIdPrf());
		if (listSysPermisosBD != null) {
			return this.convertirEntityToDto(listSysPermisosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(SysPermisoDTO objectDTO, SysPermiso objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPerm", "sysPerfil", "idSysPerfil");
		if (objectDTO.getIdSysPerfil() != null) {
			SysPerfil sysPerfil = this.sysPerfilRepository.findById(objectDTO.getIdSysPerfil()).orElse(null);
			objectEntity.setSysPerfil(sysPerfil);
		}

	}

	@Override
	public SysPermisoDTO convertirEntityToDto(SysPermiso objectEntity, boolean loadOneR, boolean loadAllList) {
		SysPermisoDTO objectDTO = new SysPermisoDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "sysPerfil");
		if (loadOneR) {
			if (objectEntity.getSysPerfil() != null) {
				objectDTO.setSysPerfil(
						this.sysPerfilService.convertirEntityToDto(objectEntity.getSysPerfil(), false, false));
				objectDTO.setIdSysPerfil(objectEntity.getSysPerfil().getIdPrf());
			}
		}
		return objectDTO;
	}

}
