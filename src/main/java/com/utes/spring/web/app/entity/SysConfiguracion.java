package com.utes.spring.web.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="sys_configuracion" ,schema="public")
@Data
public class SysConfiguracion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="pk_conf", unique=true, nullable=false)
	private Integer pkConf;
	@Column(name="conf_campo", length=100)
    private String confCampo;
	@Column(name="conf_estado")
    private Boolean confEstado;
	@Column(name="conf_valor", length=250)
    private String confValor;
	@Column(name="conf_tipo", length=50)
    private String confTipo;
	@Column(name="conf_activo")
    private Boolean confActivo;
}
