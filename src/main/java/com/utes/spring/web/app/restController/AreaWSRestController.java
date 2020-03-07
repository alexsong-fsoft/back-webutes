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

import com.utes.spring.web.app.dto.AreaDTO;
import com.utes.spring.web.app.service.AreaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/area")
public class AreaWSRestController {

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean create(@RequestBody AreaDTO areaDto) {
		return areaService.create(areaDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = { "application/json" }, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean update(@RequestBody AreaDTO areaDto) {
		return areaService.update(areaDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody boolean delete(@PathVariable(name = "id") Integer id) {
		return areaService.delete(id);
	}

	@RequestMapping(value = "/obtenerListadoArea", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaDTO> obtenerListadoArea() {
		return areaService.obtenerListadoArea(true);
	}

	@RequestMapping(value = "/obtenerListadoAreaPageable", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody Page<AreaDTO> obtenerListadoAreaPageable() {
		return areaService.obtenerListadoAreaPageable(true);
	}

	@RequestMapping(value = "/obtenerArea/{id}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody AreaDTO obtenerArea(@PathVariable(name = "id") Integer id) {
		return areaService.obtenerArea(id);
	}

	@RequestMapping(value = "/obtenerListadoAreaPorTipo/{tipoarea}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaDTO> obtenerListadoAreaPorTipo(@PathVariable(name = "tipoarea") Integer tipoarea) {
		return areaService.obtenerListadoAreaPorTipo(tipoarea, true);
	}

	@RequestMapping(value = "/obtenerListadoArea/{ids}", method = RequestMethod.GET, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody List<AreaDTO> obtenerListadoArea(@PathVariable(name = "ids") String ids) {
		return areaService.obtenerListadoArea(ids, true);
	}
}
