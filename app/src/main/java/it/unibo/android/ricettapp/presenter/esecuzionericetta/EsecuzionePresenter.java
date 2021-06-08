package it.unibo.android.ricettapp.presenter.esecuzionericetta;

import java.util.ArrayList;
import java.util.List;

import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.Passaggio;
import it.unibo.android.ricettapp.model.Ricetta;

public class EsecuzionePresenter implements IEsecuzione{

    private static EsecuzionePresenter instance = null;

    private int ricetteEseguibili;
    private List<RicettaConPassaggio> passaggiCorrenti;

    protected EsecuzionePresenter() {
        this.ricetteEseguibili = calcolaRicetteEseguibili();
        this.passaggiCorrenti = new ArrayList<>();
        // mantiene l'ordine di inserimento delle entry anche quando viene modificata
    }

    public EsecuzionePresenter getInstance() {
        if (instance == null) {
            instance = new EsecuzionePresenter();
        }
        return instance;
    }

    public int getRicetteEseguibili() {
        return ricetteEseguibili;
    }

    public void setRicetteEseguibili(int ricetteEseguibili) {
        this.ricetteEseguibili = ricetteEseguibili;
    }

    @Override
    public int calcolaRicetteEseguibili() {
        // TODO Calcola ricette eseguibili
        return 0;
    }

    @Override
    public Passaggio scorriPassaggio(int ricettaIndex, int direzione) {
        if (direzione > 0) {
            passaggiCorrenti.get(ricettaIndex).prossimoPassaggio();
        } else {
            passaggiCorrenti.get(ricettaIndex).passaggioPrecedente();
        }
        return passaggiCorrenti.get(ricettaIndex).getRicetta().getPassaggi()[ricettaIndex];
    }

    @Override
    public boolean haAltriPassaggi(int ricettaIndex) {
        return passaggiCorrenti.get(ricettaIndex).haAltriPassaggi();
    }

    @Override
    public IngredienteConQuantita[] vediIngredienti(int ricettaIndex) {
        Ricetta ric = passaggiCorrenti.get(ricettaIndex).getRicetta();
        // TODO Popup view ingredienti ricetta corrente
        return ric.getIngredienti();
    }

    @Override
    public boolean termina(int ricettaIndex) {
        Ricetta ric = passaggiCorrenti.get(ricettaIndex).getRicetta();
        // TODO Show View terminazione ingredienti
        passaggiCorrenti.remove(ricettaIndex);
        return true;
    }

    @Override
    public boolean eseguiRicetta(Ricetta ricetta) {
        if (passaggiCorrenti.size() == ricetteEseguibili) {
            return false;
        } else {
            passaggiCorrenti.add(new RicettaConPassaggio(ricetta, -1));
            // passaggio -1 = vista ingredienti
            return true;
        }
    }
}
