package com.utes.spring.web.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.TemaDTO;
import com.utes.spring.web.app.entity.Tema;

@Service
public interface TemaService extends IParsable<TemaDTO, Tema> {

	public boolean create(TemaDTO obj);

	public boolean update(TemaDTO obj);

	public boolean delete(Integer id);

	public List<TemaDTO> obtenerTemas();

	public List<TemaDTO> obtenerTemasExceptoEstado(String codigos);

	public List<TemaDTO> obtenerTemasEstados(String codigos);

	public Page<TemaDTO> obtenerTemasEstadosPageable(String codigos);

	public List<TemaDTO> obtenerTemasxUsuarioEstado(String nameuser, Integer idestado);

	public List<TemaDTO> obtenerTemasxUsuario(String nameuser);

	public List<TemaDTO> obtenerTemasxEstado(Integer idestado);

	public TemaDTO obtenerTema(TemaDTO auxobj);

	public List<TemaDTO> obtenerTemasxConvocatoria(Integer fkconv);

	public TemaDTO obtenerTemasxId(Integer pktema);

	public List<TemaDTO> obtenerTemasxUsuarioEstado(String nameuser, String estados);

	public TemaDTO obtenerTemaxNombre(String nombretema);

	public List<TemaDTO> obtenerTemasxPk(Integer idtem);

	public List<TemaDTO> obtenerTemasxIdstemas(String codigos);

	public List<TemaDTO> obtenerTemasxIdstemasEstados(String codigos, String estados);

	public Page<TemaDTO> obtenerTemasxIdstemasEstadosPageable(String codigos, String estados);

	public List<TemaDTO> obtenerTemasPorIdExceptoActual(Integer idtem);

	public List<TemaDTO> obtenerConsultaTemas(String parametro);

	public List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(String nameuser, String estados,
			Integer idconvocatoria);

	public List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(String nameuser, String estados, Integer idconvocatoria,
			Date fini, Date ffin);

	public List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(String nameuser, String estados,
			Integer idconvocatoriaInicio, Integer idconvocatoriaFinal, Date fini, Date ffin, String campofecha);

	public List<TemaDTO> obtenerTemasxUsuarioEstado(String nameuser, String estados, String idperiodo);

	public List<TemaDTO> obtenerTemasxUsuarioConvocatoria(String nameuser, String idconvocatoria, Date ffin);

}
