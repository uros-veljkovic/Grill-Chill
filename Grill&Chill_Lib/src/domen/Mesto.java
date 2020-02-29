/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author urosv
 */
public class Mesto implements OpstiDomenskiObjekat {

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
    public void postaviObjektaID(int id) {
        throw new UnsupportedOperationException("Not supported yet postaviObjektaID mesto."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet ucitajJedan mesto."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajSelectJedan() {
        throw new UnsupportedOperationException("Not supported yet dajSelectJedan."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajFromJedan() {
        throw new UnsupportedOperationException("Not supported yet dajFromJedan."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajWhereJedan() {
        throw new UnsupportedOperationException("Not supported yet dajWhereJedan."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajWhereSvi() {
        return "";
    }

    @Override
    public String dajSelectSvi() {
        return "SELECT *";
    }

    @Override
    public String dajFromSvi() {
        return "FROM mesto";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = new ArrayList<>();
        
        while (rs.next()) {
            int postanskiBroj = rs.getInt("PostanskiBroj");
            String grad = rs.getString("Grad");
            String drzava = rs.getString("Drzava");

            listaOdo.add(new Mesto(postanskiBroj, grad, drzava));
        }
        return listaOdo;
    }

    @Override
    public boolean jesteAutoIncrement() {
        return true;
    }

    @Override
    public String vratiParametreDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajUslovZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajSelectMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajFromMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajWhereMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
