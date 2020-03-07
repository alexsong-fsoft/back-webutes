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
@Table(name = "hito", schema = "public")
@Data
public class Hito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hit", nullable = false, unique = true)
	private Integer idHit;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tem")
	private Tema tema;
	@Column(name = "hit_idestado")
	private Integer hitIdEstado;
	@Column(name = "hit_codigo", length = 100)
	private String hitCodigo;
	@Column(name = "hit_descripcion")
	private String hitDescripcion;
	@Temporal(TemporalType.DATE)
	@Column(name = "hit_fechaentrega", length = 13)
	private Date hitFechaEntrega;
	@Column(name = "hit_comentario")
	private String hitComentario;
	@Temporal(TemporalType.DATE)
	@Column(name = "hit_fechavalida", length = 13)
	private Date hitFechavalida;
	@Column(name = "hit_secuencia")
	private Integer hitSecuencia;
	@Column(name = "hit_valida")
	private Boolean hitValida;
}
