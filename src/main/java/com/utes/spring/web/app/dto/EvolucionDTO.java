package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class EvolucionDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idEvl;
	private TemaDTO tema;
	private Integer evlIdEstado;
	private String evlCodigo;
	private Date evlFechaCita;
	private Date evlFechaRegistro;
	private Integer evlTiempoDuracion;
	private String evlDescripcion;
	private String evlTareas;
	private Boolean evlValida;
	private Date evlFechaValida;
	private String evlComentario;
	private Boolean evlActivo;
	private Integer evlSecuencia;
	private Double evlPorcentaje;
	private String evlHoracita;
	private Integer idTema;
}
