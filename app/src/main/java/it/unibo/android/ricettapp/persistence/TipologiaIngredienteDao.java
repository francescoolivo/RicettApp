package it.unibo.android.ricettapp.persistence;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import it.unibo.android.ricettapp.model.Tag;
import it.unibo.android.ricettapp.model.TipologiaIngrediente;

@Dao
public interface TipologiaIngredienteDao {

    @Query("SELECT * FROM tipologiaingrediente")
    TipologiaIngrediente getAll();

    @Insert
    void insert(TipologiaIngrediente... tipologiaIngredientes);

    @Delete
    void delete(TipologiaIngrediente tipologiaIngrediente);
}
