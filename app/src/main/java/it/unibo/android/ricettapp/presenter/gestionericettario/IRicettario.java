package it.unibo.android.ricettapp.presenter.gestionericettario;

import androidx.lifecycle.LiveData;

import it.unibo.android.ricettapp.model.Ricetta;

public interface IRicettario {

    boolean aggiungiRicetta(Ricetta ricetta) ;
    boolean modificaRicetta(Ricetta ricetta) ;
    LiveData<Ricetta> scegliRicetta(Long id) ;
    boolean eliminaRicetta(Ricetta ricetta) ;

}
