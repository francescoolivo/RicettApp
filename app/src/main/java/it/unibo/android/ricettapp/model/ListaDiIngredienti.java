package it.unibo.android.ricettapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class ListaDiIngredienti implements IContenitoreIngredienti{

    @PrimaryKey
    private final long id;
    private static ListaDiIngredienti instance = null;

    @ColumnInfo(name = "ingredienti")
    private final List<Ingrediente> ingredienti;

    protected ListaDiIngredienti() {
        this.id = System.currentTimeMillis();
        this.ingredienti = new ArrayList<>();
    }

    public long getId() {
        return id;
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
