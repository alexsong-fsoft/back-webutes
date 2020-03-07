package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.ConvocatoriaDTO;
import com.utes.spring.web.app.entity.Convocatoria;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.repository.ConvocatoriaRepository;
import com.utes.spring.web.app.service.ConvocatoriaService;
import com.utes.spring.web.app.service.TemaService;

@Service("ConvocatoriaService")
public class ConvocatoriaServiceImp implements ConvocatoriaService {

	@Autowired
	private ConvocatoriaRepository convocatoriaRepository;
	@Autowired
	private TemaService temaService;

	@Override
	@Transactional
	public boolean create(ConvocatoriaDTO obj) {
		boolean success = false;
		try {
			Convocatoria convocatoriaBD = new Convocatoria();
			this.convertirDtoToEntity(obj, convocatoriaBD);
			this.convocatoriaRepository.save(convocatoriaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(ConvocatoriaDTO obj) {
		boolean success = false;
		try {
			Convocatoria convocatoriaBD = this.convocatoriaRepository.findById(obj.getIdCon()).orElse(null);
			if (convocatoriaBD != null) {
				this.convertirDtoToEntity(obj, convocatoriaBD);
				this.convocatoriaRepository.save(convocatoriaBD);
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
			Convocatoria convocatoriaBD = this.convocatoriaRepository.findById(id).orElse(null);
			if (convocatoriaBD != null) {
				this.convocatoriaRepository.delete(convocatoriaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConvocatoriaDTO> obtenerListadoConvocatoria() {
		final List<Convocatoria> listConvocatoriasBD = this.convocatoriaRepository.findAll();
		final List<ConvocatoriaDTO> resultado = new ArrayList<ConvocatoriaDTO>();
		if (listConvocatoriasBD != null && !listConvocatoriasBD.isEmpty()) {
			for (final Convocatoria convocatoria : listConvocatoriasBD) {
				resultado.add(this.convertirEntityToDto(convocatoria, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerConvocatoriaSecuencia() {
		return this.convocatoriaRepository.obtenerSecuencialConvocatoria();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerUltimoRegistroConvocatoria() {
		return this.convocatoriaRepository.obtenerUltimoRegistroConvocatoria();
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerSecuencialConvocatoria() {
		return this.convocatoriaRepository.obtenerSecuencialConvocatoria();
	}

	@Override
	@Transactional(readOnly = true)
	public List<ConvocatoriaDTO> obtenerListadoConvocatoriaPorActivo(boolean conactivo) {
		final List<Convocatoria> listConvocatoriasBD = this.convocatoriaRepository.findByConActivo(conactivo);
		final List<ConvocatoriaDTO> resultado = new ArrayList<ConvocatoriaDTO>();
		if (listConvocatoriasBD != null && !listConvocatoriasBD.isEmpty()) {
			for (final Convocatoria convocatoria : listConvocatoriasBD) {
				resultado.add(this.convertirEntityToDto(convocatoria, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public ConvocatoriaDTO obtenerConvocatoriaPorId(Integer id) {
		Convocatoria convocatoriaBD = this.convocatoriaRepository.findById(id).orElse(null);
		if (convocatoriaBD != null) {
			return this.convertirEntityToDto(convocatoriaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ConvocatoriaDTO obtenerConvocatoriaPorIdActivo(Integer id, boolean estado) {
		Convocatoria convocatoriaBD = this.convocatoriaRepository.findByIdConAndConActivo(id, estado);
		if (convocatoriaBD != null) {
			return this.convertirEntityToDto(convocatoriaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ConvocatoriaDTO obtenerConvocatoriaPorIdPeriodo(Integer conPeriodo) {
		Convocatoria convocatoriaBD = this.convocatoriaRepository.findByConPeriodo(conPeriodo);
		if (convocatoriaBD != null) {
			return this.convertirEntityToDto(convocatoriaBD, true, true);
		}
		return null;
	}

	@Override
	public void convertirDtoToEntity(ConvocatoriaDTO objectDTO, Convocatoria objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idCon", "temas");
	}

	@Override
	public ConvocatoriaDTO convertirEntityToDto(Convocatoria objectEntity, boolean loadOneR, boolean loadAllList) {
		ConvocatoriaDTO objectDTO = new ConvocatoriaDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "temas");
		if (loadAllList) {
			if (objectEntity.getTemas() != null && !objectEntity.getTemas().isEmpty()) {
				for (Tema tema : objectEntity.getTemas()) {
					objectDTO.getTemas().add(temaService.convertirEntityToDto(tema, false, false));
				}
			}
		}
		return objectDTO;
	}

}
