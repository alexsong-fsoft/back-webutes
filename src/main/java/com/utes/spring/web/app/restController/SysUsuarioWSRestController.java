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

import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.dto.SysUsuarioDTO;
import com.utes.spring.web.app.service.SysUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/sysUsuario")
public class SysUsuarioWSRestController {

	@Autowired
	private SysUsuarioService sysUsuarioService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody SysUsuarioDTO sysUsuarioDto) {
		return sysUsuarioService.create(sysUsuarioDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody SysUsuarioDTO sysUsuarioDto) {
		return sysUsuarioService.update(sysUsuarioDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return sysUsuarioService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoUsuario", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuario() {
		return sysUsuarioService.obtenerListadoUsuario();
	}

	@RequestMapping(value = "/obtenerUsuarioPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO obtenerUsuarioPorId(@PathVariable(name = "id") Integer id) {
		return sysUsuarioService.obtenerUsuarioPorId(id);
	}

	@RequestMapping(value = "/loginUsuario", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO loginUsuario(@RequestBody SysUsuarioDTO sysUsuarioDto) {
		return sysUsuarioService.loginUsuario(sysUsuarioDto);
	}

	@RequestMapping(value = "/obtenerUsuarioPorNombreUsuario/{nombreusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO obtenerUsuarioPorNombreUsuario(
			@PathVariable(name = "nombreusuario") String nombreusuario) {
		return sysUsuarioService.obtenerUsuarioPorNombreUsuario(nombreusuario);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorNombre/{nombreusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorNombre(
			@PathVariable(name = "nombreusuario") String nombreusuario) {
		return sysUsuarioService.obtenerListadoUsuarioPorNombre(nombreusuario);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorUsuarioNombre/{nombreusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorUsuarioNombre(
			@PathVariable(name = "nombreusuario") String nombreusuario) {
		return sysUsuarioService.obtenerListadoUsuarioPorUsuarioNombre(nombreusuario);
	}

	@RequestMapping(value = "/obtenerUsuarioPorPersona", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO obtenerUsuarioPorPersona(@RequestBody PersonaDTO objpersona) {
		return sysUsuarioService.obtenerUsuarioPorPersona(objpersona);
	}

	@RequestMapping(value = "/obtenerUsuarioPorPersonaId/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO obtenerUsuarioPorPersonaId(@PathVariable(name = "idpersona") Integer idpersona) {
		return sysUsuarioService.obtenerUsuarioPorPersonaId(idpersona);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfil/{perfilnombre}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfil(
			@PathVariable(name = "perfilnombre") String perfilnombre) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfil(perfilnombre);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfilPresolicitud/{perfilnombre}/{preslestados}/{preslopciones}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilPresolicitud(
			@PathVariable(name = "perfilnombre") String perfilnombre,
			@PathVariable(name = "preslestados") String preslestados,
			@PathVariable(name = "preslopciones") String preslopciones) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfilPresolicitud(perfilnombre, preslestados, preslopciones);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfilAsignado/{perfilnombre}/{idtema}/{idperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilAsignado(
			@PathVariable(name = "perfilnombre") String perfilnombre, @PathVariable(name = "idtema") Integer idtema,
			@PathVariable(name = "idperiodo") Integer idperiodo) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfilAsignado(perfilnombre, idtema, idperiodo);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfilAsignado/{perfilnombre}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilAsignado(
			@PathVariable(name = "perfilnombre") String perfilnombre) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfilAsignado(perfilnombre);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfilSeleccion/{perfilnombre}/{periodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilSeleccion(
			@PathVariable(name = "perfilnombre") String perfilnombre, @PathVariable(name = "periodo") Integer periodo) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfilSeleccion(perfilnombre, periodo);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfil/{perfilnombre}/{idpersonatutor}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfil(
			@PathVariable(name = "perfilnombre") String perfilnombre,
			@PathVariable(name = "perfilnombre") Integer idpersonatutor) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfil(perfilnombre, idpersonatutor);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorUsuarioId/{idusuario}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorUsuarioId(
			@PathVariable(name = "idusuario") Integer idusuario) {
		return sysUsuarioService.obtenerListadoUsuarioPorUsuarioId(idusuario);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorTemaPorPerfil/{perfilnombre}/{idusuario}/{estados}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorTemaPorPerfil(
			@PathVariable(name = "perfilnombre") String perfilnombre,
			@PathVariable(name = "idusuario") Integer idusuario, @PathVariable(name = "estados") String estados) {
		return sysUsuarioService.obtenerListadoUsuarioPorTemaPorPerfil(perfilnombre, idusuario, estados);
	}

	@RequestMapping(value = "/obtenerUsuarioPorCorreo/{correo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO obtenerUsuarioPorCorreo(@PathVariable(name = "correo") String correo) {
		return sysUsuarioService.obtenerUsuarioPorCorreo(correo);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorPerfilPresolicitud/{perfilnombre}/{preslestados}/{preslopciones}/{idinscripcion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorPerfilPresolicitud(
			@PathVariable(name = "perfilnombre") String perfilnombre,
			@PathVariable(name = "preslestados") String preslestados,
			@PathVariable(name = "preslopciones") String preslopciones,
			@PathVariable(name = "idinscripcion") Integer idinscripcion) {
		return sysUsuarioService.obtenerListadoUsuarioPorPerfilPresolicitud(perfilnombre, preslestados, preslopciones,
				idinscripcion);
	}

	@RequestMapping(value = "/obtenerListadoUsuarioPorTemaPorPerfil/{perfilnombre}/{idusuario}/{estados}/{idperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<SysUsuarioDTO> obtenerListadoUsuarioPorTemaPorPerfil(
			@PathVariable(name = "perfilnombre") String perfilnombre,
			@PathVariable(name = "idusuario") Integer idusuario, @PathVariable(name = "estados") String estados,
			@PathVariable(name = "idperiodo") String idperiodo) {
		return sysUsuarioService.obtenerListadoUsuarioPorTemaPorPerfil(perfilnombre, idusuario, estados, idperiodo);
	}

}
