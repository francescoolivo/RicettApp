package it.unibo.android.ricettapp.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.unibo.android.ricettapp.model.Ricetta;

@Dao
public interface RicettaDao {

    @Query("SELECT * FROM ricetta")
    List<Ricetta> getAll();

    @Insert
    void insertAll(Ricetta... ricettas) ;

    @Delete
    void delete(Ricetta ricetta) ;
}
