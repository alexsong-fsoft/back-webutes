package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysPermisoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPerm;
	private SysPerfilDTO sysPerfil;
	private Boolean permLeer;
	private Boolean permEditar;
	private Boolean permEliminar;
	private Boolean permCrear;
	private Boolean permExportar;
	private Boolean permActivo;
	private Integer idSysPerfil;
}
