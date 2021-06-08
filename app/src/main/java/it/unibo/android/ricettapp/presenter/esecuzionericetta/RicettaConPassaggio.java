package it.unibo.android.ricettapp.presenter.esecuzionericetta;

import it.unibo.android.ricettapp.model.Ricetta;

public class RicettaConPassaggio {

    private Ricetta ricetta;
    private int passaggio;

    public RicettaConPassaggio(Ricetta ricetta, int passaggio) {
        this.ricetta = ricetta;
        this.passaggio = passaggio;
    }

    public Ricetta getRicetta() {
        return ricetta;
    }

    public void setRicetta(Ricetta ricetta) {
        this.ricetta = ricetta;
    }

    public int getPassaggio() {
        return passaggio;
    }

    public void setPassaggio(int passaggio) {
        this.passaggio = passaggio;
    }
}
