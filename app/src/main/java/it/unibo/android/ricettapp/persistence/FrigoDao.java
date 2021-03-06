package it.unibo.android.ricettapp.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;

@Dao
public interface FrigoDao {

    @Query("SELECT * FROM frigo")
    Frigo get();

    @Insert
    void insert(Frigo... frigo);

}
