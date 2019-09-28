package br.com.xpto.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.xpto.entitys.dto.ArquivoAux;

@Controller
public class ArquivoController {

	@RequestMapping(value = "/arquivo", method = RequestMethod.POST)
	public ModelAndView gravarDadosCsv(MultipartFile file) throws Exception {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(), "utf-8"));
		
		String arquivoLinha = null;

        List<String> listaLinhas = new ArrayList<>();

        while (bufferedReader.ready()) {
            if (arquivoLinha == null) {
            	bufferedReader.readLine(); //ja pula linha
            }
            arquivoLinha = bufferedReader.readLine();
            listaLinhas.add(arquivoLinha);
        }

        bufferedReader.close();
        
        listaLinhas.forEach(e -> {
            String[] itemArquivo = e.split(",");

            ArquivoAux arquivoAux = new ArquivoAux(
                    itemArquivo[0], //ibge_id
                    itemArquivo[1], //uf
                    itemArquivo[2], //name
                    itemArquivo[3], //capital
                    itemArquivo[4], //longitude 
                    itemArquivo[5], //latiude
                    itemArquivo[6], //noAccents
                    itemArquivo[7], //alternative names
                    itemArquivo[8], //microregion
                    itemArquivo[9]  //mesoregion
            );

		
		System.out.println(arquivoAux.toString());
		
        });
        
		return new ModelAndView();
	}

	@RequestMapping(value = "/arquivo", method = RequestMethod.GET)
	public ModelAndView arquivo() {
		return new ModelAndView("Arquivo");
	}

}
