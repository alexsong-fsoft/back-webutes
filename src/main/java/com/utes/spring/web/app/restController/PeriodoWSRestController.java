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

import com.utes.spring.web.app.dto.PeriodoDTO;
import com.utes.spring.web.app.service.PeriodoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/periodo")
public class PeriodoWSRestController {

	@Autowired
	private PeriodoService periodoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody PeriodoDTO periodoDto) {
		return periodoService.create(periodoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody PeriodoDTO periodoDto) {
		return periodoService.update(periodoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return periodoService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoPeriodoActivo", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PeriodoDTO> obtenerListadoPeriodoActivo() {
		return periodoService.obtenerListadoPeriodo(true);
	}

	@RequestMapping(value = "/obtenerPeriodoPorId/{idperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PeriodoDTO obtenerPeriodoPorId(@PathVariable(name = "idperiodo") Integer idperiodo) {
		return periodoService.obtenerPeriodoPorId(idperiodo);
	}

	@RequestMapping(value = "/obtenerListadoPeriodo", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PeriodoDTO> obtenerListadoPeriodo() {
		return periodoService.obtenerListadoPeriodo();
	}

	@RequestMapping(value = "/obtenerListadoPeriodobyNumero/{numero}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PeriodoDTO> obtenerListadoPeriodobyNumero(@PathVariable(name = "numero") Integer numero) {
		return periodoService.obtenerListadoPeriodobyNumero(numero);
	}

	@RequestMapping(value = "/obtenerUltimoRegistroPeriodo", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerUltimoRegistroPeriodo() {
		return periodoService.obtenerUltimoRegistroPeriodo();
	}

	@RequestMapping(value = "/obtenerPeriodoPorIdActivo/{idperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PeriodoDTO obtenerPeriodoPorIdActivo(@PathVariable(name = "idperiodo") Integer idperiodo) {
		return periodoService.obtenerPeriodoPorIdActivo(idperiodo, true);
	}

}
