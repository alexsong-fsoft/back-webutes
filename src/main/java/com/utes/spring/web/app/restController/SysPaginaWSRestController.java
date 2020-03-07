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

import com.utes.spring.web.app.dto.SysPaginaDTO;
import com.utes.spring.web.app.service.SysPaginaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysPagina")
public class SysPaginaWSRestController {

	@Autowired
	private SysPaginaService sysPaginaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysPaginaDTO sysPaginaDto) {
		return sysPaginaService.create(sysPaginaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysPaginaDTO sysPaginaDto) {
		return sysPaginaService.update(sysPaginaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysPaginaService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoPagina", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPaginaDTO> obtenerListadoPagina() {
		return sysPaginaService.obtenerListadoPagina();
	}

	@RequestMapping(value = "/obtenerPaginaPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPaginaDTO obtenerPaginaPorId(@PathVariable(name = "id") Integer id) {
		return sysPaginaService.obtenerListadoPaginaPorId(id);
	}

	@RequestMapping(value = "/obtenerListadoPaginaPadres", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPaginaDTO> obtenerListadoPaginaPadres() {
		return sysPaginaService.obtenerListadoPaginaPadres();
	}
}
