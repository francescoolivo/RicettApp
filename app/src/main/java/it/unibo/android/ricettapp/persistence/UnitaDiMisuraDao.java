package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Tag;
import it.unibo.android.ricettapp.model.UnitaDiMisura;

@Dao
public interface UnitaDiMisuraDao {

    @Query("SELECT * FROM unitadimisura")
    LiveData<UnitaDiMisura> getAll();

    @Insert
    void insert(UnitaDiMisura... unitaDiMisuras);

    @Delete
    void delete(UnitaDiMisura unitaDiMisura);
}
