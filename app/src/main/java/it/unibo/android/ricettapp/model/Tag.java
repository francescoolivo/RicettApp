package it.unibo.android.ricettapp.model;

public class Tag implements IParametroRicercaRicetta {

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
