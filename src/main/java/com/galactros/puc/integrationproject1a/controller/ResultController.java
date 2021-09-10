package com.galactros.puc.integrationproject1a.controller;

import com.galactros.puc.integrationproject1a.model.DoencaPorcentagem;
import com.galactros.puc.integrationproject1a.model.Sintomas;
import com.galactros.puc.integrationproject1a.service.DoencaService;
import com.galactros.puc.integrationproject1a.utils.FileResourcesUtils;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @PostMapping("/result")
    public String result(@ModelAttribute Sintomas model) throws IOException {

        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();

        String str = fileResourcesUtils.filebyStream("/static/result.html");

        DoencaService doencaService = new DoencaService();
        DoencaPorcentagem doencaporcentagem = doencaService.processarDoencas(model);

        System.out.println(doencaporcentagem.getPorcentagemPneumonia());
        System.out.println(doencaporcentagem.getPorcentagemTrombosePulmonar());
        System.out.println(doencaporcentagem.getPorcentagemCovid());

        str = str.replace("{{porcentagemPneumonia}}", doencaporcentagem.getPorcentagemPneumonia().intValue() + "");
        str = str.replace("{{porcentagemTrombosePulmonar}}", doencaporcentagem.getPorcentagemTrombosePulmonar().intValue() + "");
        str = str.replace("{{porcentagemCovid}}", doencaporcentagem.getPorcentagemCovid().intValue() + "");

        return str;
    }

    @GetMapping("/result")
    public String getResult() throws IOException {

        FileResourcesUtils fileResourcesUtils = new FileResourcesUtils();

        String str = fileResourcesUtils.filebyStream("/static/index.html");

        return str;
    }
}
