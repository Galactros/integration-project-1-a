package com.galactros.puc.integrationproject1a.enums;

public enum Doenca {
    PNEUMONIA(0), TROMBOSE_PULMONAR(0), COVID(0);

    private double pesoGeral = 0;

    
    Doenca(double pesoGeralDoenca){
        this.pesoGeral = pesoGeralDoenca;
    }

    public double getPesoGeral() {
        return pesoGeral;
    }

    public void setPesoGeral(double pesoGeral) {
        this.pesoGeral = pesoGeral;
    }
}
