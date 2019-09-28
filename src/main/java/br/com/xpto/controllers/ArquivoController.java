package br.com.xpto.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.xpto.entitys.Capital;
import br.com.xpto.entitys.Cidade;
import br.com.xpto.entitys.Estado;
import br.com.xpto.entitys.Regiao;
import br.com.xpto.entitys.dto.ArquivoAux;
import br.com.xpto.repository.CidadeRepository;
import br.com.xpto.services.CidadeService;
import br.com.xpto.services.EstadoService;
import br.com.xpto.services.RegiaoService;

@Controller
public class ArquivoController {

	@Autowired
	CidadeService cidadeService;
	@Autowired
	EstadoService estadoService;
	@Autowired
	RegiaoService regiaoService;

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
            
                        
            //Busca na tabela estado, senão existir adiciona registro
            Estado estado = estadoService.findByName(arquivoAux.getEstado());
            if(estado == null || estado.getId() == -1) {
            	 estado = new Estado();
            	 estado.setNome(arquivoAux.getEstado());
                 Estado estadoSalvo = estadoService.salvar(estado);
                 System.out.println(estadoSalvo);
            }
            
            
            //Busca se existe uma região com os dados informados no csv, senão existir cria adiciona.
            Regiao regiao = regiaoService.findByMesoRegionAndMicroRegion(arquivoAux.getMesoRegion(), arquivoAux.getMicroRegion());
            if (regiao == null) {
                regiao = new Regiao();
                regiao.setMicroRegion(arquivoAux.getMicroRegion());
                regiao.setMesoRegion(arquivoAux.getMesoRegion());
                regiao = regiaoService.salvar(regiao);
            }
            
            
            Cidade cidade = cidadeService.findByName(arquivoAux.getName());
            
            if(cidade == null) {
            	cidade = new Cidade(
            			 Integer.parseInt(arquivoAux.getIdIbge()),
            			 estado, 
            			 arquivoAux.getName(), 
            			 arquivoAux.getCapital().equalsIgnoreCase("TRUE") ? Capital.SIM : Capital.NAO,
            			 Double.parseDouble(arquivoAux.getLongitude()),
            			 Double.parseDouble(arquivoAux.getLatitude()),
            			 arquivoAux.getAlternativeNames(),
            			 regiao
            			);
				cidadeService.salvar(cidade);
            }
        
           
		
        });

	return new ModelAndView();

	}

	@RequestMapping(value = "/arquivo", method = RequestMethod.GET)
	public ModelAndView arquivo() {
		return new ModelAndView("Arquivo");
	}

}
