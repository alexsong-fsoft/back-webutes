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

import com.utes.spring.web.app.dto.SysPropiedadesDTO;
import com.utes.spring.web.app.service.SysPropiedadesService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysPropiedades")
public class SysPropiedadesWSRestController {

	@Autowired
	private SysPropiedadesService sysPropiedadesService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysPropiedadesDTO sysPropiedadesDto) {
		return sysPropiedadesService.create(sysPropiedadesDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysPropiedadesDTO sysPropiedadesDto) {
		return sysPropiedadesService.update(sysPropiedadesDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysPropiedadesService.delete(id);
	}

	@RequestMapping(value = "/obtenerPropiedades", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPropiedadesDTO> obtenerPropiedades() {
		return sysPropiedadesService.obtenerPropiedades();
	}

	@RequestMapping(value = "/obtenerPropiedadesbyPk/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPropiedadesDTO obtenerPropiedadesbyPk(@PathVariable(name = "id") Integer id) {
		return sysPropiedadesService.obtenerPropiedadesbyPk(id);
	}

	@RequestMapping(value = "/obtenerPropiedad", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPropiedadesDTO obtenerPropiedad() {
		return sysPropiedadesService.obtenerPropiedad();
	}

}
