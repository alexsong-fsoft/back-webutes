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

import com.utes.spring.web.app.dto.CuestionarioDTO;
import com.utes.spring.web.app.service.CuestionarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/cuestionario")
public class CuestionarioWSRestController {

	@Autowired
	private CuestionarioService cuestionarioService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody CuestionarioDTO cuestionarioDto) {
		return cuestionarioService.create(cuestionarioDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody CuestionarioDTO cuestionarioDto) {
		return cuestionarioService.update(cuestionarioDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return cuestionarioService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoCuestionario", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<CuestionarioDTO> obtenerListadoCuestionario() {
		return cuestionarioService.obtenerListadoCuestionario();
	}

	@RequestMapping(value = "/obtenerCuestionario/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody CuestionarioDTO obtenerCuestionario(@PathVariable(name = "id") Integer id) {
		return cuestionarioService.obtenerCuestionario(id);
	}

	@RequestMapping(value = "/obtenerListadoCuestionarioPorEstado", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<CuestionarioDTO> obtenerListadoCuestionarioPorEstado() {
		return cuestionarioService.obtenerListadoCuestionarioPorEstado(true);
	}

	@RequestMapping(value = "/obtenerListadoCuestionarioPorEstadoTipo/{idsTipos}/{idinscripcion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<CuestionarioDTO> obtenerListadoCuestionarioPorEstadoTipo(
			@PathVariable(name = "idsTipos") String idsTipos,
			@PathVariable(name = "idinscripcion") Integer idinscripcion) {
		return cuestionarioService.obtenerListadoCuestionarioPorEstadoTipo(true, idsTipos, idinscripcion);
	}
}
