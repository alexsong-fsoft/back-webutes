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

import com.utes.spring.web.app.dto.RespuestaDTO;
import com.utes.spring.web.app.service.RespuestaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/respuesta")
public class RespuestaWSRestController {

	@Autowired
	private RespuestaService respuestaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody RespuestaDTO respuestaDto) {
		return respuestaService.create(respuestaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody RespuestaDTO respuestaDto) {
		return respuestaService.update(respuestaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return respuestaService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoRespuesta", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<RespuestaDTO> obtenerListadoRespuesta() {
		return respuestaService.obtenerListadoRespuesta();
	}

	@RequestMapping(value = "/obtenerRespuesta/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody RespuestaDTO obtenerRespuesta(@PathVariable(name = "id") Integer id) {
		return respuestaService.obtenerRespuesta(id);
	}

	@RequestMapping(value = "/obtenerListadoRespuestaPorIdPresolicitud/{idpresolicitud}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<RespuestaDTO> obtenerListadoRespuestaPorIdPresolicitud(
			@PathVariable(name = "idpresolicitud") Integer idpresolicitud) {
		return respuestaService.obtenerListadoRespuestaPorIdPresolicitud(idpresolicitud);
	}

	@RequestMapping(value = "/obtenerRespuestaPorIds/{idpresolicitud}/{idcuestionario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody RespuestaDTO obtenerRespuestaPorIds(
			@PathVariable(name = "idpresolicitud") Integer idpresolicitud,
			@PathVariable(name = "idcuestionario") Integer idcuestionario) {
		return respuestaService.obtenerRespuestaPorIds(idpresolicitud, idcuestionario);
	}
}
