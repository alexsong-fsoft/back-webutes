package com.utes.spring.web.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.utes.spring.web.app.EstaticosConfig;

@Controller
@RequestMapping("/app")
public class HomeController {

	@Value("${application.titulo}")
	private String titulo;
	@Autowired
    private EstaticosConfig mensajes;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index (Model model) {
		model.addAttribute("titulo", this.mensajes.getApplicationTitulo());
		return "index";
	}
}
