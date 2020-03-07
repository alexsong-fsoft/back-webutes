package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class SysUsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsr;
	private PersonaDTO persona;
	private SysPerfilDTO sysPerfil;
	private String usrUsuario;
	private String usrClave;
	private String usrCorreo;
	private Boolean usrActivo;
	private Date usrFechaCreado;
	private Date usrFechaEditado;
	private Integer idPersona;
	private Integer idSysPerfil;
}
