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

import com.utes.spring.web.app.dto.TipoOpcionDTO;
import com.utes.spring.web.app.service.TipoOpcionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/tipoOpcion")
public class TipoOpcionWSRestController {

	@Autowired
	private TipoOpcionService tipoOpcionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody TipoOpcionDTO tipoOpcionDto) {
		return tipoOpcionService.create(tipoOpcionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody TipoOpcionDTO tipoOpcionDto) {
		return tipoOpcionService.update(tipoOpcionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return tipoOpcionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoTipoOpcion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TipoOpcionDTO> obtenerListadoTipoOpcion() {
		return tipoOpcionService.obtenerListadoTipoOpcion(true);
	}

	@RequestMapping(value = "/obtenerTipoOpcion/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody TipoOpcionDTO obtenerTipoOpcion(@PathVariable(name = "id") Integer id) {
		return tipoOpcionService.obtenerTipoOpcion(id);
	}

}
