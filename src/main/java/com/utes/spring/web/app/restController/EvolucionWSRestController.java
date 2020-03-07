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

import com.utes.spring.web.app.dto.EvolucionDTO;
import com.utes.spring.web.app.service.EvolucionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/evolucion")
public class EvolucionWSRestController {

	@Autowired
	private EvolucionService evolucionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody EvolucionDTO evolucionDto) {
		return evolucionService.create(evolucionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody EvolucionDTO evolucionDto) {
		return evolucionService.update(evolucionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return evolucionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoEvolucion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<EvolucionDTO> obtenerListadoEvolucion() {
		return evolucionService.obtenerListadoEvolucion(true);
	}

	@RequestMapping(value = "/obtenerEntidadaEvolucionPorId/{idevolucion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody EvolucionDTO obtenerEntidadaEvolucionPorId(
			@PathVariable(name = "idevolucion") Integer idevolucion) {
		return evolucionService.obtenerEntidadaEvolucionPorId(idevolucion);
	}

	@RequestMapping(value = "/obtenerEvolucionxTema/{idTema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<EvolucionDTO> obtenerEvolucionxTema(@PathVariable(name = "idTema") Integer idTema) {
		return evolucionService.obtenerEvolucionxTema(idTema);
	}

	@RequestMapping(value = "/obtenerEntidadaEvolucionxTema/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody EvolucionDTO obtenerEntidadaEvolucionxTema(@PathVariable(name = "id") Integer id) {
		return evolucionService.obtenerEntidadaEvolucionxTema(id);
	}

	@RequestMapping(value = "/obtenerSecuencialEvolucion/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerSecuencialEvolucion(@PathVariable(name = "idtema") Integer idtema) {
		return evolucionService.obtenerSecuencialEvolucion(idtema);
	}

	@RequestMapping(value = "/obtenerUltimoRegistroporTema/{idtema}/{idestadoevolucion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerUltimoRegistroporTema(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idestadoevolucion") Integer idestadoevolucion) {
		return evolucionService.obtenerUltimoRegistroporTema(idtema, idestadoevolucion);
	}

//	@RequestMapping(value = "/obtenerEntidadaEvolucionPorFecha/{ids}", method = RequestMethod.GET, produces = {
//			"application/json" + ";charset=utf-8" })
//	public @ResponseBody List<EvolucionDTO> obtenerEntidadaEvolucionPorFecha(@PathVariable(name = "ids") String ids) {
//		return evolucionService.obtenerEntidadaEvolucionPorFecha(ids, true);
//	}
}
