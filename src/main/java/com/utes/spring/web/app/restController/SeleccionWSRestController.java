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

import com.utes.spring.web.app.dto.SeleccionDTO;
import com.utes.spring.web.app.service.SeleccionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/seleccion")
public class SeleccionWSRestController {

	@Autowired
	private SeleccionService seleccionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SeleccionDTO seleccionDto) {
		return seleccionService.create(seleccionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SeleccionDTO seleccionDto) {
		return seleccionService.update(seleccionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return seleccionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoSeleccion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SeleccionDTO> obtenerListadoSeleccion() {
		return seleccionService.obtenerListadoSeleccion(true);
	}

	@RequestMapping(value = "/obtenerSeleccion/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SeleccionDTO obtenerSeleccion(@PathVariable(name = "id") Integer id) {
		return seleccionService.obtenerSeleccion(id);
	}

	@RequestMapping(value = "/obtenerListadoPeriodo/{fkperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SeleccionDTO> obtenerListadoPeriodo(@PathVariable(name = "fkperiodo") Integer fkperiodo) {
		return seleccionService.obtenerListadoPeriodo(fkperiodo);
	}

	@RequestMapping(value = "/obtenerSeleccionPorPeriodoPersona/{periodonum}/{fkpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SeleccionDTO obtenerSeleccionPorPeriodoPersona(
			@PathVariable(name = "periodonum") Integer periodonum,
			@PathVariable(name = "fkpersona") Integer fkpersona) {
		return seleccionService.obtenerSeleccionPorPeriodoPersona(periodonum, fkpersona);
	}

	@RequestMapping(value = "/obtenerSeleccionPorIdPeriodoPersona/{idperiodo}({fkpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SeleccionDTO obtenerSeleccionPorIdPeriodoPersona(
			@PathVariable(name = "idperiodo") Integer idperiodo, @PathVariable(name = "fkpersona") Integer fkpersona) {
		return seleccionService.obtenerSeleccionPorIdPeriodoPersona(idperiodo, fkpersona);
	}
}
