package com.galactros.puc.integrationproject1a.model;

public class Doenca {

    private String name;
    private String[] sitomas;

    public Doenca(String name, String[] sitomas) {
        this.name = name;
        this.sitomas = sitomas;
    }

    public String getName() {
        return name;
    }

    public String[] getSitomas() {
        return sitomas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSitomas(String[] sitomas) {
        this.sitomas = sitomas;
    }
}
