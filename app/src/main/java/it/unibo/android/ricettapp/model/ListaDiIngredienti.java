package it.unibo.android.ricettapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListaDiIngredienti implements IContenitoreIngredienti{

    private static ListaDiIngredienti instance = null;

    private final List<Ingrediente> ingredienti;

    protected ListaDiIngredienti() {
        this.ingredienti = new ArrayList<>();
    }

    public static ListaDiIngredienti getInstance() {
        if (instance == null) {
            instance = new ListaDiIngredienti();
        }
        return instance;
    }

    public boolean aggiungiIngrediente(Ingrediente ingrediente) {
        if (!ingredienti.contains(ingrediente)) {
            this.ingredienti.add(ingrediente);
            return true;
        } else {
            return false;
        }
    }

    public boolean modificaIngrediente(Ingrediente nuovoIngrediente) {
        if (!this.ingredienti.contains(nuovoIngrediente)) {
            this.ingredienti.add(nuovoIngrediente);
            return false;
        } else {
            this.ingredienti.remove(nuovoIngrediente);
            this.ingredienti.add(nuovoIngrediente);
            return true;
        }
    }

    public boolean eliminaIngrediente(Ingrediente removeIngrediente) {
        return this.ingredienti.remove(removeIngrediente);
    }

    @Override
    public Collection<IIngrediente> getIngredienti() {
        return new ArrayList<>(this.ingredienti);
    }
}
