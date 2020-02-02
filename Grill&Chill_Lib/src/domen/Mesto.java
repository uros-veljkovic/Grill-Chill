/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author urosv
 */
public class Mesto implements OpstiDomenskiObjekat{
    
    private int postanskiBroj;
    private String grad;
    private String drzava;

    public Mesto() {
    }
    public Mesto(int postanskiBroj, String grad, String drzava) {
        this.postanskiBroj = postanskiBroj;
        this.grad = grad;
        this.drzava = drzava;
    }
    
    public int getPostanskiBroj() {
        return postanskiBroj;
    }
    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getGrad() {
        return grad;
    }
    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }
    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return drzava + ", " + grad;
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
        final Mesto other = (Mesto) obj;
        if (this.postanskiBroj != other.postanskiBroj) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }
    
    //Nepotrebno, jer nemamo sistemsku operaciju za kreiranje novog mesta
    @Override
    public String vratiAtributeZaInsert() {
        return "";
    }
    //Nepotrebno, jer nemamo sistemsku operaciju za kreiranje novog mesta
    @Override
    public String vratiVrednostiZaInsert() {
        return "";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "";
    }

    @Override
    public String vratiID() {
        return String.valueOf(this.getPostanskiBroj());
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
