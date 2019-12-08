/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Objects;

/**
 *
 * @author urosv
 */
public class StavkaRacuna {
    
    private Long racunID;
    private Long stavkaID;
    private int kolicina;
    //TODO: izmeniti naziv atributa prodajnaCena u ukupanIznos
    private double ukupanIznos;
    private Proizvod proizvod;

    public StavkaRacuna() {
    }
    public StavkaRacuna(Long racunID, Long stavkaID, int kolicina, Proizvod proizvod) {
        this.racunID = racunID;
        this.stavkaID = stavkaID;
        this.kolicina = kolicina;
        this.ukupanIznos = kolicina*proizvod.getCena();
        this.proizvod = proizvod;
    }
    

    public Long getRacunID() {
        return racunID;
    }
    public void setRacunID(Long racunID) {
        this.racunID = racunID;
    }

    public Long getStavkaID() {
        return stavkaID;
    }
    public void setStavkaID(Long stavkaID) {
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
    
    


    
    
}
