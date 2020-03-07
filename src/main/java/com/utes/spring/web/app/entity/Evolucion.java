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
@Table(name = "evolucion", schema = "public")
@Data
public class Evolucion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evl", nullable = false, unique = true)
	private int idEvl;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_tem")
	private Tema tema;
	@Column(name = "evl_idestado")
	private Integer evlIdEstado;
	@Column(name = "evl_codigo", length = 100)
	private String evlCodigo;
	@Temporal(TemporalType.DATE)
	@Column(name = "evl_fechacita", length = 13)
	private Date evlFechaCita;
	@Temporal(TemporalType.DATE)
	@Column(name = "evl_fecharegistro", length = 13)
	private Date evlFechaRegistro;
	@Column(name = "evl_tiempoduracion")
	private Integer evlTiempoDuracion;
	@Column(name = "evl_descripcion")
	private String evlDescripcion;
	@Column(name = "evl_tareas")
	private String evlTareas;
	@Column(name = "evl_valida")
	private Boolean evlValida;
	@Temporal(TemporalType.DATE)
	@Column(name = "evl_fechavalida", length = 13)
	private Date evlFechaValida;
	@Column(name = "evl_comentario")
	private String evlComentario;
	@Column(name = "evl_activo")
	private Boolean evlActivo;
	@Column(name = "evl_secuencia")
	private Integer evlSecuencia;
	@Column(name = "evl_porcentaje", precision = 17, scale = 17)
	private Double evlPorcentaje;
	@Column(name = "evl_horacita", length = 25)
	private String evlHoracita;
}
