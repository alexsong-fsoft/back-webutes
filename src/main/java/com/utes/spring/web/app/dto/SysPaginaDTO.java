package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SysPaginaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPag;
	private Integer pagPrincipal;
	private Integer pagOrden;
	private String pagEtiqueta;
	private Character pagTipo;
	private Boolean pagActivo;
	private String pagUrl;
	private String pagTitulo;

	private List<SysPaginaPerfilDTO> sysPaginaPerfiles;

	public SysPaginaDTO() {
		this.sysPaginaPerfiles = new ArrayList<SysPaginaPerfilDTO>();
	}
}
