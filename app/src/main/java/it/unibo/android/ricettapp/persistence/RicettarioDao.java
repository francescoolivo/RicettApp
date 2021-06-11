package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.Ricettario;

@Dao
public interface RicettarioDao {

    @Query("SELECT * FROM ricettario")
    LiveData<Ricettario> get();

    @Insert
    void insert(Ricettario... ricettarios);
}
