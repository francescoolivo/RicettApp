package it.unibo.android.ricettapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public enum TipologiaIngrediente implements IParametroRicercaIngrediente{

    FRUTTA("Frutta"),
    VERDURA("Verdura"),
    CARNE("Carne"),
    PESCE("Pesce"),
    PASTA("Pasta"),
    SPEZIE("Spezie"),
    LATTICINI("Latticini"),
    FRUTTA_SECCA("Frutta secca");

    @PrimaryKey
    private final String printable;

    TipologiaIngrediente(String printable) {
        this.printable = printable;
    }

    public String getPrintable() {
        return printable;
    }

    @Override
    public boolean matches(IParametroRicercaIngrediente other) {
        if (other instanceof TipologiaIngrediente) {
            return ((TipologiaIngrediente) other).name().equals(this.name());
        } else {
            return false;
        }
    }
}
