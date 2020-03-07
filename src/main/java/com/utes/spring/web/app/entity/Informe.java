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
@Table(name = "informe", schema = "public")
@Data
public class Informe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_inf", nullable = false, unique = true)
	private Integer idInf;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tem")
	private Tema tema;
	@Column(name = "inf_idestado")
	private Integer infIdEstado;
	@Temporal(TemporalType.DATE)
	@Column(name = "inf_fecha", length = 13)
	private Date infFecha;
	@Column(name = "inf_informe")
	private String infInforme;
	@Column(name = "inf_tema")
	private String infTema;
	@Column(name = "inf_observacion")
	private String infObservacion;
	@Column(name = "inf_activo")
	private Boolean infActivo;
	@Temporal(TemporalType.DATE)
	@Column(name = "inf_fechaplazo", length = 13)
	private Date infFechaPlazo;
}
