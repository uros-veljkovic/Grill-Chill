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
import java.util.Objects;

/**
 *
 * @author urosv
 */
public class Zaposleni implements OpstiDomenskiObjekat {

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
        return "INSERT INTO zaposleni (ImePrezime, Username, Password, Menadzer, MestoID)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("
                + "'" + this.getImePrezime() + "',"
                + "'" + this.getUsername() + "',"
                + "'" + this.getPassword() + "',"
                + "" + this.isMenadzer() + ","
                + "" + this.getMestoBoravista().getPostanskiBroj()
                + ")";
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
    public void postaviObjektaID(int id) {
        this.zaposleniID = id;
    }

    //Dobija se SELECT upitom, i to spajanjem tabela Mesto i Zaposleni
    @Override
    public OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws Exception {
        Zaposleni zaposleni = null;
        Mesto mesto = null;
        
        if (rs.next()) {
            int zaposleniID = rs.getInt("ZaposleniID");
            String imePrezime = rs.getString("ImePrezime");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            boolean menadzer = rs.getBoolean("Menadzer");

            int postanskiBroj = rs.getInt("PostanskiBroj");
            String grad = rs.getString("Grad");
            String drzava = rs.getString("Drzava");

            mesto = new Mesto(postanskiBroj, grad, drzava);
            zaposleni = new Zaposleni(zaposleniID, imePrezime, username, password, menadzer, mesto);
        }
        return zaposleni;
    }

    //Upit kojim se zaposleni prijavljuje na sistem
    public String vratiSELECTupit() {
        return "SELECT z.*, m.PostanskiBroj, m.Grad, m.Drzava "
                + "FROM zaposleni z JOIN mesto m ON (z.MestoID = m.PostanskiBroj) "
                + "WHERE z.Username = '" + this.username + "' AND z.Password = '" + this.password + "'";
    }

    public String vratiINSERTupit() {
        return "INSERT INTO zaposleni (ImePrezime, Username, Password, Menadzer, MestoID) "
                + "VALUES " + vratiVrednostiZaInsert();
    }

    public String vratiDELETEupit() {
        return "DELETE FROM zaposleni WHERE Username='" + this.username + "'";
    }
    
    //SELECT (ovo ispod)
    @Override
    public String dajSelectJedan() {
        return "SELECT z.*, m.PostanskiBroj AS PostanskiBroj, m.Grad AS Grad, m.Drzava AS Drzava";
    }
    //FROM (ovo ispod)
    @Override
    public String dajFromJedan() {
        return "FROM zaposleni z JOIN mesto m ON (z.MestoID = m.PostanskiBroj)";
    }
    //WHERE (ovo ispod)
    @Override
    public String dajWhereJedan() {
        return "WHERE z.Username = '" + this.username
                + "' AND z.Password = '" + this.password + "'";
    }
    


    //WHERE (ovo ispod)
    @Override
    public String dajWhereSvi() {
        return "WHERE Menadzer = 0";
    }

    @Override
    public String dajSelectSvi() {
        return "SELECT *";
    }

    @Override
    public String dajFromSvi() {
        return "FROM zaposleni";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = new ArrayList<>();
        
        while (rs.next()) {
            int zaposleniID = rs.getInt("ZaposleniID");
            String imePrezime = rs.getString("ImePrezime");
            String username = rs.getString("Username");
            String password = rs.getString("Password");
            boolean menadzer = rs.getBoolean("Menadzer");

            listaOdo.add(new Zaposleni(zaposleniID, imePrezime, username, password, menadzer, null));
        }
        return listaOdo;
    }

    @Override
    public boolean jesteAutoIncrement() {
        return true;
    }

    @Override
    public String vratiParametreDelete() {
        return "DELETE FROM zaposleni";
    }

    @Override
    public String vratiVrednostiDelete() {
        return "WHERE Username = '" + username +"' AND Password = '" + password + "'";
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
    

}
