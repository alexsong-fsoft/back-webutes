package com.utes.spring.web.app.projection;

import java.util.Date;

public interface TemaProjection {

	Integer getIdTem();

	Integer getFkCon();

	Integer getFkPer();

	Integer getTemIdTipo();

	Integer getTemIdEstado();

	String getTemNombre();

	String getTemDescripcion();

	String getTemTema();

	Integer getTemNumEst();

	String getTemAutorA();

	String getTemAutorB();

	Date getTemFechaPublicado();

	String getTemAuspiciante();

	String getTemLectorPlan();

	String getTemLectorProyecto();

	Boolean getTemActivo();

	Date getTemFechaCreado();

	Date getTemFechaEditado();

	Double getTemPorcAvance();

	Boolean getTemAprobado();

	String getTemAlcance();

	String getTemObjetivo();

	Date getTemFechaEnviado();

	Double getTemNota();

	String getTemObservacion();

	Date getTemFechaInicio();

	Date getTemFechaEntrega();

	Integer getTemIdPeriodo();

	Date getTemFechaResolucion();

	Integer getIdPersona();

	Integer getIdConvocatoria();

	String getNombreEstado();

	String getNombreTipo();

}
