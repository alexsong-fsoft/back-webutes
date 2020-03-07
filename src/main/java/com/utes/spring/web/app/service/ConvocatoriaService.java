package com.utes.spring.web.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utes.spring.web.app.dto.ConvocatoriaDTO;
import com.utes.spring.web.app.entity.Convocatoria;

@Service
public interface ConvocatoriaService extends IParsable<ConvocatoriaDTO, Convocatoria> {

	public boolean create(ConvocatoriaDTO obj);

	public boolean update(ConvocatoriaDTO obj);

	public boolean delete(Integer id);

	public List<ConvocatoriaDTO> obtenerListadoConvocatoria();

	public Integer obtenerConvocatoriaSecuencia();

	public Integer obtenerUltimoRegistroConvocatoria();

	public Integer obtenerSecuencialConvocatoria();

	public List<ConvocatoriaDTO> obtenerListadoConvocatoriaPorActivo(boolean conactivo);

	public ConvocatoriaDTO obtenerConvocatoriaPorId(Integer id);

	public ConvocatoriaDTO obtenerConvocatoriaPorIdActivo(Integer id, boolean estado);

	public ConvocatoriaDTO obtenerConvocatoriaPorIdPeriodo(Integer id);

}
