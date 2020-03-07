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

import com.utes.spring.web.app.dto.SysConfiguracionDTO;
import com.utes.spring.web.app.service.SysConfiguracionService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysConfiguracion")
public class SysConfiguracionWSRestController {

	@Autowired
	private SysConfiguracionService sysConfiguracionService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysConfiguracionDTO sysConfiguracionDto) {
		return sysConfiguracionService.create(sysConfiguracionDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysConfiguracionDTO sysConfiguracionDto) {
		return sysConfiguracionService.update(sysConfiguracionDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysConfiguracionService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoSysConfiguracion", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysConfiguracionDTO> obtenerListadoSysConfiguracion() {
		return sysConfiguracionService.obtenerListadoSysConfiguracion(true);
	}

	@RequestMapping(value = "/obtenerConfiguracionbyPk/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysConfiguracionDTO obtenerConfiguracionbyPk(@PathVariable(name = "id") Integer id) {
		return sysConfiguracionService.obtenerConfiguracionbyPk(id);
	}

	@RequestMapping(value = "/obtenerConfiguracionbyTipo/{tipo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysConfiguracionDTO> obtenerConfiguracionbyTipo(
			@PathVariable(name = "tipo") String tipo) {
		return sysConfiguracionService.obtenerConfiguracionbyTipo(tipo);
	}

	@RequestMapping(value = "/obtenerConfiguracionbyCampo/{campo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysConfiguracionDTO obtenerConfiguracionbyCampo(@PathVariable(name = "campo") String campo) {
		return sysConfiguracionService.obtenerConfiguracionbyCampo(campo);
	}

	@RequestMapping(value = "/activaProcesoByCampo/{campo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean activaProcesoByCampo(@PathVariable(name = "campo") String campo) {
		return sysConfiguracionService.activaProcesoByCampo(campo);
	}
}
