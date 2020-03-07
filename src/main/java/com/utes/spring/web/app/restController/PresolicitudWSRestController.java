package com.utes.spring.web.app.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utes.spring.web.app.dto.InscripcionDTO;
import com.utes.spring.web.app.dto.PersonaDTO;
import com.utes.spring.web.app.dto.PresolicitudDTO;
import com.utes.spring.web.app.service.PresolicitudService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/presolicitud")
public class PresolicitudWSRestController {

	@Autowired
	private PresolicitudService presolicitudService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody PresolicitudDTO presolicitudDto) {
		return presolicitudService.create(presolicitudDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody PresolicitudDTO presolicitudDto) {
		return presolicitudService.update(presolicitudDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return presolicitudService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitud", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitud() {
		return presolicitudService.obtenerListadoPresolicitud();
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPageable", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Page<PresolicitudDTO> obtenerListadoPresolicitudPageable() {
		return presolicitudService.obtenerListadoPresolicitudPageable();
	}

	@RequestMapping(value = "/obtenerPresolicitudPorId/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PresolicitudDTO obtenerPresolicitudPorId(@PathVariable(name = "id") Integer id) {
		return presolicitudService.obtenerPresolicitudPorId(id);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPorCedula", method = RequestMethod.POST, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitudPorCedula(@RequestBody PersonaDTO personaDTO) {
		return presolicitudService.obtenerListadoPresolicitudPorCedula(personaDTO);
	}

	@RequestMapping(value = "/obtenerPresolicitudPorCedula", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PresolicitudDTO obtenerPresolicitudPorCedula(@RequestBody PersonaDTO personaDTO) {
		Integer idinscipcion = 0;
		return presolicitudService.obtenerPresolicitudPorCedula(personaDTO, idinscipcion);
	}

	@RequestMapping(value = "/obtenerPresolicitudPorEstado/{idestado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerPresolicitudPorEstado(
			@PathVariable(name = "idestado") Integer idestado) {
		return presolicitudService.obtenerPresolicitudPorEstado(idestado);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPorEstado2/{idestado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitudPorEstado2(
			@PathVariable(name = "idestado") Integer idestado) {
		return presolicitudService.obtenerListadoPresolicitudPorEstado2(idestado);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPorIdsPersona/{ids}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitudPorIdsPersona(
			@PathVariable(name = "ids") String ids) {
		return presolicitudService.obtenerListadoPresolicitudPorIdsPersona(ids);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPorCedulaId", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitudPorCedulaId(
			@RequestBody PersonaDTO personaDTO) {
		InscripcionDTO objinscripcion = new InscripcionDTO();
		return presolicitudService.obtenerListadoPresolicitudPorCedulaId(personaDTO, objinscripcion);
	}

	@RequestMapping(value = "/obtenerPresolicitudPorPersonaId/{idper}/{idinscripcion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PresolicitudDTO obtenerPresolicitudPorPersonaId(@PathVariable(name = "idper") Integer idper,
			@PathVariable(name = "idinscripcion") Integer idinscripcion) {
		return presolicitudService.obtenerPresolicitudPorPersonaId(idper, idinscripcion);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPorId/{idpresolicitud}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PresolicitudDTO obtenerListadoPresolicitudPorId(
			@PathVariable(name = "idpresolicitud") Integer idpresolicitud) {
		return presolicitudService.obtenerListadoPresolicitudPorId(idpresolicitud);
	}

//	public List<PresolicitudDTO> obtenerListadoPresolicitudConsulta(Integer idins, Integer idopc, Integer idestado,
//			Date||||| fini, Date ffin);

	@RequestMapping(value = "/obtenerPresolicitudPorPersonaIdInscripcion/{idper}/{idinscripcion}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody PresolicitudDTO obtenerPresolicitudPorPersonaIdInscripcion(
			@PathVariable(name = "idper") Integer idper, @PathVariable(name = "idinscripcion") Integer idinscripcion) {
		return presolicitudService.obtenerPresolicitudPorPersonaIdInscripcion(idper, idinscripcion);
	}

	@RequestMapping(value = "/obtenerIdPresolicidutxUltimoRegistrado/{idpersona}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Integer obtenerIdPresolicidutxUltimoRegistrado(
			@PathVariable(name = "idpersona") Integer idpersona) {
		return presolicitudService.obtenerIdPresolicidutxUltimoRegistrado(idpersona);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudbyOpcionEstado/{idopcion}/{idestados}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitudbyOpcionEstado(
			@PathVariable(name = "idopcion") Integer idopcion, @PathVariable(name = "idestados") String idestados) {
		return presolicitudService.obtenerListadoPresolicitudbyOpcionEstado(idopcion, idestados);
	}

	@RequestMapping(value = "/obtenerListadoPresolicitudPorEstados/{opciones}/{idestados}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<PresolicitudDTO> obtenerListadoPresolicitudPorEstados(
			@PathVariable(name = "opciones") String opciones, @PathVariable(name = "idestados") String idestados) {
		return presolicitudService.obtenerListadoPresolicitudPorEstados(opciones, idestados);
	}

}
