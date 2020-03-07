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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "tema", schema = "public")
@Data
public class Tema implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "", nullable = false, unique = true)
	private Integer idTem;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_per")
	private Persona persona;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_con")
	private Convocatoria convocatoria;
	@Column(name = "tem_idtipo")
	private Integer temIdTipo;
	@Column(name = "tem_idestado")
	private Integer temIdEstado;
	@Column(name = "tem_nombre")
	private String temNombre;
	@Column(name = "tem_descripcion")
	private String temDescripcion;
	@Column(name = "tem_tema")
	private String temTema;
	@Column(name = "tem_numest")
	private Integer temNumEst;
	@Column(name = "tem_autora", length = 75)
	private String temAutorA;
	@Column(name = "tem_autorb", length = 75)
	private String temAutorB;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fechapublicado", length = 13)
	private Date temFechaPublicado;
	@Column(name = "tem_auspiciante")
	private String temAuspiciante;
	@Column(name = "tem_lectorplan", length = 100)
	private String temLectorPlan;
	@Column(name = "tem_lectorproyecto", length = 100)
	private String temLectorProyecto;
	@Column(name = "tem_activo")
	private Boolean temActivo;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fechacreado", length = 13)
	private Date temFechaCreado;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fechaeditado", length = 13)
	private Date temFechaEditado;
	@Column(name = "tem_porcavance", precision = 17, scale = 17)
	private Double temPorcAvance;
	@Column(name = "tem_aprobado")
	private Boolean temAprobado;
	@Column(name = "tem_alcance")
	private String temAlcance;
	@Column(name = "tem_objetivo")
	private String temObjetivo;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fechaenviado", length = 13)
	private Date temFechaEnviado;
	@Column(name = "tem_nota", precision = 17, scale = 17)
	private Double temNota;
	@Column(name = "tem_observacion")
	private String temObservacion;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fechainicio", length = 13)
	private Date temFechaInicio;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fechaentrega", length = 13)
	private Date temFechaEntrega;
	@Column(name = "tem_idperiodo")
	private Integer temIdPeriodo;
	@Temporal(TemporalType.DATE)
	@Column(name = "tem_fecharesolucion", length = 13)
	private Date temFechaResolucion;

	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Asignado> asignados;
	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Evolucion> evoluciones;
	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Informe> informes;
	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Hito> hitos;
	@OneToMany(mappedBy = "tema", fetch = FetchType.LAZY)
	private List<Resolucion> resoluciones;

	public Tema() {
		this.asignados = new ArrayList<Asignado>();
		this.evoluciones = new ArrayList<Evolucion>();
		this.informes = new ArrayList<Informe>();
		this.hitos = new ArrayList<Hito>();
		this.resoluciones = new ArrayList<Resolucion>();
	}
}
