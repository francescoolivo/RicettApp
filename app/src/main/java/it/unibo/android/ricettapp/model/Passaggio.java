package it.unibo.android.ricettapp.model;

import java.io.File;

public class Passaggio {

    private String conenuto;
    private File fotografia;

    public Passaggio(String conenuto, File fotografia) {
        this.conenuto = conenuto;
        this.fotografia = fotografia;
    }

    public String getConenuto() {
        return conenuto;
    }

    public void setConenuto(String conenuto) {
        this.conenuto = conenuto;
    }

    public File getFotografia() {
        return fotografia;
    }

    public void setFotografia(File fotografia) {
        this.fotografia = fotografia;
    }
}
