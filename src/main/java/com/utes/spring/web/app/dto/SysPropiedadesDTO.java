package com.utes.spring.web.app.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SysPropiedadesDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idProp;
	private String propColorA;
	private String propColorB;
	private String propColorC;
	private Integer propAvanceMaxDocente;
	private Integer propAvanceFinal;
	private Integer propAvanceMinDocente;
	private Integer propNumEstMin;
	private Integer propNumEstMax;
	private String propColorValorA;
	private String propColorValorB;
	private String propColorValorC;
	private String propColorValorD;
	private String propColorD;
}
