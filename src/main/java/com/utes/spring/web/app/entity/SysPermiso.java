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
@Table(name="sys_permiso" ,schema="public")
@Data
public class SysPermiso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_perm", unique=true, nullable=false)
	private Integer idPerm;
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fk_prf")
    private SysPerfil sysPerfil;
	@Column(name="perm_leer")
    private Boolean permLeer;
	@Column(name="perm_editar")
    private Boolean permEditar;
	@Column(name="perm_eliminar")
    private Boolean permEliminar;
	@Column(name="perm_crear")
    private Boolean permCrear;
	@Column(name="perm_exportar")
    private Boolean permExportar;
	@Column(name="perm_activo")
    private Boolean permActivo;

}
