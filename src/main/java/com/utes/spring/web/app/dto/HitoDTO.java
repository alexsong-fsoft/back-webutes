package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class HitoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idHit;
	private TemaDTO tema;
	private Integer hitIdEstado;
	private String hitCodigo;
	private String hitDescripcion;
	private Date hitFechaEntrega;
	private String hitComentario;
	private Date hitFechavalida;
	private Integer hitSecuencia;
	private Boolean hitValida;
	private Integer idTema;
}
