package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PersonaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idPer;
	private String perCedula;
	private String perNombre;
	private String perApellido;
	private String perDireccion;
	private String perTelefono;
	private String perCelular;
	private Character perSexo;
	private Date perFechaCreado;
	private Date perFechaEditado;
	private SysUsuarioDTO sysUsuario;

	private List<AreaPersonaDTO> areaPersonas;
	private List<AsignadoDTO> asignados;
	private List<TemaDTO> temas;
	private List<PresolicitudDTO> presolicitudes;
	private List<InformeDTO> informes;
	private List<SeleccionDTO> selecciones;
	private List<ResolucionDTO> resoluciones;
	// private List<SysUsuarioDTO> sysUsuarios;

	public PersonaDTO() {
		this.areaPersonas = new ArrayList<AreaPersonaDTO>();
		this.asignados = new ArrayList<AsignadoDTO>();
		this.temas = new ArrayList<TemaDTO>();
		this.presolicitudes = new ArrayList<PresolicitudDTO>();
		this.informes = new ArrayList<InformeDTO>();
		this.selecciones = new ArrayList<SeleccionDTO>();
		this.resoluciones = new ArrayList<ResolucionDTO>();
		// this.sysUsuarios = new ArrayList<SysUsuarioDTO>();
	}

}
