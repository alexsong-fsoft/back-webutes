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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "presolicitud", schema = "public")
@Data
public class Presolicitud implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_psl", nullable = false, unique = true)
	private Integer idPsl;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ins")
	private Inscripcion inscripcion;
	@Column(name = "psl_idestado")
	private Integer pslIdEstado;
	@Column(name = "psl_idopcion")
	private Integer pslIdOpcion;
	@Temporal(TemporalType.DATE)
	@Column(name = "psl_fecha", length = 13)
	private Date pslFecha;
	@Column(name = "psl_mensaje")
	private String pslMensaje;
	@Temporal(TemporalType.DATE)
	@Column(name = "psl_fecharevision", length = 13)
	private Date pslFechaRevision;
	@Column(name = "psl_observacion")
	private String pslObservacion;
	@Column(name = "psl_prerevision")
	private String pslPrerevision;
	@Temporal(TemporalType.DATE)
	@Column(name = "psl_fechaprerevision", length = 13)
	private Date pslFechaPrerevision;
	@Column(name = "psl_idestadoanterior")
	private Integer pslIdEstadoAnterior;
	@Column(name = "psl_activo")
	private Boolean pslActivo;
	@Column(name = "psl_files")
	private String pslFiles;

	@OneToMany(mappedBy = "presolicitud", fetch = FetchType.LAZY)
	private List<Respuesta> respuestas;

	public Presolicitud() {
		this.respuestas = new ArrayList<Respuesta>();
	}
}
