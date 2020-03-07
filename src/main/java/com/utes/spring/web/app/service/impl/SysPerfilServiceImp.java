package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.entity.SysPaginaPerfil;
import com.utes.spring.web.app.entity.SysPerfil;
import com.utes.spring.web.app.entity.SysPermiso;
import com.utes.spring.web.app.entity.SysUsuario;
import com.utes.spring.web.app.repository.SysPerfilRepository;
import com.utes.spring.web.app.service.SysPaginaPerfilService;
import com.utes.spring.web.app.service.SysPerfilService;
import com.utes.spring.web.app.service.SysPermisoService;
import com.utes.spring.web.app.service.SysUsuarioService;

@Service("SysPerfilService")
public class SysPerfilServiceImp implements SysPerfilService {

	@Autowired
	private SysPerfilRepository sysPerfilRepository;
	@Autowired
	private SysPaginaPerfilService sysPaginaPerfilService;
	@Autowired
	private SysPermisoService sysPermisoService;
	@Autowired
	private SysUsuarioService sysUsuarioService;

	@Override
	@Transactional
	public boolean create(SysPerfilDTO obj) {
		boolean success = false;
		try {
			SysPerfil sysPerfilBD = new SysPerfil();
			this.convertirDtoToEntity(obj, sysPerfilBD);
			this.sysPerfilRepository.save(sysPerfilBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysPerfilDTO obj) {
		boolean success = false;
		try {
			SysPerfil sysPerfilBD = this.sysPerfilRepository.findById(obj.getIdPrf()).orElse(null);
			if (sysPerfilBD != null) {
				this.convertirDtoToEntity(obj, sysPerfilBD);
				this.sysPerfilRepository.save(sysPerfilBD);
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
			SysPerfil sysPerfilBD = this.sysPerfilRepository.findById(id).orElse(null);
			if (sysPerfilBD != null) {
				this.sysPerfilRepository.delete(sysPerfilBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPerfilDTO> obtenerListadoPerfil() {
		Sort sort = new Sort(Direction.ASC, "prfNombre");
		final List<SysPerfil> listSysPerfilsBD = this.sysPerfilRepository.findAll(sort);
		final List<SysPerfilDTO> resultado = new ArrayList<SysPerfilDTO>();
		if (listSysPerfilsBD != null && !listSysPerfilsBD.isEmpty()) {
			for (final SysPerfil sysPerfil : listSysPerfilsBD) {
				resultado.add(this.convertirEntityToDto(sysPerfil, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPerfilDTO> obtenerListadoPerfilPorNombreUsuario(String nombreusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPerfilDTO obtenerPerfilPorNombreUsuario(String nombreusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPerfilDTO obtenerPerfilPorId(Integer id) {
		SysPerfil sysPerfilBD = this.sysPerfilRepository.findById(id).orElse(null);
		if (sysPerfilBD != null) {
			return this.convertirEntityToDto(sysPerfilBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPerfilDTO> obtenerListadoPerfilPorNombreUsuario2(String nombreusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPerfilDTO obtenerPerfilPorNombre(String nombreperfil) {
		SysPerfil sysPerfilBD = this.sysPerfilRepository.findByPrfNombre(nombreperfil);
		if (sysPerfilBD != null) {
			return this.convertirEntityToDto(sysPerfilBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(SysPerfilDTO objectDTO, SysPerfil objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPrf", "sysPaginaPerfiles", "sysPermisos", "sysUsuarios");
	}

	@Override
	public SysPerfilDTO convertirEntityToDto(SysPerfil objectEntity, boolean loadOneR, boolean loadAllList) {
		SysPerfilDTO objectDTO = new SysPerfilDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "sysPaginaPerfiles", "sysPermisos", "sysUsuarios");
		if (loadAllList) {
			if (objectEntity.getSysPaginaPerfiles() != null && !objectEntity.getSysPaginaPerfiles().isEmpty()) {
				for (SysPaginaPerfil sysPaginaPerfil : objectEntity.getSysPaginaPerfiles()) {
					objectDTO.getSysPaginaPerfiles()
							.add(this.sysPaginaPerfilService.convertirEntityToDto(sysPaginaPerfil, false, false));
				}
			}
			if (objectEntity.getSysPermisos() != null && !objectEntity.getSysPermisos().isEmpty()) {
				for (SysPermiso sysPermiso : objectEntity.getSysPermisos()) {
					objectDTO.getSysPermisos()
							.add(this.sysPermisoService.convertirEntityToDto(sysPermiso, false, false));
				}
			}
			if (objectEntity.getSysUsuarios() != null && !objectEntity.getSysUsuarios().isEmpty()) {
				for (SysUsuario sysUsuario : objectEntity.getSysUsuarios()) {
					objectDTO.getSysUsuarios()
							.add(this.sysUsuarioService.convertirEntityToDto(sysUsuario, false, false));
				}
			}
		}
		return objectDTO;
	}

}
