package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PresolicitudDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idPsl;
	private PersonaDTO persona;
	private InscripcionDTO inscripcion;
	private Integer pslIdEstado;
	private Integer pslIdOpcion;
	private Date pslFecha;
	private String pslMensaje;
	private Date pslFechaRevision;
	private String pslObservacion;
	private String pslPrerevision;
	private Date pslFechaPrerevision;
	private Integer pslIdEstadoAnterior;
	private Boolean pslActivo;
	private String pslFiles;

	private Integer idPersona;
	private Integer idInscripcion;
	private String nombreEstado;
	private String nombreTipo;

	private List<RespuestaDTO> respuestas;

	public PresolicitudDTO() {
		this.respuestas = new ArrayList<RespuestaDTO>();
	}
}
