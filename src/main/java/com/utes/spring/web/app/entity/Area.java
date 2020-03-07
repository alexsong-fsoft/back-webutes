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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="area" ,schema="public")
@Data
public class Area implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_are", unique=true, nullable=false)
	private Integer idAre;
	@Column(name="are_nombre")
	private String areNombre;
	@Column(name="are_activo")
    private Boolean areActivo; 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_aret")
    private AreaTipo areaTipo;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="area")
	private List<AreaPersona> areaPersonas;

	public Area () {
		this.areaPersonas = new ArrayList<AreaPersona>();
	}
}
