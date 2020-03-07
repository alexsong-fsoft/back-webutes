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
import com.utes.spring.web.app.service.SysPerfilService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysPerfil")
public class SysPerfilWSRestController {

	@Autowired
	private SysPerfilService sysPerfilService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysPerfilDTO sysPerfilDto) {
		return sysPerfilService.create(sysPerfilDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysPerfilDTO sysPerfilDto) {
		return sysPerfilService.update(sysPerfilDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysPerfilService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoPerfil", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPerfilDTO> obtenerListadoPerfil() {
		return sysPerfilService.obtenerListadoPerfil();
	}

	@RequestMapping(value = "/obtenerPerfilPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPerfilDTO obtenerPerfilPorId(@PathVariable(name = "id") Integer id) {
		return sysPerfilService.obtenerPerfilPorId(id);
	}

	@RequestMapping(value = "/obtenerListadoPerfilPorNombreUsuario/{nombreusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPerfilDTO> obtenerListadoPerfilPorNombreUsuario(
			@PathVariable(name = "nombreusuario") String nombreusuario) {
		return sysPerfilService.obtenerListadoPerfilPorNombreUsuario(nombreusuario);
	}

	@RequestMapping(value = "/obtenerPerfilPorNombreUsuario/{nombreusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPerfilDTO obtenerPerfilPorNombreUsuario(
			@PathVariable(name = "nombreusuario") String nombreusuario) {
		return sysPerfilService.obtenerPerfilPorNombreUsuario(nombreusuario);
	}

	@RequestMapping(value = "/obtenerListadoPerfilPorNombreUsuario2/{nombreusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysPerfilDTO> obtenerListadoPerfilPorNombreUsuario2(
			@PathVariable(name = "nombreusuario") String nombreusuario) {
		return sysPerfilService.obtenerListadoPerfilPorNombreUsuario2(nombreusuario);
	}

	@RequestMapping(value = "/obtenerPerfilPorNombre/{nombreperfil}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysPerfilDTO obtenerPerfilPorNombre(@PathVariable(name = "nombreperfil") String nombreperfil) {
		return sysPerfilService.obtenerPerfilPorNombre(nombreperfil);
	}

}
