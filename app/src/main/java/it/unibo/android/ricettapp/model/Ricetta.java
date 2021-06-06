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
    private int numeroDiPersone = 2;

    public Ricetta(long id, String nome, String descrizione, Date ultimaModifica, File[] fotografie, int tempoDiEsecuzione, int numeroDiPersone) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.ultimaModifica = ultimaModifica;
        this.fotografie = fotografie;
        this.tempoDiEsecuzione = tempoDiEsecuzione;
        this.numeroDiPersone = numeroDiPersone;
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
       return -1;
    }

    @Override
    public boolean matches(IParametroRicercaRicetta other) {
        return this.equals(other);
    }
}
