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
@Table(name="tipoopcion" ,schema="public")
@Data
public class TipoOpcion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="pk_top", unique=true, nullable=false)
	private Integer pkTop;
	@Column(name="top_nombre")
    private String topNombre;
	@Column(name="top_activo")
    private Boolean topActivo;
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="da", length=29)
    private Date da;
}
