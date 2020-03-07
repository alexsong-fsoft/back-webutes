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

import com.utes.spring.web.app.dto.CorreoDTO;
import com.utes.spring.web.app.service.CorreoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/correo")
public class CorreoWSRestController {

	@Autowired
	private CorreoService correoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody CorreoDTO correoDto) {
		return correoService.create(correoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody CorreoDTO correoDto) {
		return correoService.update(correoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return correoService.delete(id);
	}

	@RequestMapping(value = "/obtenerCorreo", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<CorreoDTO> obtenerCorreo() {
		return correoService.obtenerCorreo(true);
	}

	@RequestMapping(value = "/obtenerCorreoPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody CorreoDTO obtenerCorreoPorId(@PathVariable(name = "id") Integer id) {
		return correoService.obtenerCorreoPorId(id);
	}

	@RequestMapping(value = "/obtenerListadoCorreoPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<CorreoDTO> obtenerListadoCorreoPorId(@PathVariable(name = "id") Integer id) {
		return correoService.obtenerListadoCorreoPorId(id);
	}
}
