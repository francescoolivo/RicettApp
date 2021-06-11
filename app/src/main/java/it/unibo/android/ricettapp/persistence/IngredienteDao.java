package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.unibo.android.ricettapp.model.Ingrediente;

@Dao
public interface IngredienteDao {

    @Query("SELECT * from ingrediente")
    LiveData<List<Ingrediente>> getAll();

    @Insert
    void insertAll(Ingrediente... ingredienti) ;

    @Delete
    void delete(Ingrediente ingrediente) ;
}
