package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "asignado", schema = "public")
@Data
public class Asignado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asg", nullable = false, unique = true)
	private Integer idAsg;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tem")
	private Tema tema;
	@Column(name = "asg_idtipo")
	private Integer asgIdTipo;
	@Temporal(TemporalType.DATE)
	@Column(name = "asg_fecharegistro", length = 13)
	private Date asgFechaRegistro;
	@Column(name = "asg_activo")
	private Boolean asgActivo;
	@Column(name = "asg_idestadotema")
	private Integer asgIdEstadoTema;
}
