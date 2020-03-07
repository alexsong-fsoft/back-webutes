package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class RespuestaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idRes;
	private PresolicitudDTO presolicitud;
	private CuestionarioDTO cuestionario;
	private Boolean resValor;
	private Boolean resValidacion;
	private Boolean resPrerevision;
	private Integer idPresolicitud;
	private Integer idCuestionario;
}
