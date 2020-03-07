package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.HistoricoDTO;
import com.utes.spring.web.app.entity.Historico;

@Service
public interface HistoricoService extends IParsable<HistoricoDTO, Historico> {

	public boolean create(HistoricoDTO obj);

	public boolean update(HistoricoDTO obj);

	public boolean delete(Integer id);

	public HistoricoDTO obtenerHistorico(Integer id);

	public List<HistoricoDTO> obtenerHistoricoxTema(Integer idtema);

	public List<HistoricoDTO> obtenerHistoricoxTema(Integer idtema, Integer idpersona);

	public HistoricoDTO obtenerEntidadHistorico(Integer idtema);

	public HistoricoDTO obtenerEntidadHistorico(Integer idtema, Integer idpersona);

	public List<HistoricoDTO> obtenerHistorico();

}
