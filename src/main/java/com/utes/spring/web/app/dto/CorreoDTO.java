package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CorreoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCorreo;
	private String correoHost;
	private String correoProtocolo;
	private String correoUsuario;
	private String correoClave;
	private String correoPuerto;
	private Boolean correoAuth;
	private String correoHtml;
	private String correoNotificacion;
	private String correoRecordatorio;
	private String correoPeticion;
	private Boolean correoActivo;
	private Date correoFechaCreado;
	private Date correoFechaEditado;
}
