package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ConvocatoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCon;
	private String conNombre;
	private Integer conNumeroTema;
	private Integer conPeriodo;
	private Date conFechaInicio;
	private Date conFechaFin;
	private Boolean conActivo;
	private String conDescripcion;
	private Integer conSecuencia;

	private List<TemaDTO> temas;

	public ConvocatoriaDTO() {
		this.temas = new ArrayList<TemaDTO>();
	}
}
