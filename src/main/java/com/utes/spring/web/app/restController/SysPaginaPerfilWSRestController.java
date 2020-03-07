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

import com.utes.spring.web.app.dto.SysPaginaPerfilDTO;
import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.service.SysPaginaPerfilService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysPaginaPerfil")
public class SysPaginaPerfilWSRestController {

	@Autowired
	private SysPaginaPerfilService sysPaginaPerfilService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysPaginaPerfilDTO sysPaginaPerfilDto) {
		return sysPaginaPerfilService.create(sysPaginaPerfilDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysPaginaPerfilDTO sysPaginaPerfilDto) {
		return sysPaginaPerfilService.update(sysPaginaPerfilDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysPaginaPerfilService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoSysPaginaPerfil", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPaginaPerfilDTO> obtenerListadoSysPaginaPerfil() {
		return sysPaginaPerfilService.obtenerListadoSysPaginaPerfil(true);
	}

	@RequestMapping(value = "/obtenerSysPaginaPerfil/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPaginaPerfilDTO obtenerSysPaginaPerfil(@PathVariable(name = "id") Integer id) {
		return sysPaginaPerfilService.obtenerSysPaginaPerfil(id);
	}

	@RequestMapping(value = "/obtenerListadoPaginaPerfilPorNombrePerfil/{nombreperfil}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorNombrePerfil(
			@PathVariable(name = "nombreperfil") String nombreperfil) {
		return sysPaginaPerfilService.obtenerListadoPaginaPerfilPorNombrePerfil(nombreperfil);
	}

	@RequestMapping(value = "/obtenerListadoPaginaPerfilPorPerfil", method = RequestMethod.POST, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorPerfil(
			@RequestBody SysPerfilDTO sysPerfilDTO) {
		return sysPaginaPerfilService.obtenerListadoPaginaPerfilPorPerfil(sysPerfilDTO);
	}

	@RequestMapping(value = "/obtenerPaginaPerfilPorPerfil", method = RequestMethod.POST, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPaginaPerfilDTO obtenerPaginaPerfilPorPerfil(@RequestBody SysPerfilDTO sysPerfilDTO) {
		return sysPaginaPerfilService.obtenerPaginaPerfilPorPerfil(sysPerfilDTO);
	}

	@RequestMapping(value = "/obtenerListadoPaginaPerfilPorPerfil2", method = RequestMethod.POST, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPaginaPerfilDTO> obtenerListadoPaginaPerfilPorPerfil2(
			@RequestBody SysPerfilDTO sysPerfilDTO) {
		String tipo = "";
		return sysPaginaPerfilService.obtenerListadoPaginaPerfilPorPerfil(sysPerfilDTO, tipo);
	}
}
