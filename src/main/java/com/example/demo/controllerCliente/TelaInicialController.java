package com.example.demo.controllerCliente;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class TelaInicialController {
	public ModelAndView index() {
		return new ModelAndView("index.html");
	}
}