package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.unibo.android.ricettapp.model.Passaggio;

@Dao
public interface PassaggioDao {

    @Query("SELECT * FROM passaggio")
    LiveData<List<Passaggio>> getAll() ;

    @Insert
    void insertAll(Passaggio... passaggios) ;

    @Delete
    void delete(Passaggio passaggio) ;

}
