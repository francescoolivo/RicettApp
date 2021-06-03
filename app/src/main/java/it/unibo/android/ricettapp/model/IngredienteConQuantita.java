package it.unibo.android.ricettapp.model;

public class IngredienteConQuantita extends IngredienteConUnita {

    private float quantita;

    public IngredienteConQuantita(Ingrediente ingrediente, int calorie, UnitaDiMisura unitaDiMisura, float quantita) {
        super(ingrediente, calorie, unitaDiMisura);
        this.quantita = quantita;
    }

    public float getQuantita() {
        return quantita;
    }

    public boolean modificaQuantita(float newQuantita) {
        this.quantita = newQuantita;
        return true;
    }
}
