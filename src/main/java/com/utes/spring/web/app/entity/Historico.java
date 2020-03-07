package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "historico", schema = "public")
@Data
public class Historico implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_his", nullable = false, unique = true)
	private Integer pkHis;
	@Column(name = "his_tema")
	private Integer hisTema;
	@Column(name = "his_persona")
	private Integer hisPersona;
	@Temporal(TemporalType.DATE)
	@Column(name = "his_fechacambio", length = 13)
	private Date hisFechaCambio;
	@Column(name = "his_campo", length = 100)
	private String hisCampo;
	@Column(name = "his_valor")
	private String hisValor;
}
