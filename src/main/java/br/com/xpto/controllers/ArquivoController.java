package br.com.xpto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArquivoController {

	@RequestMapping(value = "/arquivo", method = RequestMethod.POST)
	public ModelAndView gravarDadosCsv(MultipartFile file) throws Exception {
		return new ModelAndView();
	}

	@RequestMapping(value = "/arquivo", method = RequestMethod.GET)
	public ModelAndView arquivo() {
		return new ModelAndView("Arquivo");
	}

}
