package it.unibo.android.ricettapp.model;

import java.io.File;
import java.util.Date;

public class Ricetta implements IParametroRicercaRicetta{

    private long id;
    private String nome;
    private String descrizione;
    private Date ultimaModifica;
    private File[] fotografie;
    private int tempoDiEsecuzione;
    private int numeroDiPersone;
    private IngredienteConQuantita[] ingredienti;
    private Passaggio[] passaggi;
    private Tag[] tags;

    public Ricetta(String nome, String descrizione, File[] fotografie, int tempoDiEsecuzione, int numeroDiPersone, IngredienteConQuantita[] ingredienti, Passaggio[] passaggi, Tag[] tags) {
        this.id = System.currentTimeMillis();
        this.nome = nome;
        this.descrizione = descrizione;
        this.fotografie = fotografie;
        this.tempoDiEsecuzione = tempoDiEsecuzione;
        this.numeroDiPersone = numeroDiPersone;
        this.ingredienti = ingredienti;
        this.passaggi = passaggi;
        this.tags = tags;
    }

    public Ricetta() {
        this.id = 0;
        this.nome = "";
        this.descrizione = "";
        this.fotografie = new File[50];
        this.tempoDiEsecuzione = 0;
        this.numeroDiPersone = 0;
        this.ingredienti = new IngredienteConQuantita[50];
        this.passaggi = new Passaggio[50];
        this.tags = new Tag[50];

    }

    public Passaggio[] getPassaggi() {
        return passaggi;
    }

    public void setPassaggi(Passaggio[] passaggi) {
        this.passaggi = passaggi;
        aggiornaUltimaModifica();
    }

    public void setIngredienti(IngredienteConQuantita[] ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Tag[] getTags() {
        return tags.clone();
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
        aggiornaUltimaModifica();
    }

    public IngredienteConQuantita[] getIngredienti() {
        return this.ingredienti.clone();
    }

    public long getId() { return id; }

    public String getNome() {return nome; }

    public String getDescrizione() {return descrizione; }

    public Date getUltimaModifica() {return ultimaModifica; }

    public File[] getFotografie() {return fotografie; }

    public int getTempoDiEsecuzione() {return tempoDiEsecuzione; }

    public int getNumeroDiPersone() {return numeroDiPersone; }

    public void setId(long id) {this.id = id; }

    public void setNome(String nome) {this.nome = nome; aggiornaUltimaModifica();}

    public void setDescrizione(String descrizione) {this.descrizione = descrizione; aggiornaUltimaModifica();}

    public void setFotografie(File[] fotografie) {this.fotografie = fotografie; aggiornaUltimaModifica();}

    public void setTempoDiEsecuzione(int tempoDiEsecuzione) {this.tempoDiEsecuzione = tempoDiEsecuzione; aggiornaUltimaModifica();}

    public void setNumeroDiPersone(int numeroDiPersone) {this.numeroDiPersone = numeroDiPersone; aggiornaUltimaModifica();}

    public int calcolaApportoCalorico(){
       int apportoTotale = 0;

       for (IngredienteConQuantita ingr : ingredienti) {
           apportoTotale += ingr.getQuantita()*ingr.getCalorie();
        }

       return apportoTotale / this.getNumeroDiPersone();
    }

    @Override
    public boolean matches(IParametroRicercaRicetta other) {
        if (other instanceof Ricetta) {
            return this.equals(other);
        } else if (other instanceof Tag) {
            for (Tag t : this.getTags()) {
                if (t.matches(other)) {
                    return true;
                }
            }
            return false;
        } else if (other instanceof Ingrediente) {
            for (IngredienteConQuantita i : this.getIngredienti()) {
                if (i.matches(other)) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Ricetta) {
            return this.id == ((Ricetta) other).id;
        } else {
            return false;
        }
    }
    private void aggiornaUltimaModifica() {
        this.ultimaModifica = new Date();
    }
}
