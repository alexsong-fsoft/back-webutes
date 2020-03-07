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

import com.utes.spring.web.app.dto.ConvocatoriaDTO;
import com.utes.spring.web.app.service.ConvocatoriaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/convocatoria")
public class ConvocatoriaWSRestController {

	@Autowired
	private ConvocatoriaService convocatoriaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody ConvocatoriaDTO convocatoriaDto) {
		return convocatoriaService.create(convocatoriaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody ConvocatoriaDTO convocatoriaDto) {
		return convocatoriaService.update(convocatoriaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return convocatoriaService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoConvocatoria", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<ConvocatoriaDTO> obtenerListadoConvocatoria() {
		return convocatoriaService.obtenerListadoConvocatoria();
	}

	@RequestMapping(value = "/obtenerConvocatoriaPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody ConvocatoriaDTO obtenerConvocatoriaPorId(@PathVariable(name = "id") Integer id) {
		return convocatoriaService.obtenerConvocatoriaPorId(id);
	}

	@RequestMapping(value = "/obtenerConvocatoriaSecuencia", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerConvocatoriaSecuencia() {
		return convocatoriaService.obtenerConvocatoriaSecuencia();
	}

	@RequestMapping(value = "/obtenerUltimoRegistroConvocatoria", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerUltimoRegistroConvocatoria() {
		return convocatoriaService.obtenerUltimoRegistroConvocatoria();
	}

	@RequestMapping(value = "/obtenerSecuencialConvocatoria", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerSecuencialConvocatoria() {
		return convocatoriaService.obtenerSecuencialConvocatoria();
	}

	@RequestMapping(value = "/obtenerListadoConvocatoriaPorActivo", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<ConvocatoriaDTO> obtenerListadoConvocatoriaPorActivo() {
		return convocatoriaService.obtenerListadoConvocatoriaPorActivo(true);
	}

	@RequestMapping(value = "/obtenerConvocatoriaPorIdActivo/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody ConvocatoriaDTO obtenerConvocatoriaPorIdActivo(@PathVariable(name = "id") Integer id) {
		return convocatoriaService.obtenerConvocatoriaPorIdActivo(id, true);
	}

	@RequestMapping(value = "/obtenerConvocatoriaPorIdPeriodo/{conPeriodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody ConvocatoriaDTO obtenerConvocatoriaPorIdPeriodo(
			@PathVariable(name = "conPeriodo") Integer conPeriodo) {
		return convocatoriaService.obtenerConvocatoriaPorIdPeriodo(conPeriodo);
	}
}
