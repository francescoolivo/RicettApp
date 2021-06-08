package it.unibo.android.ricettapp.presenter.esecuzionericetta;

import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.Passaggio;
import it.unibo.android.ricettapp.model.Ricetta;

public interface IEsecuzione {

    int calcolaRicetteEseguibili() ;
    Passaggio scorriPassaggio(int ricetta, int direzione) ;
    boolean haAltriPassaggi(int ricetta) ;
    IngredienteConQuantita[] vediIngredienti(int ricetta) ;
    boolean termina(int ricetta) ;
    boolean eseguiRicetta(Ricetta ricetta) ;

}
