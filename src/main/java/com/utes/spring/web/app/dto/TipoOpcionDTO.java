package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TipoOpcionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pkTop;
	private String topNombre;
	private Boolean topActivo;
	private Date da;
}
