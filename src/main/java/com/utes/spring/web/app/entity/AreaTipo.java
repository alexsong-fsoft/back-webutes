package com.utes.spring.web.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "areatipo", schema = "public")
@Data
public class AreaTipo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aret", unique = true, nullable = false)
	private Integer idAreT;
	@Column(name = "aret_nombre", length = 50)
	private String aretNombre;
	@Column(name = "aret_activo")
	private Boolean aretActivo;
	@OneToMany(mappedBy = "areaTipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Area> areas;

	public AreaTipo() {
		this.areas = new ArrayList<Area>();
	}

}
