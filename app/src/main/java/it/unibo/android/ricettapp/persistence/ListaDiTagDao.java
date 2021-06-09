package it.unibo.android.ricettapp.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.ListaDiTag;

@Dao
public interface ListaDiTagDao {

    @Query("SELECT * FROM listaditag")
    ListaDiTag get();

    @Insert
    void insert(ListaDiTag... listaDiTags);

}
