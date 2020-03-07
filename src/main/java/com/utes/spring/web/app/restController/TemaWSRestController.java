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

import com.utes.spring.web.app.dto.TemaDTO;
import com.utes.spring.web.app.service.TemaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/tema")
public class TemaWSRestController {

	@Autowired
	private TemaService temaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody TemaDTO temaDto) {
		return temaService.create(temaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody TemaDTO temaDto) {
		return temaService.update(temaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return temaService.delete(id);
	}

	@RequestMapping(value = "/obtenerTemas", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemas() {
		return temaService.obtenerTemas();
	}

	@RequestMapping(value = "/obtenerTemasxId/{pktema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody TemaDTO obtenerTemasxId(@PathVariable(name = "pktema") Integer pktema) {
		return temaService.obtenerTemasxId(pktema);
	}

	@RequestMapping(value = "/obtenerTemasExceptoEstado/{codigos}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasExceptoEstado(@PathVariable(name = "codigos") String codigos) {
		return temaService.obtenerTemasExceptoEstado(codigos);
	}

	@RequestMapping(value = "/obtenerTemasEstados/{codigos}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasEstados(@PathVariable(name = "codigos") String codigos) {
		return temaService.obtenerTemasEstados(codigos);
	}

	@RequestMapping(value = "/obtenerTemasEstadosPageable/{codigos}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Page<TemaDTO> obtenerTemasEstadosPageable(@PathVariable(name = "codigos") String codigos) {
		return temaService.obtenerTemasEstadosPageable(codigos);
	}

	@RequestMapping(value = "/obtenerTemasxUsuarioEstado/{nameuser}/{idestado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioEstado(@PathVariable(name = "nameuser") String nameuser,
			@PathVariable(name = "idestado") Integer idestado) {
		return temaService.obtenerTemasxUsuarioEstado(nameuser, idestado);
	}

	@RequestMapping(value = "/obtenerTemasxUsuario/{nameuser}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxUsuario(@PathVariable(name = "nameuser") String nameuser) {
		return temaService.obtenerTemasxUsuario(nameuser);
	}

	@RequestMapping(value = "/obtenerTemasxEstado/{idestado}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxEstado(@PathVariable(name = "idestado") Integer idestado) {
		return temaService.obtenerTemasxEstado(idestado);
	}

	@RequestMapping(value = "/obtenerTema", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody TemaDTO obtenerTema(@RequestBody TemaDTO auxobj) {
		return temaService.obtenerTema(auxobj);
	}

	@RequestMapping(value = "/obtenerTemasxConvocatoria/{fkconv}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxConvocatoria(@PathVariable(name = "fkconv") Integer fkconv) {
		return temaService.obtenerTemasxConvocatoria(fkconv);
	}

	@RequestMapping(value = "/obtenerTemasxUsuarioEstadosIn/{nameuser}/{estados}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioEstado(@PathVariable(name = "nameuser") String nameuser,
			@PathVariable(name = "estados") String estados) {
		return temaService.obtenerTemasxUsuarioEstado(nameuser, estados);
	}

	@RequestMapping(value = "/obtenerTemaxNombre/{nombretema}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody TemaDTO obtenerTemaxNombre(@PathVariable(name = "nombretema") String nombretema) {
		return temaService.obtenerTemaxNombre(nombretema);
	}

	@RequestMapping(value = "/obtenerTemasxPk/{idtem}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxPk(@PathVariable(name = "idtem") Integer idtem) {
		return temaService.obtenerTemasxPk(idtem);
	}

	@RequestMapping(value = "/obtenerTemasxIdstemas/{codigos}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxIdstemas(@PathVariable(name = "codigos") String codigos) {
		return temaService.obtenerTemasxIdstemas(codigos);
	}

	@RequestMapping(value = "/obtenerTemasxIdstemasEstados/{codigos}/{estados}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxIdstemasEstados(@PathVariable(name = "codigos") String codigos,
			@PathVariable(name = "estados") String estados) {
		return temaService.obtenerTemasxIdstemasEstados(codigos, estados);
	}

	@RequestMapping(value = "/obtenerTemasxIdstemasEstadosPageable/{codigos}/{estados}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Page<TemaDTO> obtenerTemasxIdstemasEstadosPageable(
			@PathVariable(name = "codigos") String codigos, @PathVariable(name = "estados") String estados) {
		return temaService.obtenerTemasxIdstemasEstadosPageable(codigos, estados);
	}

	@RequestMapping(value = "/obtenerTemasPorIdExceptoActual/{idtem}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasPorIdExceptoActual(@PathVariable(name = "idtem") Integer idtem) {
		return temaService.obtenerTemasPorIdExceptoActual(idtem);
	}

	@RequestMapping(value = "/obtenerConsultaTemas/{parametro}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerConsultaTemas(@PathVariable(name = "parametro") String parametro) {
		return temaService.obtenerConsultaTemas(parametro);
	}

	@RequestMapping(value = "/obtenerTemasxUsuarioEstadoConvocatoria/{nameuser}/{estados}/{idconvocatoria}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(
			@PathVariable(name = "nameuser") String nameuser, @PathVariable(name = "estados") String estados,
			@PathVariable(name = "idconvocatoria") Integer idconvocatoria) {
		return temaService.obtenerTemasxUsuarioEstadoConvocatoria(nameuser, estados, idconvocatoria);
	}

//	@RequestMapping(value = "/obtenerTemasxUsuarioEstadoConvocatoria/{nameuser}/{estados}/{idconvocatoria}", method = RequestMethod.GET, produces = {
//			"application/json" + ";charset=utf-8" })
//	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(@PathVariable(name = "nameuser") String nameuser,
//			@PathVariable(name = "estados") String estados,
//			@PathVariable(name = "idconvocatoria") String idconvocatoria) {
//		return temaService.obtenerTemasxUsuarioEstadoConvocatoria(nameuser, estados, idconvocatoria);
//	}

//	@RequestMapping(value = "/obtenerTemasxUsuarioEstadoConvocatoria/{codigos}/{estados}", method = RequestMethod.GET, produces = {
//			"application/json" + ";charset=utf-8" })
//	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioEstadoConvocatoria(@PathVariable(name = "codigos") String codigos, @PathVariable(name = "estados") String estados) {
//		return temaService.obtenerTemasxUsuarioEstadoConvocatoria(codigos, estados);
//	}

	@RequestMapping(value = "/obtenerTemasxUsuarioEstado/{nameuser}/{estados}/{idperiodo}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioEstado(@PathVariable(name = "nameuser") String nameuser,
			@PathVariable(name = "estados") String estados, @PathVariable(name = "idperiodo") String idperiodo) {
		return temaService.obtenerTemasxUsuarioEstado(nameuser, estados, idperiodo);
	}

//	@RequestMapping(value = "/obtenerTemasxUsuarioConvocatoria/{parametro}", method = RequestMethod.GET, produces = {
//			"application/json" + ";charset=utf-8" })
//	public @ResponseBody List<TemaDTO> obtenerTemasxUsuarioConvocatoria(@PathVariable(name = "parametro") String parametro) {
//		return temaService.obtenerTemasxUsuarioConvocatoria(parametro);
//	}
}
