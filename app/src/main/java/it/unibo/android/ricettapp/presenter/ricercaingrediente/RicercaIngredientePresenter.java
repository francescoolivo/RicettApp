package it.unibo.android.ricettapp.presenter.ricercaingrediente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import it.unibo.android.ricettapp.model.IContenitoreIngredienti;
import it.unibo.android.ricettapp.model.IIngrediente;
import it.unibo.android.ricettapp.model.IParametroRicercaIngrediente;
import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.ListaDiIngredienti;

public class RicercaIngredientePresenter implements IRicercaIngrediente{
    @Override
    public IIngrediente[] ricerca(IContenitoreIngredienti contenitoreIngredienti, Set<IParametroRicercaIngrediente> parametri) {
        List<IIngrediente> results = new ArrayList<>();

        Collection<IIngrediente> ingredienti = contenitoreIngredienti.getIngredienti();

        boolean good;

        for (IIngrediente i : ingredienti) {

            good = true;

            for (IParametroRicercaIngrediente par : parametri) {
                if (!i.matches(par)) {
                    good = false;
                    break;
                }
            }

            if (good) {
                results.add(i);
            }
        }

        // TODO Invocare View ListaDiIngredienti con ingredienti trovati in results
        return results.toArray(new IIngrediente[0]);
    }
}
