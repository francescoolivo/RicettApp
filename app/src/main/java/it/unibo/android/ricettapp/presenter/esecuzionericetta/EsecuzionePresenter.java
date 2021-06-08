package it.unibo.android.ricettapp.presenter.esecuzionericetta;

import java.util.ArrayList;
import java.util.List;

import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.Passaggio;

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
    public Passaggio scorriPassaggio(int ricetta, int direzione) {
        return null;
    }

    @Override
    public boolean haaltriPassaggi(int ricetta) {
        return false;
    }

    @Override
    public IngredienteConQuantita[] vediIngredienti(int ricetta) {
        return new IngredienteConQuantita[0];
    }

    @Override
    public boolean termina(int ricetta) {
        return false;
    }
}
