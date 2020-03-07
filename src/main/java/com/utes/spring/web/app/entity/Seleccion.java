package com.utes.spring.web.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "seleccion", schema = "public")
@Data
public class Seleccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sel", unique = true, nullable = false)
	private Integer idSel;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_prd")
	private Periodo periodo;
	@Column(name = "sel_horaasignada")
	private Integer selHoraAsignada;
	@Column(name = "sel_horavigente")
	private Integer selHoraVigente;
	@Column(name = "sel_horalectura")
	private Integer selHoraLectura;

}
