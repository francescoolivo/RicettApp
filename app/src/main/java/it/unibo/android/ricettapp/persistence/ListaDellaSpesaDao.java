package it.unibo.android.ricettapp.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.ListaDellaSpesa;

@Dao
public interface ListaDellaSpesaDao {

    @Query("SELECT * FROM listadellaspesa")
    ListaDellaSpesa get();

    @Insert
    void insert(ListaDellaSpesa... listaDellaSpesa);

}
