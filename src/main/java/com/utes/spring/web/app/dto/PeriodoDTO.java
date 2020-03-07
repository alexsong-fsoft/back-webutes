package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PeriodoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPrd;
	private Integer prdNumero;
	private Date prdFechaInicio;
	private Date prdFechaFin;
	private Boolean prdActivo;
	private Integer prdAnioInicio;
	private Integer prdAnioFin;

	private List<SeleccionDTO> selecciones;

	public PeriodoDTO() {
		this.selecciones = new ArrayList<SeleccionDTO>();
	}
}
