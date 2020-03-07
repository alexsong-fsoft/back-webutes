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
@Table(name = "respuesta", schema = "public")
@Data
public class Respuesta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_res", nullable = false, unique = true)
	private Integer idRes;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_psl")
    private Presolicitud presolicitud;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_cue")
    private Cuestionario cuestionario;
    @Column(name="res_valor")
    private Boolean resValor;
    @Column(name="res_validacion")
    private Boolean resValidacion;
    @Column(name="res_prerevision")
    private Boolean resPrerevision;
}
