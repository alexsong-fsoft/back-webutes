package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AsignadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idAsg;
	private PersonaDTO persona;
	private TemaDTO tema;
	private Integer asgIdTipo;
	private Date asgFechaRegistro;
	private Boolean asgActivo;
	private Integer asgIdEstadoTema;
	private Integer idPersona;
	private Integer idTema;
}
