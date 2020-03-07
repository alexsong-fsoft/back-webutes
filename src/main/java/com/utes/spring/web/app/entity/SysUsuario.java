package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "sys_usuario", schema = "public")
@Data
public class SysUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usr", unique = true, nullable = false)
	private Integer idUsr;
	// @ManyToOne(fetch = FetchType.LAZY)
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_prf")
	private SysPerfil sysPerfil;
	@Column(name = "usr_usuario")
	private String usrUsuario;
	@Column(name = "usr_clave")
	private String usrClave;
	@Column(name = "usr_correo", length = 75)
	private String usrCorreo;
	@Column(name = "usr_activo")
	private Boolean usrActivo;
	@Temporal(TemporalType.DATE)
	@Column(name = "usr_fechacreado", length = 13)
	private Date usrFechaCreado;
	@Temporal(TemporalType.DATE)
	@Column(name = "usr_fechaeditado", length = 13)
	private Date usrFechaEditado;

}
