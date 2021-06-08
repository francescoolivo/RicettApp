package it.unibo.android.ricettapp.presenter.gestionelistadellaspesa;

import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.IngredienteConUnita;
import it.unibo.android.ricettapp.model.ListaDellaSpesa;
import it.unibo.android.ricettapp.presenter.gestionefrigo.IListaDellaSpesa;

public class ListaDellaSpesaPresenter implements IListaDellaSpesa {
    @Override
    public boolean aggiungiIngrediente(IngredienteConUnita ingrediente, int quantita) {
        ListaDellaSpesa lista = ListaDellaSpesa.getInstance();

        return lista.aggiungiIngrediente(new IngredienteConQuantita(ingrediente, quantita));
    }

    @Override
    public boolean modificaIngrediente(IngredienteConUnita ingrediente, int quantita) {
        ListaDellaSpesa lista = ListaDellaSpesa.getInstance();

        return lista.rimuoviIngrediente(new IngredienteConQuantita(ingrediente, quantita)) && lista.aggiungiIngrediente(new IngredienteConQuantita(ingrediente, quantita));
    }

    @Override
    public boolean acquistaIngrediente(IngredienteConUnita ingrediente, int quantita) {
        ListaDellaSpesa lista = ListaDellaSpesa.getInstance();

        return lista.acquistaIngrediente(new IngredienteConQuantita(ingrediente, quantita));
    }

    @Override
    public boolean eliminaIngrediente(IngredienteConUnita ingrediente) {
        ListaDellaSpesa lista = ListaDellaSpesa.getInstance();

        return lista.rimuoviIngrediente(new IngredienteConQuantita(ingrediente, 0));
    }

    @Override
    public void scegliIngrediente(Ingrediente ingrediente) {
        // TODO Invocare View Ingrediente
    }
}
