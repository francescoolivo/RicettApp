package it.unibo.android.ricettapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public enum UnitaDiMisura {

    GRAMMO("Grammo", "g"),
    DECAGRAMMO("Decagrammo", "dag"),
    ETTOGRAMMO("Ettogrammo", "hg"),
    CHILOGRAMMO("Chilogrammo", "kg"),
    UNITA("Unità", "u"),
    LITRO("Litro", "l"),
    DECILITRO("Decilitro", "dl"),
    CENTILITRO("Centilitro", "cl"),
    MILLILITRO("Millilitro", "ml"),
    CUP("Cup", "cup"),
    TABLESPOON("Tablespoon", "tbsp"),
    TEASPOON("Teaspoon", "tsp"),
    ONCIA("Oncia", "oz"),
    ONCIA_LIQUIDA("Oncia liquida", "fl. oz.");

    @PrimaryKey
    private final String printable;
    @ColumnInfo(name = "abbreviation")
    private final String abbreviation;

    UnitaDiMisura(String printable, String abbreviation) {
        this.printable = printable;
        this.abbreviation = abbreviation;
    }

    public String getPrintable() {
        return printable;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
    }
