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
public class Proizvod implements OpstiDomenskiObjekat {

    private int proizvodID;
    private String naziv;
    private String opis;
    private Double cena;
    private MernaJedinica mernaJedinica;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, String naziv, String opis, Double cena, MernaJedinica mernaJedinica) {
        this.proizvodID = proizvodID;
        this.naziv = naziv;
        this.opis = opis;
        this.cena = cena;
        this.mernaJedinica = mernaJedinica;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
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

    public MernaJedinica getMernaJedinica() {
        return mernaJedinica;
    }

    public void setMernaJedinica(MernaJedinica mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
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

    @Override
    public String vratiNazivTabele() {
        return "proizvod";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(Naziv, Opis, Cena, MernaJedinica)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("
                + "'" + this.naziv + "',"
                + "'" + this.opis + "',"
                + "'" + this.cena + "',"
                + "'" + this.mernaJedinica.toString() + "'"
                + ")";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "ProizvodID";
    }

    @Override
    public String vratiID() {
        return String.valueOf(this.proizvodID);
    }

    @Override
    public void postaviObjektaID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajSelectJedan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajFromJedan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajWhereJedan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajWhereSvi() {
        return "WHERE Naziv = '" + naziv + "'";
    }

    @Override
    public String dajSelectSvi() {
        return "SELECT *";
    }

    @Override
    public String dajFromSvi() {
        return "FROM proizvod";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = new ArrayList<>();

        while (rs.next()) {

            listaOdo.add(new Proizvod(rs.getInt("ProizvodID"),
                    rs.getString("Naziv"),
                    rs.getString("Opis"),
                    rs.getDouble("Cena"),
                    MernaJedinica.valueOf(rs.getString("MernaJedinica"))));
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
        return "UPDATE proizvod";
    }

    @Override
    public String dajSet() {
        return "SET Naziv = '" + naziv
                + "', Cena = " + cena
                + ", Opis = '" + opis
                + "', MernaJedinica = '" + mernaJedinica + "'";
    }

    @Override
    public String dajUslovZaUpdate() {
        return "WHERE ProizvodID = " + proizvodID;
    }

}
