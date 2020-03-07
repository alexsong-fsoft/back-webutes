package com.utes.spring.web.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "sys_propiedades", schema = "public")
@Data
public class SysPropiedades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prop", unique = true, nullable = false)
	private Integer idProp;
	@Column(name = "prop_colora")
	private String propColorA;
	@Column(name = "prop_colorb")
	private String propColorB;
	@Column(name = "prop_colorc")
	private String propColorC;
	@Column(name = "prop_avancemaxdocente")
	private Integer propAvanceMaxDocente;
	@Column(name = "prop_avancefinal")
	private Integer propAvanceFinal;
	@Column(name = "prop_avancemindocente")
	private Integer propAvanceMinDocente;
	@Column(name = "prop_numestmin")
	private Integer propNumEstMin;
	@Column(name = "prop_numestmax")
	private Integer propNumEstMax;
	@Column(name = "prop_colorvalora")
	private String propColorValorA;
	@Column(name = "prop_colorvalorb")
	private String propColorValorB;
	@Column(name = "prop_colorvalorc")
	private String propColorValorC;
	@Column(name = "prop_colorvalord")
	private String propColorValorD;
	@Column(name = "prop_colord")
	private String propColorD;
}
