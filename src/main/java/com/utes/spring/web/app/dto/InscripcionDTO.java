package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class InscripcionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idIns;
	private String insNombre;
	private Integer insPeriodo;
	private Date insFechaInicio;
	private Date insFechaFin;
	private Boolean insActivo;
	private Integer insSecuencia;
	private byte[] file;

	private List<PresolicitudDTO> presolicitudes;

	public InscripcionDTO() {
		this.presolicitudes = new ArrayList<PresolicitudDTO>();
	}
}
