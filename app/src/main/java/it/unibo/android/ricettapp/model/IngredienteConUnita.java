package it.unibo.android.ricettapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

// @Entity(primaryKeys = {"ingrediente","unita"})

@Entity(foreignKeys = {@ForeignKey(entity = Ingrediente.class, parentColumns = {"id"}, childColumns = {"unita"})})
public class IngredienteConUnita implements IIngredienteConUnita {

    @ColumnInfo(name = "ingrediente")
    private Ingrediente ingrediente;
    @ColumnInfo(name = "unita")
    private UnitaDiMisura unita;
    @ColumnInfo(name = "calorie")
    private int calorie;

    public IngredienteConUnita(Ingrediente ingrediente, int calorie, UnitaDiMisura unita) {
        this.ingrediente = ingrediente;
        this.calorie = calorie;
        this.unita = unita;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public UnitaDiMisura getUnita() {
        return unita;
    }

    public void setUnita(UnitaDiMisura unita) {
        this.unita = unita;
    }

    public boolean equals(Object other) {
        if (other instanceof IngredienteConUnita) {
            return this.ingrediente.equals(((IngredienteConUnita) other).getIngrediente()) && this.unita == ((IngredienteConUnita) other).getUnita();
        } else {
            return false;
        }
    }

    @Override
    public boolean matches(IParametroRicercaIngrediente other) {
        return false;
    }
}
