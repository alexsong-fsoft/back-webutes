package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "correo", schema = "public")
@Data
public class Correo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_correo", nullable = false, unique = true)
	private Integer idCorreo;
	@Column(name = "correo_host")
	private String correoHost;
	@Column(name = "correo_protocolo")
	private String correoProtocolo;
	@Column(name = "correo_usuario")
	private String correoUsuario;
	@Column(name = "correo_clave")
	private String correoClave;
	@Column(name = "correo_puerto")
	private String correoPuerto;
	@Column(name = "correo_auth")
	private Boolean correoAuth;
	@Column(name = "correo_html")
	private String correoHtml;
	@Column(name = "correo_notificacion")
	private String correoNotificacion;
	@Column(name = "correo_recordatorio")
	private String correoRecordatorio;
	@Column(name = "correo_peticion")
	private String correoPeticion;
	@Column(name = "correo_activo")
	private Boolean correoActivo;
	@Temporal(TemporalType.DATE)
	@Column(name = "correo_fechacreado", length = 13)
	private Date correoFechaCreado;
	@Temporal(TemporalType.DATE)
	@Column(name = "correo_fechaeditado", length = 13)
	private Date correoFechaEditado;
}
