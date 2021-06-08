package it.unibo.android.ricettapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListaDellaSpesa implements IContenitoreIngredienti {

    private final long id;
    private static ListaDellaSpesa instance = null;

    private final List<IngredienteConQuantita> ingredienti;

    public long getId() {
        return id;
    }

    protected ListaDellaSpesa() {
        this.id = System.currentTimeMillis();
        this.ingredienti = new ArrayList<>();
    }

    public static ListaDellaSpesa getInstance() {
        if (instance == null) {
            instance = new ListaDellaSpesa();
        }
        return instance;
    }

    public boolean acquistaIngrediente(IngredienteConQuantita ingrediente) {
        return this.ingredienti.remove(ingrediente) && Frigo.getInstance().aggiungiIngrediente(ingrediente);
    }

    public boolean aggiungiIngrediente(IngredienteConQuantita ingrediente) {
        if (!ingredienti.contains(ingrediente)) {
            this.ingredienti.add(ingrediente);
            return true;
        } else {
            return false;
        }
    }

    public boolean rimuoviIngrediente(IngredienteConQuantita ingrediente) {
        return this.ingredienti.remove(ingrediente);
    }

    @Override
    public Collection<IIngrediente> getIngredienti() {
        return new ArrayList<>(this.ingredienti);
    }

}
