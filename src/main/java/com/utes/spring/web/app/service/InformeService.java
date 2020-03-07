package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.InformeDTO;
import com.utes.spring.web.app.entity.Informe;

@Service
public interface InformeService extends IParsable<InformeDTO, Informe> {

	public boolean create(InformeDTO obj);

	public boolean update(InformeDTO obj);

	public boolean delete(Integer id);

	public List<InformeDTO> obtenerListadoInforme(boolean activo);

	public InformeDTO obtenerInforme(Integer id);

	public List<InformeDTO> obtenerInformesxTema(Integer idtema);

	public List<InformeDTO> obtenerInformesxTemaPersona(Integer idtema, Integer idpersona);

}
