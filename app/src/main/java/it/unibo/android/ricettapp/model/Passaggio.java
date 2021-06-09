package it.unibo.android.ricettapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.File;

@Entity
public class Passaggio {

    @PrimaryKey
    private String conenuto;
    @ColumnInfo(name = "contenuto")
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
