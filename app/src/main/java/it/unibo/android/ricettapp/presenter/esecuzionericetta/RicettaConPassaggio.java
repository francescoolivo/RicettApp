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

    public boolean prossimoPassaggio() {
        if (haAltriPassaggi()) {
            passaggio++;
            return true;
        } else {
            return false;
        }
    }

    public boolean passaggioPrecedente() {
        if (passaggio > 0) {
            passaggio--;
            return true;
        } else {
            return false;
        }
    }

    public boolean haAltriPassaggi() {
        return passaggio < ricetta.getPassaggi().length - 1;
    }
}
