package it.unibo.android.ricettapp.model;

import java.util.ArrayList;
import java.util.List;

public class Ricettario {

    private long id;
    private static Ricettario instance = null;

    private List<Ricetta> ricette;

    protected Ricettario() {
        this.id = System.currentTimeMillis();
        this.ricette = new ArrayList<>();
    }

    public static Ricettario getInstance() {
        if (instance == null) {
            instance = new Ricettario();
        }
        return instance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ricetta> getRicette() {
        return new ArrayList<>(this.ricette);
    }

    public void setRicette(List<Ricetta> ricette) {
        this.ricette = ricette;
    }

    public boolean aggiungiRicetta(Ricetta ricetta) {
        return this.ricette.add(ricetta);
    }

    public boolean modificaRicetta(Ricetta ricetta) {
        if (!this.ricette.contains(ricetta)) {
            this.ricette.add(ricetta);
            return false;
        } else {
            this.ricette.remove(ricetta);
            this.ricette.add(ricetta);
            return true;
        }
    }
}
