package it.unibo.android.ricettapp.persistence;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import it.unibo.android.ricettapp.model.IngredienteConUnita;

public interface IngredienteConUnitaDao {

    @Query("SELECT * FROM ingredienteconquantita")
    List<IngredienteConUnita> getAll();

    @Insert
    void insertAll(IngredienteConUnita... ingredienteConQuantita);

    @Delete
    void delete(IngredienteConUnita ingredienteConQuantita);

}
