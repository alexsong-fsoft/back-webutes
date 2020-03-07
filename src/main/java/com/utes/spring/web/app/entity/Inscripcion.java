package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "inscripcion", schema = "public")
@Data
public class Inscripcion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ins", nullable = false, unique = true)
	private Integer idIns;
	@Column(name = "ins_nombre", length = 100)
	private String insNombre;
	@Column(name = "ins_periodo")
	private Integer insPeriodo;
	@Temporal(TemporalType.DATE)
	@Column(name = "ins_fechainicio", length = 13)
	private Date insFechaInicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "ins_fechafin", length = 13)
	private Date insFechaFin;
	@Column(name = "ins_activo")
	private Boolean insActivo;
	@Column(name = "ins_secuencia")
	private Integer insSecuencia;
	@Column(name = "file")
	private byte[] file;

	@OneToMany(mappedBy = "inscripcion", fetch = FetchType.LAZY)
	private List<Presolicitud> presolicitudes;

	public Inscripcion() {
		this.presolicitudes = new ArrayList<Presolicitud>();
	}
}
