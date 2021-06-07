package it.unibo.android.ricettapp.presenter.gestionericettario;

import it.unibo.android.ricettapp.model.Ricetta;

public interface IRicettario {

    boolean aggiungiRicetta(Ricetta ricetta) ;
    boolean modificaRicetta(Ricetta ricetta) ;
    void scegliRicetta(Ricetta ricetta) ;
    boolean eliminaRicetta(Ricetta ricetta) ;
}
