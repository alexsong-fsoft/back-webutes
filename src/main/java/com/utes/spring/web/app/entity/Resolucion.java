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
@Table(name = "resolucion", schema = "public")
@Data
public class Resolucion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rsl", unique = true, nullable = false)
	private Integer idRsl;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_trsl")
	private TipoResolucion tipoResolucion;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tem")
	private Tema tema;
	@Column(name = "rsl_numero", length = 100)
	private String rslNumero;
	@Temporal(TemporalType.DATE)
	@Column(name = "rsl_fecharesolucion", length = 13)
	private Date rslFechaResolucion;
	@Temporal(TemporalType.DATE)
	@Column(name = "rsl_fechainicio", length = 13)
	private Date rslFechaInicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "rsl_fechaentrega", length = 13)
	private Date rslFechaEntrega;
	@Column(name = "rsl_activo")
	private Boolean rslActivo;
	@Column(name = "rsl_observacion")
	private String rslObservacion;
	@Column(name = "rsl_idestado")
	private Integer rslIdEstado;
}
