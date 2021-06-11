package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.unibo.android.ricettapp.model.Stagionalita;

@Dao
public interface StagionalitaDao {

    @Query("SELECT * FROM stagionalita")
    LiveData<List<Stagionalita>> getAll();

    @Insert
    void insertAll(Stagionalita... stagionalitas);

    @Delete
    void delete(Stagionalita stagionalita);
}
