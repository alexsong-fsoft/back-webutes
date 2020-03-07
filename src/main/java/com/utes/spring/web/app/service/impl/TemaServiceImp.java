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
import com.utes.spring.web.app.dto.TemaDTO;
import com.utes.spring.web.app.dto.TipoDTO;
import com.utes.spring.web.app.entity.Asignado;
import com.utes.spring.web.app.entity.Convocatoria;
import com.utes.spring.web.app.entity.Evolucion;
import com.utes.spring.web.app.entity.Hito;
import com.utes.spring.web.app.entity.Informe;
import com.utes.spring.web.app.entity.Persona;
import com.utes.spring.web.app.entity.Resolucion;
import com.utes.spring.web.app.entity.Tema;
import com.utes.spring.web.app.projection.TemaProjection;
import com.utes.spring.web.app.repository.ConvocatoriaRepository;
import com.utes.spring.web.app.repository.PersonaRepository;
import com.utes.spring.web.app.repository.TemaRepository;
import com.utes.spring.web.app.service.AsignadoService;
import com.utes.spring.web.app.service.ConvocatoriaService;
import com.utes.spring.web.app.service.EvolucionService;
import com.utes.spring.web.app.service.HitoService;
import com.utes.spring.web.app.service.InformeService;
import com.utes.spring.web.app.service.PersonaService;
import com.utes.spring.web.app.service.ResolucionService;
import com.utes.spring.web.app.service.TemaService;

@Service("TemaService")
public class TemaServiceImp implements TemaService {

	@Autowired
	private TemaRepository temaRepository;
	@Autowired
	private PersonaRepository personaRepository;
	@Autowired
	private ConvocatoriaRepository convocatoriaRepository;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ConvocatoriaService convocatoriaService;
	@Autowired
	private AsignadoService asignadoService;
	@Autowired
	private InformeService informeService;
	@Autowired
	private EvolucionService evolucionService;
	@Autowired
	private HitoService hitoService;
	@Autowired
	private ResolucionService resolucionService;
	@Autowired
	EstaticosConfig estaticos;
	private List<EstadoDTO> listEstadoPreTema;
	private List<TipoDTO> listTipoDocumento;

	@Override
	@Transactional
	public boolean create(TemaDTO obj) {
		boolean success = false;
		try {
			Tema temaBD = new Tema();
			this.convertirDtoToEntity(obj, temaBD);
			this.temaRepository.save(temaBD);
			success = true;
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional
	public boolean update(TemaDTO obj) {
		boolean success = false;
		try {
			Tema temaBD = this.temaRepository.findById(obj.getIdTem()).orElse(null);
			if (temaBD != null) {
				this.convertirDtoToEntity(obj, temaBD);
				this.temaRepository.save(temaBD);
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
			Tema temaBD = this.temaRepository.findById(id).orElse(null);
			if (temaBD != null) {
				this.temaRepository.delete(temaBD);
				success = true;
			}
		} catch (final Exception e) {
			success = false;
		}
		return success;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemas() {
		final List<Tema> listTemasBD = this.temaRepository.findAll();
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasExceptoEstado(String codigos) {
		List<Integer> list = new ArrayList<>();
		String[] s = codigos.split(",");
		if (!codigos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		Sort sort = new Sort(Direction.DESC, "idTem");
		final List<Tema> listTemasBD = this.temaRepository.findByTemIdEstadoNotIn(list, sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasEstados(String codigos) {
		List<Integer> list = new ArrayList<>();
		String[] s = codigos.split(",");
		if (!codigos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		Sort sort = new Sort(Direction.DESC, "temFechaEditado");
		final List<Tema> listTemasBD = this.temaRepository.findByTemIdEstadoIn(list, sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TemaDTO> obtenerTemasEstadosPageable(String codigos) {
		int page = 0;
		try {
			page = Integer.parseInt(
					(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())
							.getHeader("Page"));
		} catch (final Exception e) {

		}
		List<Integer> list = new ArrayList<>();
		String[] s = codigos.split(",");
		if (!codigos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		Pageable pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC, "temFechaEditado"));
		final Page<Tema> listTemasBD = this.temaRepository.findByTemIdEstadoIn(list, pageable);
		final Page<TemaDTO> resultado = listTemasBD.map(this::convertirEntityToDtoForPage);
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxUsuarioEstado(String nameuser, Integer idestado) {
		final List<Tema> listTemasBD = this.temaRepository.findByUsuarioEstado(idestado, nameuser);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxUsuario(String nameuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxEstado(Integer idestado) {
		Sort sort = new Sort(Direction.DESC, "idTem");
		final List<Tema> listTemasBD = this.temaRepository.findByTemIdEstado(idestado, sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public TemaDTO obtenerTema(TemaDTO auxobj) {
		Tema temaBD = this.temaRepository.findById(auxobj.getIdTem()).orElse(null);
		if (temaBD != null) {
			return this.convertirEntityToDto(temaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public TemaDTO obtenerTemasxId(Integer pktema) {
		Tema temaBD = this.temaRepository.findById(pktema).orElse(null);
		if (temaBD != null) {
			return this.convertirEntityToDto(temaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxUsuarioEstado(String nameuser, String estados) {
		List<Integer> list = new ArrayList<>();
		String[] s = estados.split(",");
		if (!estados.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		Sort sort = new Sort(Direction.DESC, "temFechaEditado");
		final List<Tema> listTemasBD = this.temaRepository.findByTemIdEstadoInAndPersonaSysUsuarioUsrUsuario(list,
				nameuser, sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public TemaDTO obtenerTemaxNombre(String nombretema) {
		Tema temaBD = this.temaRepository.findByTemNombre(nombretema);
		if (temaBD != null) {
			return this.convertirEntityToDto(temaBD, true, true);
		}
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxPk(Integer idtem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxIdstemas(String codigos) {
		List<Integer> list = new ArrayList<>();
		String[] s = codigos.split(",");
		if (!codigos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				list.add(Integer.parseInt(s[index]));
			}
		}
		Sort sort = new Sort(Direction.DESC, "temFechaEditado");
		final List<Tema> listTemasBD = this.temaRepository.findByIdTemIn(list, sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasxIdstemasEstados(String codigos, String estados) {
		List<Integer> listcodigos = new ArrayList<>();
		String[] s = codigos.split(",");
		if (!codigos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				listcodigos.add(Integer.parseInt(s[index]));
			}
		}
		List<Integer> listestados = new ArrayList<>();
		String[] s2 = estados.split(",");
		if (!estados.isEmpty()) {
			for (int index = 0; index < s2.length; index++) {
				listestados.add(Integer.parseInt(s2[index]));
			}
		}
		Sort sort = new Sort(Direction.DESC, "temFechaEditado");
		final List<Tema> listTemasBD = this.temaRepository.findByIdTemInAndTemIdEstadoIn(listcodigos, listestados,
				sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TemaDTO> obtenerTemasxIdstemasEstadosPageable(String codigos, String estados) {
		int page = 0;
		try {
			page = Integer.parseInt(
					(((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest())
							.getHeader("Page"));
		} catch (final Exception e) {

		}
		List<Integer> listcodigos = new ArrayList<>();
		String[] s = codigos.split(",");
		if (!codigos.isEmpty()) {
			for (int index = 0; index < s.length; index++) {
				listcodigos.add(Integer.parseInt(s[index]));
			}
		}
		List<Integer> listestados = new ArrayList<>();
		String[] s2 = estados.split(",");
		if (!estados.isEmpty()) {
			for (int index = 0; index < s2.length; index++) {
				listestados.add(Integer.parseInt(s2[index]));
			}
		}
		Pageable pageable = PageRequest.of(page, 10, new Sort(Sort.Direction.DESC, "temFechaEditado"));
		final Page<Tema> listTemasBD = this.temaRepository.findByIdTemInAndTemIdEstadoIn(listcodigos, listestados,
				pageable);
		final Page<TemaDTO> resultado = listTemasBD.map(this::convertirEntityToDtoForPage);
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerTemasPorIdExceptoActual(Integer idtem) {
		final List<TemaProjection> listTemasBD = this.temaRepository.findByIdExceptoActual(idtem);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final TemaProjection tema : listTemasBD) {
				resultado.add(this.convertirProjectionToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	@Transactional(readOnly = true)
	public List<TemaDTO> obtenerConsultaTemas(String paramaetro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TemaDTO> obtenerTemasxConvocatoria(Integer fkconv) {
		Sort sort = new Sort(Direction.DESC, "idTem");
		final List<Tema> listTemasBD = this.temaRepository.findByConvocatoriaIdCon(fkconv, sort);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	public List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(String nameuser, String estados,
			Integer idconvocatoria) {
		List<Integer> listestados = new ArrayList<>();
		String[] s2 = estados.split(",");
		if (!estados.isEmpty()) {
			for (int index = 0; index < s2.length; index++) {
				listestados.add(Integer.parseInt(s2[index]));
			}
		}
		final List<Tema> listTemasBD = this.temaRepository
				.findByTemIdEstadoInAndConvocatoriaIdConAndPersonaSysUsuarioUsrUsuario(listestados, idconvocatoria,
						nameuser);
		final List<TemaDTO> resultado = new ArrayList<TemaDTO>();
		if (listTemasBD != null && !listTemasBD.isEmpty()) {
			for (final Tema tema : listTemasBD) {
				resultado.add(this.convertirEntityToDto(tema, true, false));
			}
		}
		return resultado;
	}

	@Override
	public List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(String nameuser, String estados, Integer idconvocatoria,
			Date fini, Date ffin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(String nameuser, String estados,
			Integer idconvocatoriaInicio, Integer idconvocatoriaFinal, Date fini, Date ffin, String campofecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TemaDTO> obtenerTemasxUsuarioEstado(String nameuser, String estados, String idperiodo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TemaDTO> obtenerTemasxUsuarioConvocatoria(String nameuser, String idconvocatoria, Date ffin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void convertirDtoToEntity(TemaDTO objectDTO, Tema objectEntity) {
		BeanUtils.copyProperties(objectDTO, objectEntity, "idTem", "persona", "idPersona", "idConvocatoria",
				"convocatoria", "asignados", "evoluciones", "informes", "hitos", "resoluciones");
		if (objectDTO.getIdPersona() != null) {
			Persona persona = this.personaRepository.findById(objectDTO.getIdPersona()).orElse(null);
			objectEntity.setPersona(persona);
		}
		if (objectDTO.getIdConvocatoria() != null) {
			Convocatoria convocatoria = this.convocatoriaRepository.findById(objectDTO.getIdConvocatoria())
					.orElse(null);
			objectEntity.setConvocatoria(convocatoria);
		}
	}

	@Override
	public TemaDTO convertirEntityToDto(Tema objectEntity, boolean loadOneR, boolean loadAllList) {
		this.initListEstados();
		TemaDTO objectDTO = new TemaDTO();
		BeanUtils.copyProperties(objectEntity, objectDTO, "persona", "convocatoria", "asignados", "evoluciones",
				"informes", "hitos", "resoluciones");
		objectDTO.setNombreEstado(
				EstadoDTO.getNombreEstadoPorLista(objectEntity.getTemIdEstado(), this.listEstadoPreTema));
		objectDTO.setNombreTipo(TipoDTO.getNombreTipoPorLista(objectEntity.getTemIdTipo(), this.listTipoDocumento));
		if (loadOneR) {
			if (objectEntity.getPersona() != null) {
				objectDTO.setPersona(this.personaService.convertirEntityToDto(objectEntity.getPersona(), true, false));
				objectDTO.setIdPersona(objectEntity.getPersona().getIdPer());
			}
			if (objectEntity.getConvocatoria() != null) {
				objectDTO.setConvocatoria(
						this.convocatoriaService.convertirEntityToDto(objectEntity.getConvocatoria(), false, false));
				objectDTO.setIdConvocatoria(objectEntity.getConvocatoria().getIdCon());
			}
		}
		if (loadAllList) {
			boolean loadChildren = loadOneR && loadAllList ? true : false;
			if (objectEntity.getAsignados() != null && !objectEntity.getAsignados().isEmpty()) {
				for (Asignado asignado : objectEntity.getAsignados()) {
					objectDTO.getAsignados().add(asignadoService.convertirEntityToDto(asignado, loadChildren, false));
				}
			}
			if (objectEntity.getEvoluciones() != null && !objectEntity.getEvoluciones().isEmpty()) {
				for (Evolucion evolucion : objectEntity.getEvoluciones()) {
					objectDTO.getEvoluciones()
							.add(evolucionService.convertirEntityToDto(evolucion, loadChildren, false));
				}
			}
			if (objectEntity.getInformes() != null && !objectEntity.getInformes().isEmpty()) {
				for (Informe informe : objectEntity.getInformes()) {
					objectDTO.getInformes().add(informeService.convertirEntityToDto(informe, loadChildren, false));
				}
			}
			if (objectEntity.getHitos() != null && !objectEntity.getHitos().isEmpty()) {
				for (Hito hito : objectEntity.getHitos()) {
					objectDTO.getHitos().add(hitoService.convertirEntityToDto(hito, loadChildren, false));
				}
			}
			if (objectEntity.getResoluciones() != null && !objectEntity.getResoluciones().isEmpty()) {
				for (Resolucion resolucion : objectEntity.getResoluciones()) {
					objectDTO.getResoluciones()
							.add(resolucionService.convertirEntityToDto(resolucion, loadChildren, false));
				}
			}
		}
		return objectDTO;
	}

	public TemaDTO convertirProjectionToDto(TemaProjection objectEntity, boolean loadOneR, boolean loadAllList) {
		this.initListEstados();
		TemaDTO objectDTO = new TemaDTO();
		objectDTO.setIdTem(objectEntity.getIdTem());
		objectDTO.setTemIdTipo(objectEntity.getTemIdTipo());
		objectDTO.setTemIdEstado(objectEntity.getTemIdEstado());
		objectDTO.setTemNombre(objectEntity.getTemNombre());
		objectDTO.setTemDescripcion(objectEntity.getTemDescripcion());
		objectDTO.setTemTema(objectEntity.getTemTema());
		objectDTO.setTemNumEst(objectEntity.getTemNumEst());
		objectDTO.setTemAutorA(objectEntity.getTemAutorA());
		objectDTO.setTemAutorB(objectEntity.getTemAutorB());
		objectDTO.setTemFechaPublicado(objectEntity.getTemFechaPublicado());
		objectDTO.setTemAuspiciante(objectEntity.getTemAuspiciante());
		objectDTO.setTemLectorPlan(objectEntity.getTemLectorPlan());
		objectDTO.setTemLectorProyecto(objectEntity.getTemLectorProyecto());
		objectDTO.setTemActivo(objectEntity.getTemActivo());
		objectDTO.setTemFechaCreado(objectEntity.getTemFechaCreado());
		objectDTO.setTemFechaEditado(objectEntity.getTemFechaEditado());
		objectDTO.setTemPorcAvance(objectEntity.getTemPorcAvance());
		objectDTO.setTemAprobado(objectEntity.getTemAprobado());
		objectDTO.setTemAlcance(objectEntity.getTemAlcance());
		objectDTO.setTemObjetivo(objectEntity.getTemObjetivo());
		objectDTO.setTemFechaEnviado(objectEntity.getTemFechaEnviado());
		objectDTO.setTemNota(objectEntity.getTemNota());
		objectDTO.setTemObservacion(objectEntity.getTemObservacion());
		objectDTO.setTemFechaInicio(objectEntity.getTemFechaInicio());
		objectDTO.setTemFechaEntrega(objectEntity.getTemFechaEntrega());
		objectDTO.setTemIdPeriodo(objectEntity.getTemIdPeriodo());
		objectDTO.setTemFechaResolucion(objectEntity.getTemFechaResolucion());
		objectDTO.setNombreEstado(
				EstadoDTO.getNombreEstadoPorLista(objectEntity.getTemIdEstado(), this.listEstadoPreTema));
		objectDTO.setNombreTipo(TipoDTO.getNombreTipoPorLista(objectEntity.getTemIdTipo(), this.listTipoDocumento));
		if (loadOneR) {
			if (objectEntity.getFkPer() != null) {
				objectDTO.setPersona(this.personaService.obtenerPersonaPorId(objectEntity.getFkPer()));
				objectDTO.setIdPersona(objectEntity.getFkPer());
			}
			if (objectEntity.getFkCon() != null) {
				objectDTO.setConvocatoria(this.convocatoriaService.obtenerConvocatoriaPorId(objectEntity.getFkCon()));
				objectDTO.setIdConvocatoria(objectEntity.getFkCon());
			}
		}
		if (loadAllList) {
			boolean loadChildren = loadOneR && loadAllList ? true : false;
//			if (objectEntity.getAsignados() != null && !objectEntity.getAsignados().isEmpty()) {
//				for (Asignado asignado : objectEntity.getAsignados()) {
//					objectDTO.getAsignados().add(asignadoService.convertirEntityToDto(asignado, loadChildren, false));
//				}
//			}
//			if (objectEntity.getEvoluciones() != null && !objectEntity.getEvoluciones().isEmpty()) {
//				for (Evolucion evolucion : objectEntity.getEvoluciones()) {
//					objectDTO.getEvoluciones()
//							.add(evolucionService.convertirEntityToDto(evolucion, loadChildren, false));
//				}
//			}
//			if (objectEntity.getInformes() != null && !objectEntity.getInformes().isEmpty()) {
//				for (Informe informe : objectEntity.getInformes()) {
//					objectDTO.getInformes().add(informeService.convertirEntityToDto(informe, loadChildren, false));
//				}
//			}
//			if (objectEntity.getHitos() != null && !objectEntity.getHitos().isEmpty()) {
//				for (Hito hito : objectEntity.getHitos()) {
//					objectDTO.getHitos().add(hitoService.convertirEntityToDto(hito, loadChildren, false));
//				}
//			}
//			if (objectEntity.getResoluciones() != null && !objectEntity.getResoluciones().isEmpty()) {
//				for (Resolucion resolucion : objectEntity.getResoluciones()) {
//					objectDTO.getResoluciones()
//							.add(resolucionService.convertirEntityToDto(resolucion, loadChildren, false));
//				}
//			}
		}
		return objectDTO;
	}

	public void initListEstados() {
		if (this.listEstadoPreTema == null || this.listEstadoPreTema.isEmpty()) {
			this.listEstadoPreTema = new ArrayList<>();
			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_CREADO(),
					this.estaticos.getESTADO_LABEL_TEMA_CREADO(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_TERMINALECTOR(),
					this.estaticos.getESTADO_LABEL_TEMA_TERMINALECTOR(),
					this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_ENVIADO(),
					this.estaticos.getESTADO_LABEL_TEMA_ENVIADO(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_ASIGNAREVISOR(),
					this.estaticos.getESTADO_LABEL_TEMA_ASIGNAREVISOR(),
					this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_REVISION(),
					this.estaticos.getESTADO_LABEL_TEMA_ENREVISION(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_REVISADO(),
					this.estaticos.getESTADO_LABEL_TEMA_REVISADO(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_PUBLICADO(),
					this.estaticos.getESTADO_LABEL_TEMA_PUBLICADO(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_ASIGNAESTUDIANTE(),
					this.estaticos.getESTADO_LABEL_TEMA_ASIGNAESTUDIANTE(),
					this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_ASIGNALECTOR(),
					this.estaticos.getESTADO_LABEL_TEMA_ASIGNALECTOR(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_PRE_TERMINALECTOR(),
					this.estaticos.getESTADO_LABEL_TEMA_TERMINALECTOR(),
					this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_APROBADO(),
					this.estaticos.getESTADO_LABEL_TEMA_APROBADO(), this.estaticos.getESTADO_FASE_POSTRESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_CERRADO(),
					this.estaticos.getESTADO_LABEL_TEMA_CERRADO(), this.estaticos.getESTADO_FASE_POSTRESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_ANULADO(),
					this.estaticos.getESTADO_LABEL_TEMA_ANULADO(), this.estaticos.getESTADO_FASE_POSTRESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_PRORROGA(),
					this.estaticos.getESTADO_LABEL_TEMA_PRORROGA(), this.estaticos.getESTADO_FASE_POSTRESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_LECTORPROYECTO(),
					this.estaticos.getESTADO_LABEL_TEMA_LECTORPROYECTO(),
					this.estaticos.getESTADO_FASE_POSTRESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_CAMBIOTUTOR(),
					this.estaticos.getESTADO_LABEL_TEMA_CAMBIOTUTOR(), this.estaticos.getESTADO_FASE_PRERESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_CAMBIOTEMA(),
					this.estaticos.getESTADO_LABEL_TEMA_CAMBIOTEMA(), this.estaticos.getESTADO_FASE_POSTRESOLUCION()));

			this.listEstadoPreTema.add(new EstadoDTO(this.estaticos.getESTADO_TEMA_POST_RENUNCIAESTUDIANTE(),
					this.estaticos.getESTADO_LABEL_TEMA_RENUNCIAESTUDIANTE(),
					this.estaticos.getESTADO_FASE_POSTRESOLUCION()));
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

	private TemaDTO convertirEntityToDtoForPage(Tema objectEntity) {
		return this.convertirEntityToDto(objectEntity, true, false);
	}
}
