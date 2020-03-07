package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "cuestionario", schema = "public")
@Data
public class Cuestionario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cue", nullable = false, unique = true)
	private Integer idCue;
	@Column(name = "cue_idtipo")
	private Integer cueIdTipo;
	@Column(name = "cue_idinscripcion")
	private Integer cueIdInscripcion;
	@Column(name = "cue_pregunta")
	private String cuePregunta;
	@Column(name = "cue_activo")
	private Boolean cueActivo;

	@OneToMany(mappedBy = "cuestionario", fetch = FetchType.LAZY)
	private List<Respuesta> respuestas;

	public Cuestionario() {
		this.respuestas = new ArrayList<Respuesta>();
	}
}
