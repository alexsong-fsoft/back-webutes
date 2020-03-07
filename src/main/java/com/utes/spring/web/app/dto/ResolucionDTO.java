package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ResolucionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idRsl;
	private TipoResolucionDTO tipoResolucion;
	private PersonaDTO persona;
	private TemaDTO tema;
	private String rslNumero;
	private Date rslFechaResolucion;
	private Date rslFechaInicio;
	private Date rslFechaEntrega;
	private Boolean rslActivo;
	private String rslObservacion;
	private Integer rslIdEstado;
	private Integer idTipoResolucion;
	private Integer idPersona;
	private Integer idTema;
}
