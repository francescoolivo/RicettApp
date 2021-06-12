package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import it.unibo.android.ricettapp.model.Ricetta;

@Dao
public interface RicettaDao {

    @Query("SELECT * FROM ricetta")
    LiveData<List<Ricetta>> getAll();

    @Query("SELECT * FROM ricetta WHERE id=:id")
    LiveData<Ricetta> getRicetta(Long id);

    @Insert
    void insertAll(Ricetta... ricettas) ;

    @Update
    void update(Ricetta ricetta);

    @Delete
    void delete(Ricetta ricetta) ;
}
