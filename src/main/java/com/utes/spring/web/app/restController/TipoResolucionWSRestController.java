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

import com.utes.spring.web.app.dto.TipoResolucionDTO;
import com.utes.spring.web.app.service.TipoResolucionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/tipoResolucion")
public class TipoResolucionWSRestController {

	@Autowired
	private TipoResolucionService tipoResolucionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody TipoResolucionDTO tipoResolucionDto) {
		return tipoResolucionService.create(tipoResolucionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody TipoResolucionDTO tipoResolucionDto) {
		return tipoResolucionService.update(tipoResolucionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return tipoResolucionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoTipoResolucion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TipoResolucionDTO> obtenerListadoTipoResolucion() {
		return tipoResolucionService.obtenerListadoTipoResolucion(true);
	}

	@RequestMapping(value = "/obtenerTipoResolucion/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody TipoResolucionDTO obtenerTipoResolucion(@PathVariable(name = "id") Integer id) {
		return tipoResolucionService.obtenerTipoResolucion(id);
	}

}
