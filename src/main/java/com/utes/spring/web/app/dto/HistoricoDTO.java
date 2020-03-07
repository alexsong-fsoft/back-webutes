package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class HistoricoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer pkHis;
	private Integer hisTema;
	private Integer hisPersona;
	private Date hisFechaCambio;
	private String hisCampo;
	private String hisValor;
}
