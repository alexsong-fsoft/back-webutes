package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysPaginaPerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPgPrf;
	private SysPaginaDTO sysPagina;
	private SysPerfilDTO sysPerfil;
	private Boolean pgPrfActivo;
	private Integer idSysPagina;
	private Integer idSysPerfil;
}
