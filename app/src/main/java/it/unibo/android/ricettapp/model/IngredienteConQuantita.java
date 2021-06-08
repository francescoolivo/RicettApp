package it.unibo.android.ricettapp.model;

public class IngredienteConQuantita extends IngredienteConUnita {

    private int quantita;

    public IngredienteConQuantita(Ingrediente ingrediente, int calorie, UnitaDiMisura unitaDiMisura, int quantita) {
        super(ingrediente, calorie, unitaDiMisura);
        this.quantita = quantita;
    }

    public IngredienteConQuantita(IngredienteConUnita ingrediente, int quantita) {
        this(ingrediente.getIngrediente(), ingrediente.getCalorie(), ingrediente.getUnita(), quantita);
    }

    public float getQuantita() {
        return quantita;
    }

    public boolean modificaQuantita(int newQuantita) {
        this.quantita = newQuantita;
        return true;
    }
}
