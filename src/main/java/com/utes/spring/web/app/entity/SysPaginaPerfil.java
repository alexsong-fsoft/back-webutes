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
@Table(name = "sys_paginaperfil", schema = "public")
@Data
public class SysPaginaPerfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pgprf", unique = true, nullable = false)
	private Integer idPgPrf;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_pag")
	private SysPagina sysPagina;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_prf")
	private SysPerfil sysPerfil;
	@Column(name = "pgprf_activo")
	private Boolean pgPrfActivo;

}
