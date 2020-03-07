package com.utes.spring.web.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import lombok.Data;

@Configuration
@PropertySources({ @PropertySource("classpath:messages.properties") })
@Data
public class EstaticosConfig {

	@Value("${application.titulo}")
	private String applicationTitulo;

	@Value("${utes.sitio.siglas}")
	String UTES_SITIO_SIGLAS;

	@Value("${utes.sitio.titulo}")
	String UTES_SITIO_TITULO;

	@Value("${utes.sitio.pie}")
	String UTES_SITIO_PIE;

	@Value("${utes.sitio.menu.label}")
	String UTES_SITIO_MENU;

	@Value("${utes.sitio.universidad}")
	String UTES_SITIO_UNIVERSIDAD;

	@Value("${mensaje.correcto.registro}")
	String MENSAJE_OK_REGISTRA;

	@Value("${mensaje.correcto.actualiza}")
	String MENSAJE_OK_ACTUALIZA;

	@Value("${mensaje.correcto.elimina}")
	String MENSAJE_OK_ELIMINA;

	@Value("${mensaje.resolucion.anula}")
	String MENSAJE_RESOLUCION_ANULA;

	@Value("${mensaje.error.registro}")
	String MENSAJE_ERROR_REGISTRA;

	@Value("${mensaje.error.actualiza}")
	String MENSAJE_ERROR_ACTUALIZA;

	@Value("${mensaje.error.elimina}")
	String MENSAJE_ERROR_ELIMINA;

	@Value("${mensaje.error.existe}")
	String MENSAJE_ERROR_EXISTE;

	@Value("${mensaje.error.existe.convocatoria}")
	String MENSAJE_ERROR_EXISTE_CONVOCATORIA;

	@Value("${mensaje.error.seleccion}")
	String MENSAJE_ERROR_SELECCION;

	@Value("${mensaje.error.registro.cero}")
	String MENSAJE_ERROR_REGISTRA_CERO;

	@Value("${mensaje.error.registro.blanco}")
	String MENSAJE_ERROR_REGISTRA_BLANCO;

	@Value("${mensaje.error.exedido}")
	String MENSAJE_ERROR_EXEDIDO;

	@Value("${mensaje.error.nomismo}")
	String MENSAJE_ERROR_NOMISMO;

	@Value("${mensaje.error.datorelacion}")
	String MENSAJE_ERROR_DATORELACION;

	@Value("${mensaje.error.noperiodo}")
	String MENSAJE_ERROR_NOPERIODO;

	@Value("${mensaje.confirma.pregunta}")
	String MENSAJE_CONFIRMA_PREGUNTA;

	@Value("${mensaje.login.inicio}")
	String MENSAJE_LOGIN_INICIO;

	@Value("${mensaje.login.titulo}")
	String MENSAJE_LOGIN_TITULO;

	@Value("${mensaje.login.error}")
	String MENSAJE_LOGIN_ERROR;

	@Value("${mensaje.login.error.clave}")
	String MENSAJE_LOGIN_ERROR_CLAVE;

	@Value("${mensaje.cuenta.titulo}")
	String MENSAJE_CUENTA_TITULO;

	@Value("${label.tabla.vacia}")
	String LABEL_TABLA_VACIA;

	@Value("${label.seleccion.vacio}")
	String LABEL_SELECCIONE_VACIO;

	@Value("${label.seleccion.todos}")
	String LABEL_SELECCIONE_TODOS;

	@Value("${label.seleccion.filtro}")
	String LABEL_SELECCIONE_FILTRO;

	@Value("${mensaje.valida.cumple}")
	String MENSAJE_VALIDA_CUMPLE;

	@Value("${mensaje.valida.nocumple}")
	String MENSAJE_VALIDA_NOCUMPLE;

	@Value("${tipo.primero.label}")
	String TIPO_PRIMERO_LABEL;

	@Value("${tipo.primero.letra}")
	String TIPO_PRIMERO_LETRA;

	@Value("${tipo.segundo.label}")
	String TIPO_SEGUNDO_LABEL;

	@Value("${tipo.segundo.letra}")
	String TIPO_SEGUNDO_LETRA;

	@Value("${tipo.tercero.label}")
	String TIPO_TERCERO_LABEL;

	@Value("${tipo.tercero.letra}")
	String TIPO_TERCERO_LETRA;

	@Value("${tipo.id.cuestionario.inscripcion}")
	Integer TIPO_ID_CUESTIONARIO_INSCRIPCION;

	@Value("${tipo.id.cuestionario.prerevision}")
	Integer TIPO_ID_CUESTIONARIO_PREREVISION;

	@Value("${tipo.id.asignacion.revisor}")
	Integer TIPO_ID_ASIGNACION_REVISOR;

	@Value("${tipo.id.asignacion.lectorplan}")
	Integer TIPO_ID_ASIGNACION_LECTORPLAN;

	@Value("${tipo.id.asignacion.lectorproyecto}")
	Integer TIPO_ID_ASIGNACION_LECTORPROYECTO;

	@Value("${tipo.id.asignacion.estudiante}")
	Integer TIPO_ID_ASIGNACION_ESTUDIANTE;

	@Value("${tipo.label.asignacion.revisor}")
	String TIPO_LABEL_ASIGNACION_REVISOR;

	@Value("${tipo.label.asignacion.lectorplan}")
	String TIPO_LABEL_ASIGNACION_LECTORPLAN;

	@Value("${tipo.label.asignacion.lectorproyecto}")
	String TIPO_LABEL_ASIGNACION_LECTORPROYECTO;

	@Value("${tipo.label.asignacion.estudiante}")
	String TIPO_LABEL_ASIGNACION_ESTUDIANTE;

	@Value("${perfil.label.estudiante}")
	String TIPO_LABEL_PERFIL_ESTUDIANTE;

	@Value("${perfil.label.docente}")
	String TIPO_LABEL_PERFIL_DOCENTE;

	@Value("${perfil.label.unidad}")
	String TIPO_LABEL_PERFIL_UNIDAD;

	@Value("${tipo.id.opciontitulacion.proyecto}")
	Integer TIPO_ID_OPCIONTITULACION_PROYECTO;

	@Value("${tipo.id.opciontitulacion.articulo}")
	Integer TIPO_ID_OPCIONTITULACION_ARTICULO;

	@Value("${tipo.id.opciontitulacion.examen}")
	Integer TIPO_ID_OPCIONTITULACION_EXAMEN;

	@Value("${estado.id.presolicitud.enviado}")
	Integer ESTADO_PRESOLICITUD_ENVIADO;

	@Value("${estado.id.presolicitud.aprobado}")
	Integer ESTADO_PRESOLICITUD_APROBADO;

	@Value("${estado.id.presolicitud.enlistaespera}")
	Integer ESTADO_PRESOLICITUD_ENLISTAESPERA;

	@Value("${estado.id.presolicitud.negado}")
	Integer ESTADO_PRESOLICITUD_NEGADO;

	@Value("${estado.id.presolicitud.prerevisado}")
	Integer ESTADO_PRESOLICITUD_PREREVISADO;

	@Value("${estado.id.presolicitud.falta}")
	Integer ESTADO_PRESOLICITUD_FALTA;

	@Value("${estado.id.presolicitud.renuncia}")
	Integer ESTADO_PRESOLICITUD_RENUNCIA;

	@Value("${estado.id.tema.creado}")
	Integer ESTADO_TEMA_PRE_CREADO;

	@Value("${estado.id.tema.enviado}")
	Integer ESTADO_TEMA_PRE_ENVIADO;

	@Value("${estado.id.tema.asignarevisor}")
	Integer ESTADO_TEMA_PRE_ASIGNAREVISOR;

	@Value("${estado.id.tema.revision}")
	Integer ESTADO_TEMA_PRE_REVISION;

	@Value("${estado.id.tema.revisado}")
	Integer ESTADO_TEMA_PRE_REVISADO;

	@Value("${estado.id.tema.publicado}")
	Integer ESTADO_TEMA_PRE_PUBLICADO;

	@Value("${estado.id.tema.asignaestudiante}")
	Integer ESTADO_TEMA_PRE_ASIGNAESTUDIANTE;

	@Value("${estado.id.tema.asignalector}")
	Integer ESTADO_TEMA_PRE_ASIGNALECTOR;

	@Value("${estado.id.tema.terminalector}")
	Integer ESTADO_TEMA_PRE_TERMINALECTOR;

	@Value("${estado.id.tema.asigna.estudiante}")
	Integer ESTADO_TEMA_PRE_ASIGNA_ESTUDIANTE;

	@Value("${estado.id.tema.asigna.lectorplan}")
	Integer ESTADO_TEMA_PRE_ASIGNA_LECTORPLAN;

	@Value("${estado.id.tema.asigna.lectorproyecto}")
	Integer ESTADO_TEMA_PRE_ASIGNA_LECTORPROYECTO;

	@Value("${estado.id.tema.lector.proceso}")
	Integer ESTADO_ID_TEMA_LECTOR_PROCESO;

	@Value("${estado.id.tema.lector.terminado}")
	Integer ESTADO_ID_TEMA_LECTOR_TERMINADO;

	@Value("${estado.label.tema.lector.proceso}")
	String ESTADO_LABEL_TEMA_LECTOR_PROCESO;

	@Value("${estado.label.tema.lector.terminado}")
	String ESTADO_LABEL_TEMA_LECTOR_TERMINADO;

	@Value("${estado.id.tema.revisa.proceso}")
	Integer ESTADO_ID_TEMA_REVISA_PROCESO;

	@Value("${estado.id.tema.revisa.revisado}")
	Integer ESTADO_ID_TEMA_REVISA_REVISADO;

	@Value("${estado.id.tema.revisa.terminado}")
	Integer ESTADO_ID_TEMA_REVISA_TERMINADO;

	@Value("${estado.label.tema.revisa.proceso}")
	String ESTADO_LABEL_TEMA_REVISA_PROCESO;

	@Value("${estado.label.tema.revisa.revisado}")
	String ESTADO_LABEL_TEMA_REVISA_REVISADO;

	@Value("${estado.label.tema.revisa.terminado}")
	String ESTADO_LABEL_TEMA_REVISA_TERMINADO;

	@Value("${estado.id.tema.aprobado}")
	Integer ESTADO_TEMA_POST_APROBADO;

	@Value("${estado.id.tema.cerrado}")
	Integer ESTADO_TEMA_POST_CERRADO;

	@Value("${estado.id.tema.anulado}")
	Integer ESTADO_TEMA_POST_ANULADO;

	@Value("${estado.id.tema.prorroga}")
	Integer ESTADO_TEMA_POST_PRORROGA;

	@Value("${estado.id.tema.lectorproyecto}")
	Integer ESTADO_TEMA_POST_LECTORPROYECTO;

	@Value("${estado.id.tema.cambiotutor}")
	Integer ESTADO_TEMA_POST_CAMBIOTUTOR;

	@Value("${estado.id.tema.cambiotema}")
	Integer ESTADO_TEMA_POST_CAMBIOTEMA;

	@Value("${estado.id.tema.renunciaestudiante}")
	Integer ESTADO_TEMA_POST_RENUNCIAESTUDIANTE;

	@Value("${estado.id.evolucion.creado}")
	Integer ESTADO_EVOLUCION_CREADO;

	@Value("${estado.id.evolucion.asistencia}")
	Integer ESTADO_EVOLUCION_ASISTENCIA;

	@Value("${estado.id.evolucion.noasistencia}")
	Integer ESTADO_EVOLUCION_NOASISTENCIA;

	@Value("${estado.id.evolucion.reagenda}")
	Integer ESTADO_EVOLUCION_REAGENDA;

	@Value("${estado.label.evolucion.creado}")
	String ESTADO_LABEL_EVOLUCION_CREADO;

	@Value("${estado.label.evolucion.asistencia}")
	String ESTADO_LABEL_EVOLUCION_ASISTENCIA;

	@Value("${estado.label.evolucion.noasistencia}")
	String ESTADO_LABEL_EVOLUCION_NOASISTENCIA;

	@Value("${estado.label.evolucion.reagenda}")
	String ESTADO_LABEL_EVOLUCION_REAGENDA;

	@Value("${estado.id.hito.creado}")
	Integer ESTADO_HITO_CREADO;

	@Value("${estado.id.hito.cumplido}")
	Integer ESTADO_HITO_CUMPLE;

	@Value("${estado.id.hito.nocumplido}")
	Integer ESTADO_HITO_NOCUMPLE;

	@Value("${estado.id.resolucion.creado}")
	Integer ESTADO_RESOLUCION_CREADO;

	@Value("${estado.id.resolucion.procesado}")
	Integer ESTADO_RESOLUCION_PROCESADO;

	@Value("${config.campo.temaenviado}")
	String CONFIG_TEMA_ENVIADO;

	@Value("${config.campo.asignatemarevisor}")
	String CONFIG_ASIGNA_TEMAREVISOR;

	@Value("${config.campo.temainformeautor}")
	String CONFIG_TEMA_INFORMEAUTOR;

	@Value("${config.campo.temapublicadoautor}")
	String CONFIG_TEMA_PUBLICACIONAUTOR;

	@Value("${config.campo.asignatemaestudiante}")
	String CONFIG_ASIGNA_TEMAESTUDIANTE;

	@Value("${config.campo.desvinculatemaestudiante}")
	String CONFIG_DESVINCULA_TEMAESTUDIANTE;

	@Value("${config.campo.asignalectorplanestudiante}")
	String CONFIG_ASIGNA_LECTORPLANESTUDIANTE;

	@Value("${config.campo.asignalectorplanautor}")
	String CONFIG_ASIGNA_LECTORPLANAUTOR;

	@Value("${config.campo.asignalectorplanlector}")
	String CONFIG_ASIGNA_LECTORPLANLECTOR;

	@Value("${config.campo.resolucionautor}")
	String CONFIG_RESOLUCION_AUTOR;

	@Value("${config.campo.resolucionestudiante}")
	String CONFIG_RESOLUCION_ESTUDIANTE;

	@Value("${config.campo.resolucionlector}")
	String CONFIG_RESOLUCION_LECTOR;

	@Value("${config.campo.resolucionnuevoautor}")
	String CONFIG_RESOLUCION_NUEVOAUTOR;

	@Value("${estado.label.tema.creado}")
	String ESTADO_LABEL_TEMA_CREADO;

	@Value("${estado.label.tema.enviado}")
	String ESTADO_LABEL_TEMA_ENVIADO;

	@Value("${estado.label.tema.asignarevisor}")
	String ESTADO_LABEL_TEMA_ASIGNAREVISOR;

	@Value("${estado.label.tema.revision}")
	String ESTADO_LABEL_TEMA_ENREVISION;

	@Value("${estado.label.tema.revisado}")
	String ESTADO_LABEL_TEMA_REVISADO;

	@Value("${estado.label.tema.publicado}")
	String ESTADO_LABEL_TEMA_PUBLICADO;

	@Value("${estado.label.tema.asignaestudiante}")
	String ESTADO_LABEL_TEMA_ASIGNAESTUDIANTE;

	@Value("${estado.label.tema.asignalector}")
	String ESTADO_LABEL_TEMA_ASIGNALECTOR;

	@Value("${estado.label.tema.terminalector}")
	String ESTADO_LABEL_TEMA_TERMINALECTOR;

	@Value("${estado.fase.preresolucion}")
	String ESTADO_FASE_PRERESOLUCION;

	@Value("${estado.fase.postresolucion}")
	String ESTADO_FASE_POSTRESOLUCION;

	@Value("${estado.fase.presolicitud}")
	String ESTADO_FASE_PRESOLICITUD;

	@Value("${estado.fase.evolucion}")
	String ESTADO_FASE_EVOLUCION;

	@Value("${estado.fase.hito}")
	String ESTADO_FASE_HITO;

	@Value("${estado.fase.asignacion}")
	String ESTADO_FASE_ASIGNACION;

	@Value("${estado.fase.revisor}")
	String ESTADO_FASE_REVISOR;

	@Value("${tipo.label.opciontitulacion.proyecto}")
	String TIPO_LABEL_TITULACION_PROYECTO;

	@Value("${tipo.label.opciontitulacion.articulo}")
	String TIPO_LABEL_TITULACION_ARTICULO;

	@Value("${tipo.label.opciontitulacion.examen}")
	String TIPO_LABEL_TITULACION_EXAMEN;

	@Value("${estado.label.presolicitud.enviado}")
	String ESTADO_LABEL_PRESOLICITUD_ENVIADO;

	@Value("${estado.label.presolicitud.aprobado}")
	String ESTADO_LABEL_PRESOLICITUD_APROBADO;

	@Value("${estado.label.presolicitud.enlistaespera}")
	String ESTADO_LABEL_PRESOLICITUD_LISTAESPERA;

	@Value("${estado.label.presolicitud.negado}")
	String ESTADO_LABEL_PRESOLICITUD_NEGADO;

	@Value("${estado.label.presolicitud.prerevisado}")
	String ESTADO_LABEL_PRESOLICITUD_REVISIONPREVIA;

	@Value("${estado.label.presolicitud.falta}")
	String ESTADO_LABEL_PRESOLICITUD_FALTA;

	@Value("${estado.label.presolicitud.renuncia}")
	String ESTADO_LABEL_PRESOLICITUD_RENUNCIA;

	@Value("${estado.label.tema.aprobado}")
	String ESTADO_LABEL_TEMA_APROBADO;

	@Value("${estado.label.tema.cerrado}")
	String ESTADO_LABEL_TEMA_CERRADO;

	@Value("${estado.label.tema.anulado}")
	String ESTADO_LABEL_TEMA_ANULADO;

	@Value("${estado.label.tema.prorroga}")
	String ESTADO_LABEL_TEMA_PRORROGA;

	@Value("${estado.label.tema.lectorproyecto}")
	String ESTADO_LABEL_TEMA_LECTORPROYECTO;

	@Value("${estado.label.tema.cambiotutor}")
	String ESTADO_LABEL_TEMA_CAMBIOTUTOR;

	@Value("${estado.label.tema.cambiotema}")
	String ESTADO_LABEL_TEMA_CAMBIOTEMA;

	@Value("${estado.label.tema.renunciaestudiante}")
	String ESTADO_LABEL_TEMA_RENUNCIAESTUDIANTE;

	@Value("${estado.label.hito.creado}")
	String ESTADO_LABEL_HITO_CREADO;

	@Value("${estado.label.hito.cumplido}")
	String ESTADO_LABEL_HITO_CUMPLIDO;

	@Value("${estado.label.hito.nocumplido}")
	String ESTADO_LABEL_HITO_NOCUMPLIDO;

}
