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
@Table(name="sys_pagina" ,schema="public")
@Data
public class SysPagina implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_pag", unique=true, nullable=false)
	private Integer idPag;
	@Column(name="pag_principal")
    private Integer pagPrincipal;
	@Column(name="pag_orden")
    private Integer pagOrden;
	@Column(name="pag_etiqueta", length=50)
    private String pagEtiqueta;
	@Column(name="pag_tipo", length=1)
    private Character pagTipo;
	@Column(name="pag_activo")
    private Boolean pagActivo;
	@Column(name="pag_url", length=100)
    private String pagUrl;
	@Column(name="pag_titulo", length=50)
    private String pagTitulo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sysPagina")
    private List<SysPaginaPerfil> sysPaginaPerfiles;
	
	public SysPagina () {
		this.sysPaginaPerfiles = new ArrayList<SysPaginaPerfil>();
	}

}
