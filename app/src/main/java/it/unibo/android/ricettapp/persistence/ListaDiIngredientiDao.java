package it.unibo.android.ricettapp.persistence;

import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.ListaDiIngredienti;

public interface ListaDiIngredientiDao {

    @Query("SELECT * FROM listadiingredienti")
    ListaDiIngredienti get();

    @Insert
    void insert(ListaDiIngredienti... listaDiIngredienti);
}
