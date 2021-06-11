package it.unibo.android.ricettapp.presenter.gestionericettario;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.model.Ricettario;
import it.unibo.android.ricettapp.persistence.AppDatabase;
import it.unibo.android.ricettapp.persistence.RicettaDao;
import it.unibo.android.ricettapp.persistence.RicettarioDao;

public class RicettarioPresenter extends AndroidViewModel implements IRicettario{

    private AppDatabase database = Room.databaseBuilder(getApplication().getApplicationContext(),
            AppDatabase.class, "database-name").build();

    public RicettarioPresenter(@NonNull @NotNull Application application) {
        super(application);
    }

    @Override
    public boolean aggiungiRicetta(Ricetta ricetta) {
        Ricettario ricettario = Ricettario.getInstance();
        RicettaDao ricettaDao = database.ricettaDao();
        ricettaDao.insertAll(ricetta);
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

    // metodo aggiunto per usarlo nella view
    @Override
    public List<Ricetta> getRicette() {
        Ricettario ricettario = Ricettario.getInstance();
        return ricettario.getRicette();
    }

    @Override
    public void caricaRicetta(long id) {

    }

    @Override
    public void salvaRicetta(Ricetta ricetta) {

    }
}
