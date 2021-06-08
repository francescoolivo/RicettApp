package it.unibo.android.ricettapp.presenter.gestionefrigo;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.IngredienteConUnita;
import it.unibo.android.ricettapp.model.ListaDellaSpesa;
import it.unibo.android.ricettapp.model.UnitaDiMisura;

public class FrigoPresenter implements IFrigo{

    @Override
    public boolean aggiungiIngrediente(IngredienteConUnita ingrediente, int quantita) {
        Frigo frigo = Frigo.getInstance();

        return frigo.aggiungiIngrediente(new IngredienteConQuantita(ingrediente, quantita));
    }

    @Override
    public boolean modificaIngrediente(IngredienteConUnita ingrediente, int quantita) {
        Frigo frigo = Frigo.getInstance();

        return frigo.rimuoviIngrediente(new IngredienteConQuantita(ingrediente, quantita)) && frigo.aggiungiIngrediente(new IngredienteConQuantita(ingrediente, quantita));
    }

    @Override
    public boolean terminaIngrediente(IngredienteConUnita ingrediente, int quantita) {
        Frigo frigo = Frigo.getInstance();

        return frigo.terminaIngrediente(new IngredienteConQuantita(ingrediente, quantita));
    }

    @Override
    public boolean eliminaIngrediente(IngredienteConUnita ingrediente) {
        Frigo frigo = Frigo.getInstance();

        return frigo.rimuoviIngrediente(new IngredienteConQuantita(ingrediente, 0));
    }

    @Override
    public void scegliIngrediente(Ingrediente ingrediente) {
        // TODO Invocare View Ingrediente
    }
}
