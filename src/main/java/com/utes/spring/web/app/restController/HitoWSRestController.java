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

import com.utes.spring.web.app.dto.HitoDTO;
import com.utes.spring.web.app.service.HitoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/hito")
public class HitoWSRestController {

	@Autowired
	private HitoService hitoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody HitoDTO hitoDto) {
		return hitoService.create(hitoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody HitoDTO hitoDto) {
		return hitoService.update(hitoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return hitoService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoHito", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<HitoDTO> obtenerListadoHito() {
		return hitoService.obtenerListadoHito(true);
	}

	@RequestMapping(value = "/obtenerHito/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody HitoDTO obtenerHito(@PathVariable(name = "id") Integer id) {
		return hitoService.obtenerHito(id);
	}

	@RequestMapping(value = "/obtenerHitoxTema/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<HitoDTO> obtenerHitoxTema(@PathVariable(name = "idtema") Integer idtema) {
		return hitoService.obtenerHitoxTema(idtema);
	}

	@RequestMapping(value = "/obtenerEntidadaHitoxTema/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody HitoDTO obtenerEntidadaHitoxTema(@PathVariable(name = "idtema") Integer idtema) {
		return hitoService.obtenerEntidadaHitoxTema(idtema);
	}

	@RequestMapping(value = "/obtenerSecuencialHito/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerSecuencialHito(@PathVariable(name = "idtema") Integer idtema) {
		return hitoService.obtenerSecuencialHito(idtema);
	}

}
