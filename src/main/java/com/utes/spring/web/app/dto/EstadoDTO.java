package com.utes.spring.web.app.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class EstadoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String titulo;
	private String fase;

	public EstadoDTO(int id, String titulo, String fase) {
		this.id = id;
		this.titulo = titulo;
		this.fase = fase;
	}

	public static String getNombreEstadoPorLista(int id, List<EstadoDTO> listaestado) {
		String data = "";
		if (id != 0) {
			for (EstadoDTO estado : listaestado) {
				if (estado.getId() == id) {
					data = estado.getTitulo();
					break;
				}
			}
		}
		return data;
	}
}
