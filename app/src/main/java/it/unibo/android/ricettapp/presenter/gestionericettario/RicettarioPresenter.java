package it.unibo.android.ricettapp.presenter.gestionericettario;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.persistence.Repository;

public class RicettarioPresenter extends ViewModel implements IRicettario{

    private Repository repository = Repository.Companion.get();
    private MutableLiveData<Long> ricettaIdLiveData = new MutableLiveData<>();

    public LiveData<List<Ricetta>> ricette = repository.getRicette();
    public LiveData<Ricetta> ricetta; //caricaRicetta(ricettaIdLiveData.getValue());

    public LiveData<Ricetta> caricaRicetta(Long id) {
        return repository.getRicetta(id);
    }

    @Override
    public boolean aggiungiRicetta(Ricetta ricetta) {
        repository.inserisciRicetta(ricetta);
        return true;
    }

    @Override
    public boolean modificaRicetta(Ricetta ricetta) {
        repository.aggiornaRicetta(ricetta);
        return true;
    }

    @Override
    public LiveData<Ricetta> scegliRicetta(Long id) {
        LiveData<Ricetta> ricetta = repository.getRicetta(id);
        Log.d("RICETTARIO_PRESENTER", "ricetta: "+ricetta.toString());
        return ricetta;
    }

    @Override
    public boolean eliminaRicetta(Ricetta ricetta) {
        repository.eliminaRicetta(ricetta);
        return true;
    }
}
