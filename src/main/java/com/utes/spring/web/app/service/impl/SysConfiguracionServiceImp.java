package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SysConfiguracionDTO;
import com.utes.spring.web.app.entity.SysConfiguracion;
import com.utes.spring.web.app.repository.SysConfiguracionRepository;
import com.utes.spring.web.app.service.SysConfiguracionService;

@Service("SysConfiguracionService")
public class SysConfiguracionServiceImp implements SysConfiguracionService {

	@Autowired
	private SysConfiguracionRepository sysConfiguracionRepository;

	@Override
	@Transactional
	public boolean create(SysConfiguracionDTO obj) {
		boolean success = false;
		try {
			SysConfiguracion sysConfiguracionBD = new SysConfiguracion();
			this.convertirDtoToEntity(obj, sysConfiguracionBD);
			this.sysConfiguracionRepository.save(sysConfiguracionBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysConfiguracionDTO obj) {
		boolean success = false;
		try {
			SysConfiguracion sysConfiguracionBD = this.sysConfiguracionRepository.findById(obj.getPkConf())
					.orElse(null);
			if (sysConfiguracionBD != null) {
				this.convertirDtoToEntity(obj, sysConfiguracionBD);
				this.sysConfiguracionRepository.save(sysConfiguracionBD);
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
			SysConfiguracion sysConfiguracionBD = this.sysConfiguracionRepository.findById(id).orElse(null);
			if (sysConfiguracionBD != null) {
				this.sysConfiguracionRepository.delete(sysConfiguracionBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysConfiguracionDTO> obtenerListadoSysConfiguracion(boolean activo) {
		final List<SysConfiguracion> listSysConfiguracionsBD = this.sysConfiguracionRepository.findByConfActivo(activo);
		final List<SysConfiguracionDTO> resultado = new ArrayList<SysConfiguracionDTO>();
		if (listSysConfiguracionsBD != null && !listSysConfiguracionsBD.isEmpty()) {
			for (final SysConfiguracion sysConfiguracion : listSysConfiguracionsBD) {
				resultado.add(this.convertirEntityToDto(sysConfiguracion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysConfiguracionDTO obtenerConfiguracionbyPk(Integer id) {
		SysConfiguracion sysConfiguracionBD = this.sysConfiguracionRepository.findById(id).orElse(null);
		if (sysConfiguracionBD != null) {
			return this.convertirEntityToDto(sysConfiguracionBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysConfiguracionDTO obtenerConfiguracionbyCampo(String campo) {
		SysConfiguracion sysConfiguracionBD = this.sysConfiguracionRepository.findByConfCampo(campo);
		if (sysConfiguracionBD != null) {
			return this.convertirEntityToDto(sysConfiguracionBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysConfiguracionDTO> obtenerConfiguracionbyTipo(String tipo) {
		Sort sort = new Sort(Direction.ASC, "confCampo");
		final List<SysConfiguracion> listSysConfiguracionsBD = this.sysConfiguracionRepository.findByConfTipo(tipo,
				sort);
		final List<SysConfiguracionDTO> resultado = new ArrayList<SysConfiguracionDTO>();
		if (listSysConfiguracionsBD != null && !listSysConfiguracionsBD.isEmpty()) {
			for (final SysConfiguracion sysConfiguracion : listSysConfiguracionsBD) {
				resultado.add(this.convertirEntityToDto(sysConfiguracion, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean activaProcesoByCampo(String campo) {
		boolean retorno = false;
		SysConfiguracionDTO objaux = this.obtenerConfiguracionbyCampo(campo);
		if (objaux != null) {
			retorno = Boolean.parseBoolean(objaux.getConfValor());
		}
		return retorno;
	}

	@Override
	public void convertirDtoToEntity(SysConfiguracionDTO objectDTO, SysConfiguracion objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "pkConf");

	}

	@Override
	public SysConfiguracionDTO convertirEntityToDto(SysConfiguracion objectEntity, boolean loadOneR,
			boolean loadAllList) {
		SysConfiguracionDTO objectDTO = new SysConfiguracionDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO);
		return objectDTO;
	}

}
