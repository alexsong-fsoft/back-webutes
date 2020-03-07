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

import com.utes.spring.web.app.dto.SysPerfilDTO;
import com.utes.spring.web.app.dto.SysPermisoDTO;
import com.utes.spring.web.app.service.SysPermisoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysPermiso")
public class SysPermisoWSRestController {

	@Autowired
	private SysPermisoService sysPermisoService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysPermisoDTO sysPermisoDto) {
		return sysPermisoService.create(sysPermisoDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysPermisoDTO sysPermisoDto) {
		return sysPermisoService.update(sysPermisoDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysPermisoService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoSysPermiso", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPermisoDTO> obtenerListadoSysPermiso() {
		return sysPermisoService.obtenerListadoSysPermiso(true);
	}

	@RequestMapping(value = "/obtenerSysPermiso/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPermisoDTO obtenerSysPermiso(@PathVariable(name = "id") Integer id) {
		return sysPermisoService.obtenerSysPermiso(id);
	}

	@RequestMapping(value = "/obtenerListadoPermisoPorNombrePerfil/{nombreperfil}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPermisoDTO> obtenerListadoPermisoPorNombrePerfil(
			@PathVariable(name = "nombreperfil") String nombreperfil) {
		return sysPermisoService.obtenerListadoPermisoPorNombrePerfil(nombreperfil);
	}

	@RequestMapping(value = "/obtenerListadoPermisoPorPerfil", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPermisoDTO> obtenerListadoPermisoPorPerfil(@RequestBody SysPerfilDTO sysPerfilDTO) {
		return sysPermisoService.obtenerListadoPermisoPorPerfil(sysPerfilDTO);
	}

	@RequestMapping(value = "/obtenerPermisoPorPerfil/", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPermisoDTO obtenerPermisoPorPerfil(@RequestBody SysPerfilDTO sysPerfilDTO) {
		return sysPermisoService.obtenerPermisoPorPerfil(sysPerfilDTO);
	}

}
