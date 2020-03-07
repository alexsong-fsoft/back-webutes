package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TipoResolucionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idTrsl;
	private String trslTitulo;
	private String trslDescripcion;
	private Boolean trslActive;

	private List<ResolucionDTO> resoluciones;

	public TipoResolucionDTO() {
		this.resoluciones = new ArrayList<ResolucionDTO>();
	}
}
