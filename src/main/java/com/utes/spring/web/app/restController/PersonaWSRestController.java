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

import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.service.PersonaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/persona")
public class PersonaWSRestController {
	@Autowired
	private PersonaService personaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody PersonaDTO personaDto) {
		return personaService.create(personaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody PersonaDTO personaDto) {
		return personaService.update(personaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return personaService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoPersona", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PersonaDTO> obtenerListadoPersona() {
		return personaService.obtenerListadoPersona();
	}

	@RequestMapping(value = "/obtenerPersonaPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PersonaDTO obtenerPersonaPorId(@PathVariable(name = "id") Integer id) {
		return personaService.obtenerPersonaPorId(id);
	}

	@RequestMapping(value = "/obtenerPersonaPorCedula/{cedula}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PersonaDTO obtenerPersonaPorCedula(@PathVariable(name = "cedula") String cedula) {
		return personaService.obtenerPersonaPorCedula(cedula);
	}

}
