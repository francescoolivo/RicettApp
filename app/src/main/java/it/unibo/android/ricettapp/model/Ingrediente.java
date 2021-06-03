package it.unibo.android.ricettapp.model;

import java.io.File;

public class Ingrediente implements IParametroRicercaIngrediente, IParametroRicercaRicetta, IIngrediente {

    private long id;
    private String nome;
    private File[] fotografie;
    private TipologiaIngrediente[] tipologie;
    private IngredienteConUnita[] unita;
    private Stagionalita stagionalita;

    public Ingrediente(String nome, File[] fotografie, TipologiaIngrediente[] tipologie, IngredienteConUnita[] unita) {
        this.id = System.currentTimeMillis();
        this.nome = nome;
        this.fotografie = fotografie;
        this.tipologie = tipologie;
        this.unita = unita;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public File[] getFotografie() {
        return fotografie.clone();
    }

    public void setFotografie(File[] fotografie) {
        this.fotografie = fotografie;
    }

    public TipologiaIngrediente[] getTipologie() {
        return tipologie.clone();
    }

    public void setTipologie(TipologiaIngrediente[] tipologie) {
        this.tipologie = tipologie;
    }

    public IngredienteConUnita[] getUnita() {
        return unita.clone();
    }

    public void setUnita(IngredienteConUnita[] unita) {
        this.unita = unita;
    }

    public Stagionalita getStagionalita() {
        return stagionalita;
    }

    public void setStagionalita(Stagionalita stagionalita) {
        this.stagionalita = stagionalita;
    }

    @Override
    public boolean matches(IParametroRicercaIngrediente other) {
        if (other instanceof Ingrediente) {
            if (((Ingrediente) other).getNome() == null) {
                return this.getStagionalita().matches(((Ingrediente) other).getStagionalita());
            } else {
                if (((Ingrediente) other).getStagionalita() != null) {
                    return this.getNome().equals(((Ingrediente) other).getNome());
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean matches(IParametroRicercaRicetta other) {
        return this.equals(other);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Ingrediente) {
            return ((Ingrediente) other).getId() == this.getId();
        } else {
            return false;
        }
    }
}
