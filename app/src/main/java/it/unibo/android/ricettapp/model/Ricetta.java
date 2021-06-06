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

    public Ricetta(String nome, String descrizione, Date ultimaModifica, File[] fotografie, int tempoDiEsecuzione, int numeroDiPersone, IngredienteConQuantita[] ingredienti, Passaggio[] passaggi, Tag[] tags) {
        this.id = System.currentTimeMillis();
        this.nome = nome;
        this.descrizione = descrizione;
        this.ultimaModifica = ultimaModifica;
        this.fotografie = fotografie;
        this.tempoDiEsecuzione = tempoDiEsecuzione;
        this.numeroDiPersone = numeroDiPersone;
        this.ingredienti = ingredienti;
        this.passaggi = passaggi;
        this.tags = tags;
    }

    public Passaggio[] getPassaggi() {
        return passaggi;
    }

    public void setPassaggi(Passaggio[] passaggi) {
        this.passaggi = passaggi;
    }

    public void setIngredienti(IngredienteConQuantita[] ingredienti) {
        this.ingredienti = ingredienti;
    }

    public Tag[] getTags() {
        return tags.clone();
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
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

    public void setNome(String nome) {this.nome = nome; }

    public void setDescrizione(String descrizione) {this.descrizione = descrizione; }

    public void setUltimaModifica(Date ultimaModifica) {this.ultimaModifica = ultimaModifica; }

    public void setFotografie(File[] fotografie) {this.fotografie = fotografie; }

    public void setTempoDiEsecuzione(int tempoDiEsecuzione) {this.tempoDiEsecuzione = tempoDiEsecuzione; }

    public void setNumeroDiPersone(int numeroDiPersone) {this.numeroDiPersone = numeroDiPersone;}

    public int calcolaApportoCalorico(){
       int apportoTotale = 0;

       for (IngredienteConQuantita ingr : ingredienti) {
           apportoTotale += ingr.getQuantita()*ingr.getCalorie();
        }

       return apportoTotale / this.getNumeroDiPersone();
    }

    @Override
    public boolean matches(IParametroRicercaRicetta other) {
        return this.equals(other);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Ricetta) {
            return this.id == ((Ricetta) other).id;
        } else {
            return false;
        }
    }
}
