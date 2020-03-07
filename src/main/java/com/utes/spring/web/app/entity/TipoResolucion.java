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
@Table(name="tiporesolucion", schema = "public")
@Data
public class TipoResolucion implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_trsl", unique=true, nullable=false)
	private Integer idTrsl;
	@Column(name="trsl_titulo", length=100)
    private String trslTitulo;
	@Column(name="trsl_descripcion")
    private String trslDescripcion;
	@Column(name="trsl_active")
    private Boolean trslActive;
    
	@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoResolucion")
    private List<Resolucion> resoluciones;
	
	public TipoResolucion () {
		this.resoluciones = new ArrayList<Resolucion>();
	}

}
