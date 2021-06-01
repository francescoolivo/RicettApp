package it.unibo.android.ricettapp.model;

public enum UnitaDiMisura {

    GRAMMO("Grammo", "g"),
    DECAGRAMMO("Decagrammo", "dag"),
    ETTOGRAMMO("Ettogrammo", "hg"),
    CHILOGRAMMO("Chilogrammo", "kg"),
    UNITÀ("Unità", "u"),
    LITRO("Litro", "l"),
    DECILITRO("Decilitro", "dl"),
    CENTILITRO("Centilitro", "cl"),
    MILLILITRO("Millilitro", "ml"),
    CUP("Cup", "cup"),
    TABLESPOON("Tablespoon", "tbsp"),
    TEASPOON("Teaspoon", "tsp"),
    ONCIA("Oncia", "oz"),
    ONCIA_LIQUIDA("Oncia liquida", "fl. oz.");

    private String printable;
    private String abbreviation;

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
