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
public class Zaposleni {
    
    private Long zaposleniID;
    private String imePrezime;
    private String username;
    private String password;
    private boolean menadzer;
    private Mesto mestoBoravista;

    public Zaposleni() {
    }
    public Zaposleni(Long zaposleniID, String imePrezime, String username, String password, boolean menadzer, Mesto mestoBoravista) {
        this.zaposleniID = zaposleniID;
        this.imePrezime = imePrezime;
        this.username = username;
        this.password = password;
        this.menadzer = menadzer;
        this.mestoBoravista = mestoBoravista;
    }

    
    public Long getZaposleniID() {
        return zaposleniID;
    }
    public void setZaposleniID(Long zaposleniID) {
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
    

    
    
    
    
}
