package com.galactros.puc.integrationproject1a.controller;

import com.galactros.puc.integrationproject1a.model.DoencaPorcentagem;
import com.galactros.puc.integrationproject1a.model.Sintomas;
import com.galactros.puc.integrationproject1a.service.DoencaService;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @PostMapping("/result")
    public String result(@ModelAttribute Sintomas model) throws IOException {
        File file = new ClassPathResource("/static/result.html").getFile();

        String str = FileUtils.readFileToString(file, "UTF-8");

        DoencaService doencaService = new DoencaService();
        DoencaPorcentagem doencaporcentagem = new DoencaPorcentagem();

        doencaporcentagem = doencaService.processarDoencas(model);

        System.out.println(doencaporcentagem.getPorcentagemPneumonia());
        System.out.println(doencaporcentagem.getPorcentagemTrombosePulmonar());
        System.out.println(doencaporcentagem.getPorcentagemCovid());

        return str;
    }
}
