package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utes.spring.web.app.dto.AsignadoDTO;
import com.utes.spring.web.app.entity.Asignado;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.repository.AsignadoRepository;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.TemaRepository;
import com.utes.spring.web.app.service.AsignadoService;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.TemaService;

@Service("AsignadoService")
public class AsignadoServiceImp implements AsignadoService {

	@Autowired
	private AsignadoRepository asignadoRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private TemaService temaService;

	@Override
	@Transactional
	public boolean create(AsignadoDTO obj) {
		boolean success = false;
		try {
			Asignado asignadoBD = new Asignado();
			this.convertirDtoToEntity(obj, asignadoBD);
			this.asignadoRepository.save(asignadoBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(AsignadoDTO obj) {
		boolean success = false;
		try {
			Asignado asignadoBD = this.asignadoRepository.findById(obj.getIdAsg()).orElse(null);
			if (asignadoBD != null) {
				this.convertirDtoToEntity(obj, asignadoBD);
				this.asignadoRepository.save(asignadoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean delete(Integer idasig) {
		boolean success = false;
		try {
			Asignado asignadoBD = this.asignadoRepository.findById(idasig).orElse(null);
			if (asignadoBD != null) {
				this.asignadoRepository.delete(asignadoBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerListadoAsignado(boolean activo) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgActivo(activo);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoDTOxTemaPersona(Integer idtema, Integer idpersona) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByPersonaIdPerAndTemaIdTem(idpersona,
				idtema);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoxTemaCedula(String ced) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByPersonaPerCedula(ced);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerEntidadAsignadoxTemaCedula(String ced) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByPersonaPerCedula(ced);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoxTema(Integer idtema) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByTemaIdTem(idtema);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoxTema(Integer idtema, Integer idtipo) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgIdTipoAndAsgActivoAndTemaIdTem(idtipo,
				true, idtema);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerAsignadoxTemaPersonaVerifica(Integer idtema, Integer idpersona) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByPersonaIdPerAndTemaIdTem(idpersona,
				idtema);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoxIdsTema(String idsTema, Integer idtipo) {
		List<Integer> list = new ArrayList<>();
		String[] s = idsTema.split(",");
		if (!idsTema.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgIdTipoAndTemaIdTemIn(idtipo, list);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoxEstado(Integer idtipo) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgIdTipo(idtipo);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerEntidadAsignadoxIdPersona(Integer idpersona, String idtipoasignacion, Integer idtema) {
		List<Integer> list = new ArrayList<>();
		String[] s = idtipoasignacion.split(",");
		if (!idtipoasignacion.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Asignado> listAsignadosBD = this.asignadoRepository
				.findByAsgIdTipoInAndPersonaIdPerAndTemaIdTem(list, idpersona, idtema);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerEntidadAsignadoxIdPersona(Integer idpersona) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgActivoAndPersonaIdPer(true, idpersona);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerEntidadAsignadoxIdPersona(Integer idpersona, Integer idtipoasignacion) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgActivoAndPersonaIdPerAndAsgIdTipo(true,
				idpersona, idtipoasignacion);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerListadoAsignadoxIdPersona(Integer idpersona, Integer idtipoasignacion) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgActivoAndPersonaIdPerAndAsgIdTipo(true,
				idpersona, idtipoasignacion);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerCount(Integer idpersona, Integer idtipo, Integer estadoaccion) {
		return this.asignadoRepository.obtenerCountAsignado(idpersona, idtipo, estadoaccion);
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerAsignadoxTemaPersonaVerificaAsignadoRevisor(Integer idtema, Integer idpersona,
			Integer idestadorev) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository
				.findByAsgIdEstadoTemaAndPersonaIdPerAndTemaIdTem(idestadorev, idpersona, idtema);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerAsignadoxTemaPersonaVerificaAsignadoTipo(Integer idtema, Integer idpersona,
			Integer idtipo, Integer estadorevision) {
		final List<Asignado> listAsignadosBD = this.asignadoRepository
				.findByAsgIdTipoAndAsgIdEstadoTemaAndPersonaIdPerAndTemaIdTem(idtipo, estadorevision, idpersona,
						idtema);
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			return this.convertirEntityToDto(listAsignadosBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerIdAsignadoxTemaUltimoEstado(Integer idtema, Integer idpersona, Integer idtipo) {
		return this.asignadoRepository.obtenerIdAsignadoxTemaUltimoEstado(idpersona, idtema);
	}

	@Override
	@Transactional(readOnly = true)
	public AsignadoDTO obtenerEntidadAsignadoxId(Integer idasignado) {
		Asignado asignadoBD = this.asignadoRepository.findById(idasignado).orElse(null);
		if (asignadoBD != null) {
			return this.convertirEntityToDto(asignadoBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AsignadoDTO> obtenerAsignadoxIdsTipos(String idstema, String idtipoasig) {
		List<Integer> listidstema = new ArrayList<>();
		String[] s = idstema.split(",");
		if (!idstema.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				listidstema.add(Integer.parseInt(s[index]));
			}
		}
		List<Integer> listidtipoasig = new ArrayList<>();
		String[] s2 = idtipoasig.split(",");
		if (!idtipoasig.isEmpty()) {
			for (int index = 0; index < s2.length; index++) {
				listidtipoasig.add(Integer.parseInt(s2[index]));
			}
		}
		final List<Asignado> listAsignadosBD = this.asignadoRepository.findByAsgIdTipoInAndTemaIdTemIn(listidtipoasig,
				listidstema);
		final List<AsignadoDTO> resultado = new ArrayList<AsignadoDTO>();
		if (listAsignadosBD != null && !listAsignadosBD.isEmpty()) {
			for (final Asignado asignado : listAsignadosBD) {
				resultado.add(this.convertirEntityToDto(asignado, true, false));
			}
		}
		return resultado;
	}

//	@Override
//	@Transactional(readOnly = true)
//	public AsignadoDTO obtenerAsignadoxTemaPersonaUpdateEstado(Integer idtema, Integer idtipo, Integer estadorevision) {
//		return null;
//	}

//	@Override
//	@Transactional(readOnly = true)
//	public AsignadoDTO obtenerAsignadoxIdtema(Integer idtema, Integer idtipo) {
//		return null;
//	}

	@Override
	public void convertirDtoToEntity(AsignadoDTO objectDTO, Asignado objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idAsg", "persona", "tema", "idPersona", "idTema");
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
		if (objectDTO.getIdTema() != null) {
			Tema tema = this.temaRepository.findById(objectDTO.getIdTema()).orElse(null);
			objectEntity.setTema(tema);
		}
	}

	@Override
	public AsignadoDTO convertirEntityToDto(Asignado objectEntity, boolean loadOneR, boolean loadAllList) {
		AsignadoDTO objectDto = new AsignadoDTO();
		BeanUtils.copyProperties(objectEntity, objectDto, "persona", "tema");
		if (loadOneR) {
			if (objectEntity.getPersona() != null) {
				objectDto.setPersona(personaService.convertirEntityToDto(objectEntity.getPersona(), false, false));
				objectDto.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getTema() != null) {
				objectDto.setTema(temaService.convertirEntityToDto(objectEntity.getTema(), false, false));
				objectDto.setIdTema(objectEntity.getTema().getIdTem());
			}
		}
		return objectDto;
	}

}