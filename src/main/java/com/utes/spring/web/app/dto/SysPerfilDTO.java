package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SysPerfilDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPrf;
	private String prfNombre;
	private Boolean prfActivo;

	private List<SysPaginaPerfilDTO> sysPaginaPerfiles;
	private List<SysPermisoDTO> sysPermisos;
	private List<SysUsuarioDTO> sysUsuarios;

	public SysPerfilDTO() {
		this.sysPaginaPerfiles = new ArrayList<SysPaginaPerfilDTO>();
		this.sysPermisos = new ArrayList<SysPermisoDTO>();
		this.sysUsuarios = new ArrayList<SysUsuarioDTO>();
	}
}
