package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.SysPropiedadesDTO;
import com.utes.spring.web.app.entity.SysPropiedades;
import com.utes.spring.web.app.repository.SysPropiedadesRepository;
import com.utes.spring.web.app.service.SysPropiedadesService;

@Service("SysPropiedadesService")
public class SysPropiedadesServiceImp implements SysPropiedadesService {

	@Autowired
	private SysPropiedadesRepository sysPropiedadesRepository;

	@Override
	@Transactional
	public boolean create(SysPropiedadesDTO obj) {
		boolean success = false;
		try {
			SysPropiedades sysPropiedadesBD = new SysPropiedades();
			this.convertirDtoToEntity(obj, sysPropiedadesBD);
			this.sysPropiedadesRepository.save(sysPropiedadesBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(SysPropiedadesDTO obj) {
		boolean success = false;
		try {
			SysPropiedades sysPropiedadesBD = this.sysPropiedadesRepository.findById(obj.getIdProp()).orElse(null);
			if (sysPropiedadesBD != null) {
				this.convertirDtoToEntity(obj, sysPropiedadesBD);
				this.sysPropiedadesRepository.save(sysPropiedadesBD);
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
			SysPropiedades sysPropiedadesBD = this.sysPropiedadesRepository.findById(id).orElse(null);
			if (sysPropiedadesBD != null) {
				this.sysPropiedadesRepository.delete(sysPropiedadesBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<SysPropiedadesDTO> obtenerPropiedades() {
		final List<SysPropiedades> listSysPropiedadessBD = this.sysPropiedadesRepository.findAll();
		final List<SysPropiedadesDTO> resultado = new ArrayList<SysPropiedadesDTO>();
		if (listSysPropiedadessBD != null && !listSysPropiedadessBD.isEmpty()) {
			for (final SysPropiedades sysPropiedades : listSysPropiedadessBD) {
				resultado.add(this.convertirEntityToDto(sysPropiedades, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPropiedadesDTO obtenerPropiedadesbyPk(Integer id) {
		SysPropiedades sysPropiedadesBD = this.sysPropiedadesRepository.findById(id).orElse(null);
		if (sysPropiedadesBD != null) {
			return this.convertirEntityToDto(sysPropiedadesBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public SysPropiedadesDTO obtenerPropiedad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertirDtoToEntity(SysPropiedadesDTO objectDTO, SysPropiedades objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idProp");

	}

	@Override
	public SysPropiedadesDTO convertirEntityToDto(SysPropiedades objectEntity, boolean loadOneR, boolean loadAllList) {
		SysPropiedadesDTO objectDTO = new SysPropiedadesDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO);
		return objectDTO;
	}

}
