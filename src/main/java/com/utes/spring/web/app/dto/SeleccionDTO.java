package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SeleccionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idSel;
	private PersonaDTO persona;
	private PeriodoDTO periodo;
	private Integer selHoraAsignada;
	private Integer selHoraVigente;
	private Integer selHoraLectura;
	private Integer idPersona;
	private Integer IdPeriodo;

}
