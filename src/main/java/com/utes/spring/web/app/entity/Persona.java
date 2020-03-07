package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "persona", schema = "public")
@Data
public class Persona implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_per", unique = true, nullable = false)
	private Integer idPer;
	@Column(name = "per_cedula", length = 13)
	private String perCedula;
	@Column(name = "per_nombre", length = 75)
	private String perNombre;
	@Column(name = "per_apellido", length = 75)
	private String perApellido;
	@Column(name = "per_direccion", length = 150)
	private String perDireccion;
	@Column(name = "per_telefono", length = 15)
	private String perTelefono;
	@Column(name = "per_celular", length = 15)
	private String perCelular;
	@Column(name = "per_sexo", length = 1)
	private Character perSexo;
	@Temporal(TemporalType.DATE)
	@Column(name = "per_fechacreado", length = 13)
	private Date perFechaCreado;
	@Temporal(TemporalType.DATE)
	@Column(name = "per_fechaeditado", length = 13)
	private Date perFechaEditado;
	@OneToOne(mappedBy = "persona")
	private SysUsuario sysUsuario;

	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<AreaPersona> areaPersonas;
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Asignado> asignados;
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Tema> temas;
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Presolicitud> presolicitudes;
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Informe> informes;
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Seleccion> selecciones;
	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
	private List<Resolucion> resoluciones;
//	@OneToMany(mappedBy = "persona", fetch = FetchType.LAZY)
//	private List<SysUsuario> sysUsuarios;

	public Persona() {
		this.areaPersonas = new ArrayList<AreaPersona>();
		this.asignados = new ArrayList<Asignado>();
		this.temas = new ArrayList<Tema>();
		this.presolicitudes = new ArrayList<Presolicitud>();
		this.informes = new ArrayList<Informe>();
		this.selecciones = new ArrayList<Seleccion>();
		this.resoluciones = new ArrayList<Resolucion>();
//		this.sysUsuarios = new ArrayList<SysUsuario>();
	}
}
