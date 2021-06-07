package it.unibo.android.ricettapp.presenter.ricercaricetta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import it.unibo.android.ricettapp.model.IParametroRicercaRicetta;
import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.model.Ricettario;

public class RicercaRicettaPresenter implements IRicercaRicetta{
    @Override
    public Ricetta[] ricerca(Set<IParametroRicercaRicetta> parametri) {
        List<Ricetta> results = new ArrayList<>();
        Ricettario ricettario = Ricettario.getInstance();

        Collection<Ricetta> ricette = ricettario.getRicette();
        boolean good;

        for (Ricetta r : ricette) {

            good = true;

            for (IParametroRicercaRicetta par : parametri) {
                if (!r.matches(par)) {
                    good = false;
                    break;
                }
            }

            if (good) {
                results.add(r);
            }
        }

        // TODO Invocare View Ricettario con ricette trovate in results
        return results.toArray(new Ricetta[0]);
    }
}
