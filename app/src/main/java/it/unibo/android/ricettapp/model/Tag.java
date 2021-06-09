package it.unibo.android.ricettapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tag implements IParametroRicercaRicetta {

    @PrimaryKey
    private String nome;

    public Tag(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean matches(IParametroRicercaRicetta other) {
        if (other instanceof Tag) {
            return ((Tag) other).getNome().equals(this.getNome());
        } else {
            return false;
        }
    }
}
