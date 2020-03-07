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

import com.utes.spring.web.app.dto.ResolucionDTO;
import com.utes.spring.web.app.service.ResolucionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/resolucion")
public class ResolucionWSRestController {
	@Autowired
	private ResolucionService resolucionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody ResolucionDTO resolucionDto) {
		return resolucionService.create(resolucionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody ResolucionDTO resolucionDto) {
		return resolucionService.update(resolucionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return resolucionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoResolucion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<ResolucionDTO> obtenerListadoResolucion() {
		return resolucionService.obtenerListadoResolucion(true);
	}

	@RequestMapping(value = "/obtenerResolucionxId/{idresolucion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody ResolucionDTO obtenerResolucionxId(@PathVariable(name = "idresolucion") Integer idresolucion) {
		return resolucionService.obtenerResolucionxId(idresolucion);
	}

	@RequestMapping(value = "/obtenerResolucionxTema/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<ResolucionDTO> obtenerResolucionxTema(@PathVariable(name = "idtema") Integer idtema) {
		return resolucionService.obtenerResolucionxTema(idtema);
	}

	@RequestMapping(value = "/obtenerResolucionxTemaIdTipoRes/{idtema}/{idtipores}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody ResolucionDTO obtenerResolucionxTemaIdTipoRes(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idtipores") Integer idtipores) {
		return resolucionService.obtenerResolucionxTemaIdTipoRes(idtema, idtipores);
	}

	@RequestMapping(value = "/obtenerResolucionxTemaEstadoresolucion/{idtema}/{idtipores}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<ResolucionDTO> obtenerResolucionxTemaEstadoresolucion(
			@PathVariable(name = "idtema") Integer idtema, @PathVariable(name = "idtipores") Integer idtipores) {
		return resolucionService.obtenerResolucionxTemaEstadoresolucion(idtema, idtipores);
	}

	@RequestMapping(value = "/obtenerResolucionxPersona/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<ResolucionDTO> obtenerResolucionxPersona(
			@PathVariable(name = "idpersona") Integer idpersona) {
		return resolucionService.obtenerResolucionxPersona(idpersona);
	}

//	@RequestMapping(value = "/obtenerResolucionxTema/{idtema}/{idtipores}", method = RequestMethod.GET, produces = {
//			"application/json" + ";charset=utf-8" })
//	public @ResponseBody List<ResolucionDTO> obtenerResolucionxTema(@PathVariable(name = "idtema") Integer idtema, @PathVariable(name = "idtipores") Integer idtipores) {
//		return resolucionService.obtenerResolucionxTema(idtema, idtipores);
//	}
}
