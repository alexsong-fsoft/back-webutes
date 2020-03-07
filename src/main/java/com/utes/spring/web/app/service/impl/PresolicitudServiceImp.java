package com.utes.spring.web.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.utes.spring.web.app.EstaticosConfig;
import com.utes.spring.web.app.dto.EstadoDTO;
import com.utes.spring.web.app.dto.InscripcionDTO;
import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.dto.PresolicitudDTO;
import com.utes.spring.web.app.dto.TipoDTO;
import com.utes.spring.web.app.entity.Inscripcion;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Presolicitud;
import com.utes.spring.web.app.entity.Respuesta;
import com.utes.spring.web.app.repository.InscripcionRepository;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.PresolicitudRepository;
import com.utes.spring.web.app.service.InscripcionService;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.PresolicitudService;
import com.utes.spring.web.app.service.RespuestaService;

@Service("PresolicitudService")
public class PresolicitudServiceImp implements PresolicitudService {

	@Autowired
	private PresolicitudRepository presolicitudRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private InscripcionRepository inscripcionRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private InscripcionService inscripcionService;
	@Autowired
	private RespuestaService respuestaService;
	@Autowired
	EstaticosConfig estaticos;
	private List<EstadoDTO> listEstadoInscripcion;
	private List<TipoDTO> listTipoDocumento;

	@Override
	@Transactional
	public boolean create(PresolicitudDTO obj) {
		boolean success = false;
		try {
			Presolicitud presolicitudBD = new Presolicitud();
			this.convertirDtoToEntity(obj, presolicitudBD);
			this.presolicitudRepository.save(presolicitudBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(PresolicitudDTO obj) {
		boolean success = false;
		try {
			Presolicitud presolicitudBD = this.presolicitudRepository.findById(obj.getIdPsl()).orElse(null);
			if (presolicitudBD != null) {
				this.convertirDtoToEntity(obj, presolicitudBD);
				this.presolicitudRepository.save(presolicitudBD);
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
			Presolicitud presolicitudBD = this.presolicitudRepository.findById(id).orElse(null);
			if (presolicitudBD != null) {
				this.presolicitudRepository.delete(presolicitudBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitud() {
		Sort sort = new Sort(Direction.DESC, "pslFecha");
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository.findAll(sort);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<PresolicitudDTO> obtenerListadoPresolicitudPageable() {
		int page = 0;
		try {
			page = Integer.parseInt(
					(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())
							.getHeader("Page"));
		} catch (final Exception e) {

		}
		Pageable pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC, "pslFecha"));

		Sort sort = new Sort(Direction.DESC, "pslFecha");
		final Page<Presolicitud> listPresolicitudsBD = this.presolicitudRepository.findAll(pageable);
		final Page<PresolicitudDTO> resultado = listPresolicitudsBD.map(this::convertirEntityToDtoForPage);
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudPorCedula(PersonaDTO objpersona) {
		Sort sort = new Sort(Direction.DESC, "idPsl");
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPersonaPerCedula(objpersona.getPerCedula(), sort);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public PresolicitudDTO obtenerPresolicitudPorCedula(PersonaDTO objpersona, Integer idinscipcion) {
		Sort sort = new Sort(Direction.DESC, "idPsl");
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPersonaPerCedulaAndInscripcionIdIns(objpersona.getPerCedula(), idinscipcion, sort);
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			return this.convertirEntityToDto(listPresolicitudsBD.get(0), true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public PresolicitudDTO obtenerPresolicitudPorId(Integer id) {
		Presolicitud presolicitudBD = this.presolicitudRepository.findById(id).orElse(null);
		if (presolicitudBD != null) {
			return this.convertirEntityToDto(presolicitudBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerPresolicitudPorEstado(Integer idestado) {
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository.findByPslIdEstado(idestado);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudPorEstado2(Integer idestado) {
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository.findByPslIdEstado(idestado);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudPorIdsPersona(String ids) {
		List<Integer> list = new ArrayList<>();
		String[] s = ids.split(",");
		if (!ids.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository.findByPersonaIdPerIn(list);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudPorCedulaId(PersonaDTO objpersona,
			InscripcionDTO objinscripcion) {
		Sort sort = new Sort(Direction.DESC, "idPsl");
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPersonaPerCedulaAndInscripcionIdIns(objpersona.getPerCedula(), objinscripcion.getIdIns(), sort);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public PresolicitudDTO obtenerPresolicitudPorPersonaId(Integer idper, Integer idinscripcion) {
		Sort sort = new Sort(Direction.DESC, "idPsl");
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPersonaIdPerAndInscripcionIdIns(idper, idinscripcion, sort);
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			return this.convertirEntityToDto(listPresolicitudsBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public PresolicitudDTO obtenerListadoPresolicitudPorId(Integer idpresolicitud) {
		Presolicitud presolicitud = this.presolicitudRepository.findById(idpresolicitud).orElse(null);
		if (presolicitud != null) {
			return this.convertirEntityToDto(presolicitud, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudConsulta(Integer idins, Integer idopc, Integer idestado,
			Date fini, Date ffin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public PresolicitudDTO obtenerPresolicitudPorPersonaIdInscripcion(Integer idper, Integer idinscrip) {
		Sort sort = new Sort(Direction.DESC, "idPsl");
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPersonaIdPerAndInscripcionIdIns(idper, idinscrip, sort);
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			return this.convertirEntityToDto(listPresolicitudsBD.get(0), true, false);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Integer obtenerIdPresolicidutxUltimoRegistrado(Integer idpersona) {
		return this.obtenerIdPresolicidutxUltimoRegistrado(idpersona);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudbyOpcionEstado(Integer idopcion, String idestados) {
		List<Integer> list = new ArrayList<>();
		String[] s = idestados.split(",");
		if (!idestados.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPslIdOpcionAndPslIdEstadoIn(idopcion, list);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<PresolicitudDTO> obtenerListadoPresolicitudPorEstados(String opciones, String idestados) {
		List<Integer> listopciones = new ArrayList<>();
		String[] s2 = opciones.split(",");
		if (!opciones.isEmpty()) {
			for (int index = 0; index < s2.length; index++) {
				listopciones.add(Integer.parseInt(s2[index]));
			}
		}
		List<Integer> list = new ArrayList<>();
		String[] s = idestados.split(",");
		if (!idestados.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		final List<Presolicitud> listPresolicitudsBD = this.presolicitudRepository
				.findByPslIdOpcionInAndPslIdEstadoIn(listopciones, list);
		final List<PresolicitudDTO> resultado = new ArrayList<PresolicitudDTO>();
		if (listPresolicitudsBD != null && !listPresolicitudsBD.isEmpty()) {
			for (final Presolicitud presolicitud : listPresolicitudsBD) {
				resultado.add(this.convertirEntityToDto(presolicitud, true, false));
			}
		}
		return resultado;
	}

	@Override
	public void convertirDtoToEntity(PresolicitudDTO objectDTO, Presolicitud objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idPsl", "persona", "inscripcion", "respuestas", "idPersona",
				"idInscripcion");
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
		if (objectDTO.getIdInscripcion() != null) {
			Inscripcion inscripcion = this.inscripcionRepository.findById(objectDTO.getIdInscripcion()).orElse(null);
			objectEntity.setInscripcion(inscripcion);
		}

	}

	@Override
	public PresolicitudDTO convertirEntityToDto(Presolicitud objectEntity, boolean loadOneR, boolean loadAllList) {
		this.initListEstados();
		PresolicitudDTO objectDTO = new PresolicitudDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "persona", "inscripcion", "respuestas");
		objectDTO.setNombreEstado(
				EstadoDTO.getNombreEstadoPorLista(objectEntity.getPslIdEstado(), this.listEstadoInscripcion));
		objectDTO.setNombreTipo(TipoDTO.getNombreTipoPorLista(objectEntity.getPslIdOpcion(), this.listTipoDocumento));
		if (loadOneR) {
			if (objectEntity.getPersona() != null) {
				objectDTO.setPersona(this.personaService.convertirEntityToDto(objectEntity.getPersona(), false, false));
				objectDTO.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getInscripcion() != null) {
				objectDTO.setInscripcion(
						this.inscripcionService.convertirEntityToDto(objectEntity.getInscripcion(), false, false));
				objectDTO.setIdInscripcion(objectEntity.getInscripcion().getIdIns());
			}
		}
		if (loadAllList) {
			if (objectEntity.getRespuestas() != null && !objectEntity.getRespuestas().isEmpty()) {
				for (Respuesta respuesta : objectEntity.getRespuestas()) {
					objectDTO.getRespuestas().add(this.respuestaService.convertirEntityToDto(respuesta, false, false));
				}
			}
		}
		return objectDTO;
	}

	public void initListEstados() {
		if (this.listEstadoInscripcion == null || this.listEstadoInscripcion.isEmpty()) {
			this.listEstadoInscripcion = new ArrayList<>();
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_ENVIADO(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_ENVIADO(),
					this.estaticos.getESTADO_FASE_PRESOLICITUD()));
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_APROBADO(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_APROBADO(),
					this.estaticos.getESTADO_FASE_PRESOLICITUD()));
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_ENLISTAESPERA(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_LISTAESPERA(),
					this.estaticos.getESTADO_FASE_PRESOLICITUD()));
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_NEGADO(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_NEGADO(),
					this.estaticos.getESTADO_FASE_PRESOLICITUD()));
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_PREREVISADO(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_REVISIONPREVIA(),
					this.estaticos.getESTADO_FASE_PRESOLICITUD()));
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_FALTA(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_FALTA(), this.estaticos.getESTADO_FASE_PRESOLICITUD()));
			this.listEstadoInscripcion.add(new EstadoDTO(this.estaticos.getESTADO_PRESOLICITUD_RENUNCIA(),
					this.estaticos.getESTADO_LABEL_PRESOLICITUD_RENUNCIA(),
					this.estaticos.getESTADO_FASE_PRESOLICITUD()));
		}
		if (this.listTipoDocumento == null || this.listTipoDocumento.isEmpty()) {
			this.listTipoDocumento = new ArrayList<>();
			this.listTipoDocumento.add(new TipoDTO(this.estaticos.getTIPO_ID_OPCIONTITULACION_PROYECTO(),
					this.estaticos.getTIPO_LABEL_TITULACION_PROYECTO()));
			this.listTipoDocumento.add(new TipoDTO(this.estaticos.getTIPO_ID_OPCIONTITULACION_ARTICULO(),
					this.estaticos.getTIPO_LABEL_TITULACION_ARTICULO()));
			this.listTipoDocumento.add(new TipoDTO(this.estaticos.getTIPO_ID_OPCIONTITULACION_EXAMEN(),
					this.estaticos.getTIPO_LABEL_TITULACION_EXAMEN()));
		}
	}

	private PresolicitudDTO convertirEntityToDtoForPage(Presolicitud objectEntity) {
		return this.convertirEntityToDto(objectEntity, true, false);
	}
}
