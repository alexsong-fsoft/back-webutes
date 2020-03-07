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

import com.utes.spring.web.app.dto.HistoricoDTO;
import com.utes.spring.web.app.service.HistoricoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/historico")
public class HistoricoWSRestController {

	@Autowired
	private HistoricoService historicoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody HistoricoDTO historicoDto) {
		return historicoService.create(historicoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody HistoricoDTO historicoDto) {
		return historicoService.update(historicoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return historicoService.delete(id);
	}

	@RequestMapping(value = "/obtenerHistorico", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<HistoricoDTO> obtenerHistorico() {
		return historicoService.obtenerHistorico();
	}

	@RequestMapping(value = "/obtenerHistorico/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody HistoricoDTO obtenerHistorico(@PathVariable(name = "id") Integer id) {
		return historicoService.obtenerHistorico(id);
	}

	@RequestMapping(value = "/obtenerHistoricoxTema/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<HistoricoDTO> obtenerHistoricoxTema(@PathVariable(name = "idtema") Integer idtema) {
		return historicoService.obtenerHistoricoxTema(idtema);
	}

	@RequestMapping(value = "/obtenerHistoricoxTema/{idtema}/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<HistoricoDTO> obtenerHistoricoxTema(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idpersona") Integer idpersona) {
		return historicoService.obtenerHistoricoxTema(idtema, idpersona);
	}

	@RequestMapping(value = "/obtenerEntidadHistorico/{idtema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody HistoricoDTO obtenerEntidadHistorico(@PathVariable(name = "idtema") Integer idtema) {
		return historicoService.obtenerEntidadHistorico(idtema);
	}

	@RequestMapping(value = "/obtenerEntidadHistorico/{idtema}/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody HistoricoDTO obtenerEntidadHistorico(@PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idpersona") Integer idpersona) {
		return historicoService.obtenerEntidadHistorico(idtema, idpersona);
	}
}
