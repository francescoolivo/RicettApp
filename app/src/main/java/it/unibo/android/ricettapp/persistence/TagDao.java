package it.unibo.android.ricettapp.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Frigo;
import it.unibo.android.ricettapp.model.Tag;

@Dao
public interface TagDao {

    @Query("SELECT * FROM Tag")
    Tag getAll();

    @Insert
    void insert(Tag... tags);

    @Delete
    void delete(Tag tag);
}
