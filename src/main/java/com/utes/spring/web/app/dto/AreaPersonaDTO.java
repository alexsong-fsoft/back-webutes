package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AreaPersonaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idArPer;
	private PersonaDTO persona;
	private AreaDTO area;
	private Boolean arPerActivo;
	private Integer idPersona;
	private Integer idArea;
}
