package it.unibo.android.ricettapp.presenter.gestionefrigo;

import it.unibo.android.ricettapp.model.Ingrediente;
import it.unibo.android.ricettapp.model.IngredienteConUnita;
import it.unibo.android.ricettapp.model.UnitaDiMisura;

public interface IFrigo {

    public boolean aggiungiIngrediente(IngredienteConUnita ingrediente, int quantita) ;
    public boolean modificaIngrediente(IngredienteConUnita ingrediente, int quantita) ;
    public boolean terminaIngrediente(IngredienteConUnita ingrediente, int quantita) ;
    public boolean eliminaIngrediente(IngredienteConUnita ingrediente) ;
    public void scegliIngrediente(Ingrediente ingrediente) ;

}
