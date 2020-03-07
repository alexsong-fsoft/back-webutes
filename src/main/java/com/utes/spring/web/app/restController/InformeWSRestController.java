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

import com.utes.spring.web.app.dto.InformeDTO;
import com.utes.spring.web.app.service.InformeService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/informe")
public class InformeWSRestController {

	@Autowired
	private InformeService informeService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody InformeDTO informeDto) {
		return informeService.create(informeDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody InformeDTO informeDto) {
		return informeService.update(informeDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return informeService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoInforme", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<InformeDTO> obtenerListadoInforme() {
		return informeService.obtenerListadoInforme(true);
	}

	@RequestMapping(value = "/obtenerInforme/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody InformeDTO obtenerInforme(@PathVariable(name = "id") Integer id) {
		return informeService.obtenerInforme(id);
	}

	@RequestMapping(value = "/obtenerInformesxTema/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<InformeDTO> obtenerInformesxTema(@PathVariable(name = "idtema") Integer idtema) {
		return informeService.obtenerInformesxTema(idtema);
	}

	@RequestMapping(value = "/obtenerInformesxTemaPersona/{idtema}/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<InformeDTO> obtenerInformesxTemaPersona(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idpersona") Integer idpersona) {
		return informeService.obtenerInformesxTemaPersona(idtema, idpersona);
	}
}
