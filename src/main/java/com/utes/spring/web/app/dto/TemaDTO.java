package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class TemaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idTem;
	private PersonaDTO persona;
	private ConvocatoriaDTO convocatoria;
	private Integer temIdTipo;
	private Integer temIdEstado;
	private String temNombre;
	private String temDescripcion;
	private String temTema;
	private Integer temNumEst;
	private String temAutorA;
	private String temAutorB;
	private Date temFechaPublicado;
	private String temAuspiciante;
	private String temLectorPlan;
	private String temLectorProyecto;
	private Boolean temActivo;
	private Date temFechaCreado;
	private Date temFechaEditado;
	private Double temPorcAvance;
	private Boolean temAprobado;
	private String temAlcance;
	private String temObjetivo;
	private Date temFechaEnviado;
	private Double temNota;
	private String temObservacion;
	private Date temFechaInicio;
	private Date temFechaEntrega;
	private Integer temIdPeriodo;
	private Date temFechaResolucion;

	private Integer idPersona;
	private Integer idConvocatoria;
	private String nombreEstado;
	private String nombreTipo;

	private List<AsignadoDTO> asignados;
	private List<EvolucionDTO> evoluciones;
	private List<InformeDTO> informes;
	private List<HitoDTO> hitos;
	private List<ResolucionDTO> resoluciones;

	public TemaDTO() {
		this.asignados = new ArrayList<AsignadoDTO>();
		this.evoluciones = new ArrayList<EvolucionDTO>();
		this.informes = new ArrayList<InformeDTO>();
		this.hitos = new ArrayList<HitoDTO>();
		this.resoluciones = new ArrayList<ResolucionDTO>();
	}
}
