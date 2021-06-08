package it.unibo.android.ricettapp.presenter.esecuzionericetta;

import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.Passaggio;

public interface IEsecuzione {

    int calcolaRicetteEseguibili() ;
    public Passaggio scorriPassaggio(int ricetta, int direzione) ;
    public boolean haaltriPassaggi(int ricetta) ;
    public IngredienteConQuantita[] vediIngredienti(int ricetta) ;
    public boolean termina(int ricetta) ;

}
