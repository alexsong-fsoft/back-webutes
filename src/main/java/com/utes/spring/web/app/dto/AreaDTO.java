package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AreaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idAre;
	private String areNombre;
	private Boolean areActivo;
	private AreaTipoDTO areaTipo;
	private List<AreaPersonaDTO> areaPersonas;
	private Integer idAreaTipo;

	public AreaDTO() {
		this.areaPersonas = new ArrayList<AreaPersonaDTO>();
	}
}
