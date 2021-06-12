package it.unibo.android.ricettapp.presenter.gestionericettario;

import java.util.List;

import it.unibo.android.ricettapp.model.Ricetta;

public interface IRicettario {

    boolean aggiungiRicetta(Ricetta ricetta) ;
    boolean modificaRicetta(Ricetta ricetta) ;
    Ricetta scegliRicetta(Long id) ;
    boolean eliminaRicetta(Ricetta ricetta) ;

}
