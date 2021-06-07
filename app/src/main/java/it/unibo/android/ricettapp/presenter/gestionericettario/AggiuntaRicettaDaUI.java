package it.unibo.android.ricettapp.presenter.gestionericettario;

import java.io.File;

import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.Passaggio;
import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.model.Tag;

public class AggiuntaRicettaDaUI implements IAggiuntaRicetta{
    @Override
    public Ricetta creaRicetta(String nome, String descrizione, File[] fotografie, int tempoDiEsecuzione, int numeroDiPersone, IngredienteConQuantita[] ingredienti, Passaggio[] passaggi, Tag[] tags) {
        return new Ricetta(nome, descrizione, fotografie, tempoDiEsecuzione, numeroDiPersone, ingredienti, passaggi, tags);
    }
}
