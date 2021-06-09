package it.unibo.android.ricettapp.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.IngredienteConQuantita;
import it.unibo.android.ricettapp.model.IngredienteConUnita;
import it.unibo.android.ricettapp.model.ListaDellaSpesa;
import it.unibo.android.ricettapp.model.ListaDiIngredienti;
import it.unibo.android.ricettapp.model.ListaDiTag;
import it.unibo.android.ricettapp.model.Passaggio;
import it.unibo.android.ricettapp.model.Ricetta;
import it.unibo.android.ricettapp.model.Ricettario;
import it.unibo.android.ricettapp.model.Stagionalita;
import it.unibo.android.ricettapp.model.Tag;
import it.unibo.android.ricettapp.model.TipologiaIngrediente;
import it.unibo.android.ricettapp.model.UnitaDiMisura;

@Database(entities = {Frigo.class, Ingrediente.class, IngredienteConQuantita.class, IngredienteConUnita.class,
                        ListaDellaSpesa.class, ListaDiIngredienti.class, ListaDiTag.class, Passaggio.class,
                        Ricetta.class, Ricettario.class, Stagionalita.class, Tag.class,
                        TipologiaIngrediente.class, UnitaDiMisura.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FrigoDao frigoDao();
    public abstract IngredienteDao ingredienteDao();
    public abstract IngredienteConQuantitaDao ingredienteConQuantitaDao();
    public abstract IngredienteConUnitaDao ingredienteConUnitaDao();
    public abstract ListaDellaSpesaDao listaDellaSpesaDao();
    public abstract ListaDiIngredientiDao listaDiIngredientiDao();
    public abstract ListaDiTagDao listaDiTagDao();
    public abstract PassaggioDao passaggioDao();
    public abstract RicettaDao ricettaDao();
    public abstract RicettarioDao ricettarioDao();
    public abstract StagionalitaDao stagionalitaDao();
    public abstract TagDao tagDao();
    public abstract TipologiaIngredienteDao tipologiaIngredienteDao();
    public abstract UnitaDiMisuraDao unitaDiMisuraDao();

}
