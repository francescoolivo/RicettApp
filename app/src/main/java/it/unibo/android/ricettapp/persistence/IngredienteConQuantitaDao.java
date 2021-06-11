package it.unibo.android.ricettapp.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.unibo.android.ricettapp.model.IngredienteConQuantita;

@Dao
public interface IngredienteConQuantitaDao {

    @Query("SELECT * FROM ingredienteconquantita")
    LiveData<List<IngredienteConQuantita>> getAll();

    @Insert
    void insertAll(IngredienteConQuantita... ingredienteConQuantita);

    @Delete
    void delete(IngredienteConQuantita ingredienteConQuantita);


}
