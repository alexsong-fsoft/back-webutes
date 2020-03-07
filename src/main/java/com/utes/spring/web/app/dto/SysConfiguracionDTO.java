package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysConfiguracionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer pkConf;
	private String confCampo;
	private Boolean confEstado;
	private String confValor;
	private String confTipo;
	private Boolean confActivo;
}
