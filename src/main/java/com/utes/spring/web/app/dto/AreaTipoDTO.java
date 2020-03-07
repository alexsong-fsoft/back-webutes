package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AreaTipoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idAreT;
	private String aretNombre;
	private Boolean aretActivo;
	private List<AreaDTO> areas;

	public AreaTipoDTO() {
		this.areas = new ArrayList<AreaDTO>();
	}
}
