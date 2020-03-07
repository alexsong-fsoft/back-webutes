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
@Table(name="sys_perfil" ,schema="public")
@Data
public class SysPerfil implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_prf", unique=true, nullable=false)
	private Integer idPrf;
	@Column(name="prf_nombre", length=30)
    private String prfNombre;
	@Column(name="prf_activo")
    private Boolean prfActivo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sysPerfil")
    private List<SysPaginaPerfil> sysPaginaPerfiles;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sysPerfil")
    private List<SysPermiso> sysPermisos;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sysPerfil")
    private List<SysUsuario> sysUsuarios;

	public SysPerfil () {
		this.sysPaginaPerfiles = new ArrayList<SysPaginaPerfil>();
		this.sysPermisos = new ArrayList<SysPermiso>();
		this.sysUsuarios = new ArrayList<SysUsuario>();
	}
}
