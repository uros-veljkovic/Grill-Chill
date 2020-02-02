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
public class Zaposleni implements OpstiDomenskiObjekat{
    
    private int zaposleniID;
    private String imePrezime;
    private String username;
    private String password;
    private boolean menadzer;
    private Mesto mestoBoravista;

    public Zaposleni() {
    }
    public Zaposleni(int zaposleniID, String imePrezime, String username, String password, boolean menadzer, Mesto mestoBoravista) {
        this.zaposleniID = zaposleniID;
        this.imePrezime = imePrezime;
        this.username = username;
        this.password = password;
        this.menadzer = menadzer;
        this.mestoBoravista = mestoBoravista;
    }

    
    public int getZaposleniID() {
        return zaposleniID;
    }
    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getImePrezime() {
        return imePrezime;
    }
    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isMenadzer() {
        return menadzer;
    }
    public void setMenadzer(boolean menadzer) {
        this.menadzer = menadzer;
    }

    public Mesto getMestoBoravista() {
        return mestoBoravista;
    }
    public void setMestoBoravista(Mesto mestoBoravista) {
        this.mestoBoravista = mestoBoravista;
    }
    
    @Override
    public String toString() {
        return imePrezime;
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.zaposleniID, other.zaposleniID)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(ImePrezime, Username, Password, Menadzer, MestoID)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("
                + "'" + this.getImePrezime() + "',"
                + "'" + this.getUsername()+ "',"
                + "'" + this.getPassword()+ "',"
                + "'" + this.isMenadzer()+ "',"
                + "'" + this.getMestoBoravista().getPostanskiBroj() +
                ")";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "";
    }

    @Override
    public String vratiID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSELECTjointUpita() {
        return "z.*, m.PostanskiBroj, m.Grad, m.Drzava";
    }

    @Override
    public String vratiFROMjointUpita() {
        return "zaposleni z JOIN mesto m ON (z.MestoID = m.PostanskiBroj)";
    }

    @Override
    public String vratiWHEREjointUpita() {
        return "z.Username = '" + this.username + 
                "' AND z.Password = '" + this.password+ "'";
    }
    

    
}
