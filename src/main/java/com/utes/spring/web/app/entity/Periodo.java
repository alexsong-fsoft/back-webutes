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
@Table(name = "periodo", schema = "public")
@Data
public class Periodo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prd", unique = true, nullable = false)
	private Integer idPrd;
	@Column(name = "prd_numero")
	private Integer prdNumero;
	@Temporal(TemporalType.DATE)
	@Column(name = "prd_fechainicio", length = 13)
	private Date prdFechaInicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "prd_fechafin", length = 13)
	private Date prdFechaFin;
	@Column(name = "prd_activo")
	private Boolean prdActivo;
	@Column(name = "prd_anioinicio")
	private Integer prdAnioInicio;
	@Column(name = "prd_aniofin")
	private Integer prdAnioFin;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "periodo")
	private List<Seleccion> selecciones;

	public Periodo() {
		this.selecciones = new ArrayList<Seleccion>();
	}
}
