package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class InformeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idInf;
	private PersonaDTO persona;
	private TemaDTO tema;
	private Integer infIdEstado;
	private Date infFecha;
	private String infInforme;
	private String infTema;
	private String infObservacion;
	private Boolean infActivo;
	private Date infFechaPlazo;
	private Integer idPersona;
	private Integer idTema;
}
