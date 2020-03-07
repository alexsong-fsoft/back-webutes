package com.utes.spring.web.app.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utes.spring.web.app.dto.AsignadoDTO;
import com.utes.spring.web.app.service.AsignadoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/asignado")
public class AsignadoWSRestController {

	@Autowired
	private AsignadoService asignadoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody AsignadoDTO asignadoDto) {
		return asignadoService.create(asignadoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody AsignadoDTO asignadoDto) {
		return asignadoService.update(asignadoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return asignadoService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoAsignado", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerListadoAsignado() {
		return asignadoService.obtenerListadoAsignado(true);
	}

	@RequestMapping(value = "/obtenerEntidadAsignadoxId/{idasignado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerEntidadAsignadoxId(@PathVariable(name = "idasignado") Integer idasignado) {
		return asignadoService.obtenerEntidadAsignadoxId(idasignado);
	}

	@RequestMapping(value = "/obtenerAsignadoDTOxTemaPersona/{idtema}/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoDTOxTemaPersona(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idpersona") Integer idpersona) {
		return asignadoService.obtenerAsignadoDTOxTemaPersona(idtema, idpersona);
	}

	@RequestMapping(value = "/obtenerAsignadoxTemaCedula/{ced}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoxTemaCedula(@PathVariable(name = "ced") String ced) {
		return asignadoService.obtenerAsignadoxTemaCedula(ced);
	}

	@RequestMapping(value = "/obtenerEntidadAsignadoxTemaCedula/{ced}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerEntidadAsignadoxTemaCedula(@PathVariable(name = "ced") String ced) {
		return asignadoService.obtenerEntidadAsignadoxTemaCedula(ced);
	}

	@RequestMapping(value = "/obtenerAsignadoxTema/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoxTema(@PathVariable(name = "idtema") Integer idtema) {
		return asignadoService.obtenerAsignadoxTema(idtema);
	}

	@RequestMapping(value = "/obtenerAsignadoxTema/{idtema}/{idtipo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoxTema(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idtipo") Integer idtipo) {
		return asignadoService.obtenerAsignadoxTema(idtema, idtipo);
	}

	@RequestMapping(value = "/obtenerAsignadoxTemaPersonaVerifica/{idtema}/{idtipo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerAsignadoxTemaPersonaVerifica(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idtipo") Integer idtipo) {
		return asignadoService.obtenerAsignadoxTemaPersonaVerifica(idtema, idtipo);
	}

	@RequestMapping(value = "/obtenerAsignadoxIdstema/{idstema}/{idestado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoxIdstema(@PathVariable(name = "idstema") String idstema,
			@PathVariable(name = "idestado") Integer idestado) {
		return asignadoService.obtenerAsignadoxIdsTema(idstema, idestado);
	}

	@RequestMapping(value = "/obtenerAsignadoxEstado/{idestado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoxEstado(@PathVariable(name = "idestado") Integer idestado) {
		return asignadoService.obtenerAsignadoxEstado(idestado);
	}

	@RequestMapping(value = "/obtenerEntidadAsignadoxIdPersona/{idpersona}/{idtipoasignacion}/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerEntidadAsignadoxIdPersona(
			@PathVariable(name = "idpersona") Integer idpersona,
			@PathVariable(name = "idtipoasignacion") String idtipoasignacion,
			@PathVariable(name = "idtema") Integer idtema) {
		return asignadoService.obtenerEntidadAsignadoxIdPersona(idpersona, idtipoasignacion, idtema);
	}

	@RequestMapping(value = "/obtenerEntidadAsignadoxIdPersona/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerEntidadAsignadoxIdPersona(
			@PathVariable(name = "idpersona") Integer idpersona) {
		return asignadoService.obtenerEntidadAsignadoxIdPersona(idpersona);
	}

	@RequestMapping(value = "/obtenerEntidadAsignadoxIdPersona/{idpersona}/{idtipoasignacion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerEntidadAsignadoxIdPersona(
			@PathVariable(name = "idpersona") Integer idpersona,
			@PathVariable(name = "idtipoasignacion") Integer idtipoasignacion) {
		return asignadoService.obtenerEntidadAsignadoxIdPersona(idpersona, idtipoasignacion);
	}

	@RequestMapping(value = "/obtenerListadoAsignadoxIdPersona/{idpersona}/{idtipoasignacion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerListadoAsignadoxIdPersona(
			@PathVariable(name = "idpersona") Integer idpersona,
			@PathVariable(name = "idtipoasignacion") Integer idtipoasignacion) {
		return asignadoService.obtenerListadoAsignadoxIdPersona(idpersona, idtipoasignacion);
	}

	@RequestMapping(value = "/obtenerCountAsignado/{idpersona}/{idtipo}/{estadoaccion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerCountAsignado(@PathVariable(name = "idpersona") Integer idpersona,
			@PathVariable(name = "idtipo") Integer idtipo, @PathVariable(name = "estadoaccion") Integer estadoaccion) {
		return asignadoService.obtenerCount(idpersona, idtipo, estadoaccion);
	}

	@RequestMapping(value = "/obtenerAsignadoxTemaPersonaVerificaAsignadoRevisor/{idpersona}/{idtema}/{idestadorev}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerAsignadoxTemaPersonaVerificaAsignadoRevisor(
			@PathVariable(name = "idpersona") Integer idpersona, @PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idestadorev") Integer idestadorev) {
		return asignadoService.obtenerAsignadoxTemaPersonaVerificaAsignadoRevisor(idtema, idpersona, idestadorev);
	}

	@RequestMapping(value = "/obtenerAsignadoxTemaPersonaVerificaAsignadoTipo/{idpersona}/{idtema}/{idtipo}/{estadorevision}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AsignadoDTO obtenerAsignadoxTemaPersonaVerificaAsignadoTipo(
			@PathVariable(name = "idpersona") Integer idpersona, @PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idtipo") Integer idtipo,
			@PathVariable(name = "estadorevision") Integer estadorevision) {
		return asignadoService.obtenerAsignadoxTemaPersonaVerificaAsignadoTipo(idtema, idpersona, idtipo,
				estadorevision);
	}

	@RequestMapping(value = "/obtenerIdAsignadoxTemaUltimoEstado/{idpersona}/{idtema}/{idtipo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerIdAsignadoxTemaUltimoEstado(@PathVariable(name = "idpersona") Integer idpersona,
			@PathVariable(name = "idtema") Integer idtema, @PathVariable(name = "idtipo") Integer idtipo) {
		return asignadoService.obtenerIdAsignadoxTemaUltimoEstado(idtema, idpersona, idtipo);
	}

	@RequestMapping(value = "/obtenerAsignadoxIdsTipos/{idstema}/{idtipoasig}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AsignadoDTO> obtenerAsignadoxIdsTipos(@PathVariable(name = "idstema") String idstema,
			@PathVariable(name = "idtipoasig") String idtipoasig) {
		return asignadoService.obtenerAsignadoxIdsTipos(idstema, idtipoasig);
	}

}
