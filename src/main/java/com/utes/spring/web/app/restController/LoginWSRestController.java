package com.utes.spring.web.app.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.utes.spring.web.app.dto.SysUsuarioDTO;
import com.utes.spring.web.app.service.SysUsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping(value = "/api/login")
public class LoginWSRestController {

	@Autowired
	private SysUsuarioService sysUsuarioService;

	@RequestMapping(value = "/loginUsuario", method = RequestMethod.POST, produces = {
			"application/json" + ";charset=utf-8" })
	public @ResponseBody SysUsuarioDTO loginUsuario(@RequestBody SysUsuarioDTO sysUsuarioDto) {
		return sysUsuarioService.loginUsuario(sysUsuarioDto);
	}
}
