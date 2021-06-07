package it.unibo.android.ricettapp.presenter.ricercaingrediente;

import java.util.Set;

import it.unibo.android.ricettapp.model.IContenitoreIngredienti;
import it.unibo.android.ricettapp.model.IIngrediente;
import it.unibo.android.ricettapp.model.IParametroRicercaIngrediente;

public interface IRicercaIngrediente {

    IIngrediente[] ricerca(IContenitoreIngredienti contenitoreIngredienti, Set<IParametroRicercaIngrediente> parametri) ;
}
