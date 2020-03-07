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

import com.utes.spring.web.app.dto.AreaPersonaDTO;
import com.utes.spring.web.app.service.AreaPersonaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/areapersona")
public class AreaPersonaWSRestController {

	@Autowired
	private AreaPersonaService areaPersonaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody AreaPersonaDTO areaPersonaDto) {
		return areaPersonaService.create(areaPersonaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody AreaPersonaDTO areaPersonaDto) {
		return areaPersonaService.update(areaPersonaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return areaPersonaService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoAreaPersona", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaPersonaDTO> obtenerListadoAreaPersona() {
		return areaPersonaService.obtenerListadoAreaPersona(true);
	}

	@RequestMapping(value = "/obtenerAreaPersona/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AreaPersonaDTO obtenerAreaPersona(@PathVariable(name = "id") Integer id) {
		return areaPersonaService.obtenerAreaPersona(id);
	}

	@RequestMapping(value = "/obtenerListadoAreapersonaxPersona/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaPersonaDTO> obtenerListadoAreapersonaxPersona(
			@PathVariable(name = "idpersona") Integer idpersona) {
		return areaPersonaService.obtenerListadoAreapersonaxPersona(idpersona, true);
	}

	@RequestMapping(value = "/obtenerListadoAreapersonaxPersona/{idpersona}/{idarea}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AreaPersonaDTO obtenerListadoAreapersonaxPersona(
			@PathVariable(name = "idpersona") Integer idpersona, @PathVariable(name = "idarea") Integer idarea) {
		return areaPersonaService.obtenerListadoAreapersonaxPersona(idpersona, idarea, true);
	}

	@RequestMapping(value = "/obtenerListadoAreapersonaxPersona/{ids}/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaPersonaDTO> obtenerListadoAreapersonaxPersona(@PathVariable(name = "ids") String ids,
			@PathVariable(name = "idpersona") Integer idpersona) {
		return areaPersonaService.obtenerListadoAreapersonaxPersona(ids, idpersona, true);
	}
}
