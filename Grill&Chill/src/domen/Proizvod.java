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
public class Proizvod {
    
    private Long proizvodID;
    private String naziv;
    private String opis;
    private Double cena;

    public Proizvod() {
    }
    public Proizvod(Long proizvodID, String naziv, String opis, Double cena) {
        this.proizvodID = proizvodID;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
    }
    
    public Long getProizvodID() {
        return proizvodID;
    }
    public void setProizvodID(Long proizvodID) {
        this.proizvodID = proizvodID;
    }

    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }
    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return naziv;
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
        final Proizvod other = (Proizvod) obj;
        if (!Objects.equals(this.proizvodID, other.proizvodID)) {
            return false;
        }
        return true;
    }

    
    
    
}
