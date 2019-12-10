/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author urosv
 */
public class Racun {
    
    private int racunID;
    private Zaposleni kreiraoZaposleni;
    private Date datumIzrade;
    private double ukupanIznos;
    private boolean obradjen;
    private boolean storniran;
    private List<StavkaRacuna> stavke;

    //TODO: Da li smem da napravim racun koji nema referenciranog Zaposlenog kroz prazan konstruktor?
    
    public Racun() {
        stavke = new ArrayList<StavkaRacuna>();
    }
    public Racun(int racunID, Zaposleni kreiraoZaposleni, Date datumIzrade, double ukupanIznos, boolean obradjen, boolean storniran, List<StavkaRacuna> stavke) {
        this.racunID = racunID;
        this.kreiraoZaposleni = kreiraoZaposleni;
        this.datumIzrade = datumIzrade;
        this.ukupanIznos = ukupanIznos;
        this.obradjen = obradjen;
        this.storniran = storniran;
        this.stavke = stavke;
    }
    

    public int getRacunID() {
        return racunID;
    }
    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Zaposleni getKreiraoZaposleni() {
        return kreiraoZaposleni;
    }
    public void setKreiraoZaposleni(Zaposleni kreiraoZaposleni) {
        this.kreiraoZaposleni = kreiraoZaposleni;
    }

    public Date getDatumIzrade() {
        return datumIzrade;
    }
    public void setDatumIzrade(Date datumIzrade) {
        this.datumIzrade = datumIzrade;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }
    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public boolean isObradjen() {
        return obradjen;
    }
    public void setObradjen(boolean obradjen) {
        this.obradjen = obradjen;
    }

    public boolean isStorniran() {
        return storniran;
    }
    public void setStorniran(boolean storniran) {
        this.storniran = storniran;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }
    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    //TODO: Da li je uredu sto sam poredio racune i po ID-u i po Zaposlenom ?
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Racun other = (Racun) obj;
        if (!Objects.equals(this.racunID, other.racunID)) {
            return false;
        }
        if (!Objects.equals(this.kreiraoZaposleni, other.kreiraoZaposleni)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
