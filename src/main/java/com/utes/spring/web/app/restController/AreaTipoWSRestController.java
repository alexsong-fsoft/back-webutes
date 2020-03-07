package com.utes.spring.web.app.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.utes.spring.web.app.dto.AreaTipoDTO;
import com.utes.spring.web.app.service.AreaTipoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/areatipo")
public class AreaTipoWSRestController {

	@Autowired
	private AreaTipoService areaTipoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody boolean create(@RequestBody AreaTipoDTO areaTipoDto) {
		return areaTipoService.create(areaTipoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody boolean update(@RequestBody AreaTipoDTO areaTipoDto) {
		return areaTipoService.update(areaTipoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return areaTipoService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoAreaTipo", method = RequestMethod.GET)
	public @ResponseBody List<AreaTipoDTO> obtenerListadoAreaTipo() {
		return areaTipoService.obtenerListadoAreaTipo(true);
	}

	@RequestMapping(value = "/obtenerAreaTipo/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AreaTipoDTO obtenerAreaTipo(@PathVariable(name = "id") Integer id) {
		return areaTipoService.obtenerAreaTipo(id);
	}

	@RequestMapping(value = "/obtenerListadoAreatipo/{idtipo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaTipoDTO> obtenerListadoAreatipo(@PathVariable(name = "idtipo") Integer idtipo) {
		return areaTipoService.obtenerListadoAreaTipo(idtipo, true);
	}

}
