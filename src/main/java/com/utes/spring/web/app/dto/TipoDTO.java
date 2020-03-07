package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TipoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;

	public TipoDTO(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public static String getNombreTipoPorLista(int id, List<TipoDTO> listatipos) {
		String data = "";
		for (TipoDTO estado : listatipos) {
			if (estado.getId() == id) {
				data = estado.getNombre();
				break;
			}
		}
		return data;
	}
}
