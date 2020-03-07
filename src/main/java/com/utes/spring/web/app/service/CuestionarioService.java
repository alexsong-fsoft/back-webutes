package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.CuestionarioDTO;
import com.utes.spring.web.app.entity.Cuestionario;

@Service
public interface CuestionarioService extends IParsable<CuestionarioDTO, Cuestionario> {

	public boolean create(CuestionarioDTO obj);

	public boolean update(CuestionarioDTO obj);

	public boolean delete(Integer id);

	public List<CuestionarioDTO> obtenerListadoCuestionarioPorEstado(boolean estado);

	public CuestionarioDTO obtenerCuestionario(Integer id);

	public List<CuestionarioDTO> obtenerListadoCuestionario();

	public List<CuestionarioDTO> obtenerListadoCuestionarioPorEstadoTipo(boolean estado, String idstipos,
			Integer idinscripcion);

}
