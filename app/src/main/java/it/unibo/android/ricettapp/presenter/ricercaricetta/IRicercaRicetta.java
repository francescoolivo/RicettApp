package it.unibo.android.ricettapp.presenter.ricercaricetta;

import java.util.Set;

import it.unibo.android.ricettapp.model.IParametroRicercaRicetta;
import it.unibo.android.ricettapp.model.Ricetta;

public interface IRicercaRicetta {

    Ricetta[] ricerca(Set<IParametroRicercaRicetta> parametri) ;
}
