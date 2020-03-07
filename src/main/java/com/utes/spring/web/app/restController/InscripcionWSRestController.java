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

import com.utes.spring.web.app.dto.InscripcionDTO;
import com.utes.spring.web.app.service.InscripcionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/inscripcion")
public class InscripcionWSRestController {

	@Autowired
	private InscripcionService inscripcionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody InscripcionDTO inscripcionDto) {
		return inscripcionService.create(inscripcionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody InscripcionDTO inscripcionDto) {
		return inscripcionService.update(inscripcionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return inscripcionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoInscripcion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<InscripcionDTO> obtenerListadoInscripcion() {
		return inscripcionService.obtenerListadoInscripcion();
	}

	@RequestMapping(value = "/obtenerInscripcionPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody InscripcionDTO obtenerInscripcionPorId(@PathVariable(name = "id") Integer id) {
		return inscripcionService.obtenerInscripcionPorId(id);
	}

	@RequestMapping(value = "/obtenerListadoInscripcionPorEstado", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<InscripcionDTO> obtenerListadoInscripcionPorEstado() {
		return inscripcionService.obtenerListadoInscripcionPorEstado(true);
	}

	@RequestMapping(value = "/obtenerUltimoRegistroInscripcion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerUltimoRegistroInscripcion() {
		return inscripcionService.obtenerUltimoRegistroInscripcion();
	}

	@RequestMapping(value = "/obtenerSecuencialInscripcion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerSecuencialInscripcion() {
		return inscripcionService.obtenerSecuencialInscripcion();
	}

	@RequestMapping(value = "/obtenerInscripcionActivaMaxSecuencial", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerInscripcionActivaMaxSecuencial() {
		return inscripcionService.obtenerInscripcionActivaMaxSecuencial();
	}

	@RequestMapping(value = "/obtenerInscripcionPorPeriodo/{idperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody InscripcionDTO obtenerInscripcionPorPeriodo(
			@PathVariable(name = "idperiodo") Integer idperiodo) {
		return inscripcionService.obtenerInscripcionPorPeriodo(idperiodo);
	}

}
