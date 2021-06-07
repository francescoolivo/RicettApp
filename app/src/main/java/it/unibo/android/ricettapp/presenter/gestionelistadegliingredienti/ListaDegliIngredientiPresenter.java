package it.unibo.android.ricettapp.presenter.gestionelistadegliingredienti;

import java.io.File;

import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.IngredienteConUnita;
import it.unibo.android.ricettapp.model.ListaDiIngredienti;
import it.unibo.android.ricettapp.model.Stagionalita;
import it.unibo.android.ricettapp.model.TipologiaIngrediente;

public class ListaDegliIngredientiPresenter implements IListaDegliIngredienti{
    @Override
    public boolean aggiungiIngrediente(Ingrediente ingrediente) {
        return ListaDiIngredienti.getInstance().aggiungiIngrediente(ingrediente);
    }

    @Override
    public Ingrediente creaIngrediente(String nome, File[] fotografie, TipologiaIngrediente[] tipologie, IngredienteConUnita[] unita, Stagionalita stagionalita) {
        return new Ingrediente(nome, fotografie, tipologie, unita, stagionalita);
    }

    @Override
    public boolean modificaIngrediente(Ingrediente ingrediente) {
        return ListaDiIngredienti.getInstance().modificaIngrediente(ingrediente);
    }

    @Override
    public void scegliIngrediente(Ingrediente ingrediente) {
        // TODO Invocare View Ingrediente
    }

    @Override
    public boolean eliminaIngrediente(Ingrediente ingrediente) {
        return ListaDiIngredienti.getInstance().eliminaIngrediente(ingrediente);
    }
}
