package it.unibo.android.ricettapp.presenter.gestionericettario;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.model.Ricettario;
import it.unibo.android.ricettapp.persistence.AppDatabase;
import it.unibo.android.ricettapp.persistence.Repository;
import it.unibo.android.ricettapp.persistence.RicettaDao;
import it.unibo.android.ricettapp.persistence.RicettarioDao;

public class RicettarioPresenter extends ViewModel implements IRicettario{

    private Repository repository = Repository.Companion.get();
    private MutableLiveData<Long> ricettaIdLiveData = new MutableLiveData<>();

    public LiveData<List<Ricetta>> ricette = repository.getRicette();
    public LiveData<Ricetta> ricetta = Transformations.switchMap(ricettaIdLiveData, this::caricaRicetta);

    private LiveData<Ricetta> caricaRicetta(Long id) {
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
    public Ricetta scegliRicetta(Long id) {
        Ricetta ricetta = repository.getRicetta(id).getValue();
        Log.d("RICETTARIO_PRESENTER", "ricetta: "+ricetta.toString());
        return ricetta;
    }

    @Override
    public boolean eliminaRicetta(Ricetta ricetta) {
        repository.eliminaRicetta(ricetta);
        return true;
    }
}
