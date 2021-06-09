package it.unibo.android.ricettapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Frigo implements IContenitoreIngredienti {

    @PrimaryKey
    private final long id;
    private static Frigo instance = null;

    @ColumnInfo(name = "ingredienti")
    private final List<IngredienteConQuantita> ingredienti;

    public long getId() {
        return id;
    }

    protected Frigo() {
        this.id = System.currentTimeMillis();
        this.ingredienti = new ArrayList<>();
    }

    public static Frigo getInstance() {
        if (instance == null) {
            instance = new Frigo();
        }
        return instance;
    }

    public boolean terminaIngrediente(IngredienteConQuantita ingrediente) {
        return this.ingredienti.remove(ingrediente) && ListaDellaSpesa.getInstance().aggiungiIngrediente(ingrediente);
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
