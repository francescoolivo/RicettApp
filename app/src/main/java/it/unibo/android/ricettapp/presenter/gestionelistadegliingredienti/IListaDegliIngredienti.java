package it.unibo.android.ricettapp.presenter.gestionelistadegliingredienti;

import java.io.File;

import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.IngredienteConUnita;
import it.unibo.android.ricettapp.model.Stagionalita;
import it.unibo.android.ricettapp.model.TipologiaIngrediente;

public interface IListaDegliIngredienti {

    boolean aggiungiIngrediente(Ingrediente ingrediente) ;
    Ingrediente creaIngrediente(String nome, File[] fotografie, TipologiaIngrediente[] tipologie, IngredienteConUnita[] unita, Stagionalita stagionalita) ;
    boolean modificaIngrediente(Ingrediente ingrediente) ;
    void scegliIngrediente(Ingrediente ingrediente) ;
    boolean eliminaIngrediente(Ingrediente ingrediente) ;
}
