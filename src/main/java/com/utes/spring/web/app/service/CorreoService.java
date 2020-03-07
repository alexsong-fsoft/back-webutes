package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.CorreoDTO;
import com.utes.spring.web.app.entity.Correo;

@Service
public interface CorreoService extends IParsable<CorreoDTO, Correo> {

	public boolean create(CorreoDTO obj);

	public boolean update(CorreoDTO obj);

	public boolean delete(Integer id);

	public List<CorreoDTO> obtenerListadoCorreoPorId(Integer idcorreo);

	public CorreoDTO obtenerCorreoPorId(Integer idcorreo);

	public List<CorreoDTO> obtenerCorreo(boolean valor);
}
