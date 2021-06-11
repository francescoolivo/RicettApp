package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.ListaDiIngredienti;

@Dao
public interface ListaDiIngredientiDao {

    @Query("SELECT * FROM listadiingredienti")
    LiveData<ListaDiIngredienti> get();

    @Insert
    void insert(ListaDiIngredienti... listaDiIngredienti);
}
