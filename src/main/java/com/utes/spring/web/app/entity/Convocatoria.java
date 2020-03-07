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
@Table(name = "convocatoria", schema = "public")
@Data
public class Convocatoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_con", nullable = false, unique = true)
	private Integer idCon;
	@Column(name = "con_nombre", length = 100)
	private String conNombre;
	@Column(name = "con_numerotema")
	private Integer conNumeroTema;
	@Column(name = "con_periodo")
	private Integer conPeriodo;
	@Temporal(TemporalType.DATE)
	@Column(name = "con_fechainicio", length = 13)
	private Date conFechaInicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "con_fechafin", length = 13)
	private Date conFechaFin;
	@Column(name = "con_activo")
	private Boolean conActivo;
	@Column(name = "con_descripcion", length = 150)
	private String conDescripcion;
	@Column(name = "con_secuencia")
	private Integer conSecuencia;

	@OneToMany(mappedBy = "convocatoria", fetch = FetchType.LAZY)
	private List<Tema> temas;

	public Convocatoria() {
		this.temas = new ArrayList<Tema>();
	}
}
