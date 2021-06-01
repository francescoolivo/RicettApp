package it.unibo.android.ricettapp.model;

public class IngredienteConUnita {

    private Ingrediente ingrediente;
    private int calorie;
    private UnitaDiMisura unita;

    public IngredienteConUnita(Ingrediente ingrediente, int calorie, UnitaDiMisura unita) {
        this.ingrediente = ingrediente;
        this.calorie = calorie;
        this.unita = unita;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public UnitaDiMisura getUnita() {
        return unita;
    }

    public void setUnita(UnitaDiMisura unita) {
        this.unita = unita;
    }
}
