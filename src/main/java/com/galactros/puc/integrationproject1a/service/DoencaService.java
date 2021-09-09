package com.galactros.puc.integrationproject1a.service;

import com.galactros.puc.integrationproject1a.model.*;

public class DoencaService {

    double pesoGeral = 0;
    double pesoPneumonia = 0;
    double pesoTrombosePulmonar = 0;
    double pesoCovid = 0;

    public DoencaPorcentagem processarDoencas(Sintomas sintomas) {

        processarPesoGeral(sintomas);

        DoencaPorcentagem doencaporcentagem = new DoencaPorcentagem();

        doencaporcentagem.setPorcentagemPneumonia(processarPorcentagensPneumonia());
        doencaporcentagem.setPorcentagemTrombosePulmonar(processarTrombosePulmonar());
        doencaporcentagem.setPorcentagemCovid(processarCovid());

        return doencaporcentagem;
    }

    public void processarPesoGeral(Sintomas sintomas) {

        pesoGeral = 0;
        pesoPneumonia = 0;
        pesoTrombosePulmonar = 0;
        pesoCovid = 0;

        if (sintomas.isFebre()) {
            pesoPneumonia++;
            pesoTrombosePulmonar++;
            pesoCovid++;
            pesoGeral += 3;
        }
        if (sintomas.isTosse()) {
            pesoTrombosePulmonar++;
            pesoCovid++;
            pesoGeral += 2;
        }
        if (sintomas.isDoresDeCabeca()) {
            pesoPneumonia++;
            pesoCovid++;
            pesoGeral += 2;
        }
        if (sintomas.isFaltaDeAr()) {
            pesoPneumonia++;
            pesoCovid++;
            pesoGeral += 2;
        }
        if (sintomas.isCansaco()) {
            pesoPneumonia++;
            pesoCovid++;
            pesoGeral += 2;
        }
        if (sintomas.isDorNoCorpo()) {
            pesoPneumonia++;
            pesoTrombosePulmonar++;
            pesoCovid++;
            pesoGeral += 3;
        }
        if (sintomas.isCalafrios()) {
            pesoPneumonia++;
            pesoGeral += 1;
        }
        if (sintomas.isVomitos()) {
            pesoPneumonia++;
            pesoGeral += 1;
        }
        if (sintomas.isPerdaDeApetite()) {
            pesoPneumonia++;
            pesoGeral += 1;
        }
        if (sintomas.isNausea()) {
            pesoPneumonia++;
            pesoGeral += 1;
        }
        if (sintomas.isDoresNasArticulacoes()) {
            pesoPneumonia++;
            pesoCovid++;
            pesoGeral += 2;
        }
        if (sintomas.isDispneia()) {
            pesoTrombosePulmonar++;
            pesoGeral += 1;
        }

        System.out.println("pesoGeral: " + pesoGeral);
        System.out.println("pesoPneumonia: " + pesoPneumonia);
        System.out.println("pesoTrombosePulmonar: " + pesoTrombosePulmonar);
        System.out.println("pesoCovid: " + pesoCovid);

    }

    public double processarPorcentagensPneumonia() {

        double porcentagemPneumonia = (pesoPneumonia / pesoGeral) * 100;

        return porcentagemPneumonia;
    }

    public double processarTrombosePulmonar() {

        double porcentagemTrombosePulmonar = (pesoTrombosePulmonar / pesoGeral) * 100;

        return porcentagemTrombosePulmonar;
    }

    public double processarCovid() {

        double porcentagemCovid = (pesoCovid / pesoGeral) * 100;

        return porcentagemCovid;
    }

}
