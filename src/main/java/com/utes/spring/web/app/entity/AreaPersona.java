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
@Table(name = "areapersona", schema = "public")
@Data
public class AreaPersona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_arper", unique = true, nullable = false)
	private Integer idArPer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_are")
	private Area area;
	@Column(name = "arper_activo")
	private Boolean arPerActivo;
}
