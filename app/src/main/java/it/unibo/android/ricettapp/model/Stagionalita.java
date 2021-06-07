package it.unibo.android.ricettapp.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Stagionalita implements IParametroRicercaIngrediente {

    private int inizio = 1;
    private int fine = 12;

    public Stagionalita(int inizio, int fine) {
        if (inizio >= 1 && inizio <= 12) {
            this.inizio = inizio;
        }
        if (fine >= 1 && fine <= 12) {
            this.fine = fine;
        }
    }

    public int getInizio() {
        return inizio;
    }

    public void setInizio(int inizio) {
        this.inizio = inizio;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    @Override
    public boolean matches(IParametroRicercaIngrediente other) {
        if (other instanceof Stagionalita) {
            return this.getInizio() >= ((Stagionalita) other).getInizio() && this.getFine() <= ((Stagionalita) other).getFine();
        } else {
            return false;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean oggiDentroStagionalita() {
        int month = LocalDate.now().getMonthValue();
        return month >= this.getInizio() && month <= this.getFine();
    }
}
