/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author urosv
 */
public class StavkaRacuna implements OpstiDomenskiObjekat{
    
    private int racunID;
    private int stavkaID;
    private int kolicina;
    //TODO: izmeniti naziv atributa prodajnaCena u ukupanIznos
    private double ukupanIznos;
    private Proizvod proizvod;

    public StavkaRacuna() {
    }
    public StavkaRacuna(int racunID, int stavkaID, int kolicina, Proizvod proizvod) {
        this.racunID = racunID;
        this.stavkaID = stavkaID;
        this.kolicina = kolicina;
        this.ukupanIznos = kolicina*proizvod.getCena();
        this.proizvod = proizvod;
    }
    

    public int getRacunID() {
        return racunID;
    }
    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public int getStavkaID() {
        return stavkaID;
    }
    public void setStavkaID(int stavkaID) {
        this.stavkaID = stavkaID;
    }

    public int getKolicina() {
        return kolicina;
    }
    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }
    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }
    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return proizvod.toString();
    }
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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (!Objects.equals(this.racunID, other.racunID)) {
            return false;
        }
        if (!Objects.equals(this.stavkaID, other.stavkaID)) {
            return false;
        }
        if (!Objects.equals(this.proizvod, other.proizvod)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(StavkaID, RacunID, Kolicina, Proizvod, UkupanIznos)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("
                + this.getStavkaID() + ","
                + this.getRacunID() + ","
                + this.getKolicina() + ","
                + this.getProizvod().getProizvodID() + ","
                + this.getUkupanIznos()
                + ")";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "StavkaID";
    }

    @Override
    public String vratiID() {
        return String.valueOf(this.getStavkaID());
    }

    @Override
    public String vratiSELECTjointUpita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiFROMjointUpita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiWHEREjointUpita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    


    
    
}
