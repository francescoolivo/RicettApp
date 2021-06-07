package it.unibo.android.ricettapp.presenter.gestionericettario;

import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.model.Ricettario;

public class RicettarioPresenter implements IRicettario{
    @Override
    public boolean aggiungiRicetta(Ricetta ricetta) {
        Ricettario ricettario = Ricettario.getInstance();
        return ricettario.aggiungiRicetta(ricetta);
    }

    @Override
    public boolean modificaRicetta(Ricetta ricetta) {
        Ricettario ricettario = Ricettario.getInstance();
        return ricettario.modificaRicetta(ricetta);
    }

    @Override
    public void scegliRicetta(Ricetta ricetta) {
        // TODO Invocare View Ricetta
    }

    @Override
    public boolean eliminaRicetta(Ricetta ricetta) {
        Ricettario ricettario = Ricettario.getInstance();
        return ricettario.eliminaRicetta(ricetta);
    }
}
