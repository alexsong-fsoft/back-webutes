package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CuestionarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCue;
	private Integer cueIdTipo;
	private Integer cueIdInscripcion;
	private String cuePregunta;
	private Boolean cueActivo;

	private List<RespuestaDTO> respuestas;

	public CuestionarioDTO() {
		this.respuestas = new ArrayList<RespuestaDTO>();
	}
}
