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
public class StavkaRacuna implements OpstiDomenskiObjekat {

    private int racunID;
    private int stavkaID;
    private int kolicina;
    //TODO: izmeniti naziv atributa prodajnaCena u ukupanIznos
    private double ukupanIznos;
    private Proizvod proizvod;
    private StatusStavke status;

    public StavkaRacuna() {
    }

    public StavkaRacuna(int racunID, int stavkaID, int kolicina, Proizvod proizvod) {
        this.racunID = racunID;
        this.stavkaID = stavkaID;
        this.kolicina = kolicina;
        this.ukupanIznos = kolicina * proizvod.getCena();
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

    public StatusStavke getStatus() {
        return status;
    }

    public void setStatus(StatusStavke status) {
        this.status = status;
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
        return "INSERT INTO stavkaRacuna (StavkaID, RacunID, Kolicina, Proizvod, UkupanIznos, StatusStavke)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("
                + this.getStavkaID() + ","
                + this.getRacunID() + ","
                + this.getKolicina() + ","
                + this.getProizvod().getProizvodID() + ","
                + this.getUkupanIznos() + ","
                + "'" + this.getStatus() + "'"
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
    public void postaviObjektaID(int id) {
        this.racunID = id;
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
        return "WHERE RacunID = " + racunID;
    }

    @Override
    public String dajSelectSvi() {
        return "SELECT *";
    }

    @Override
    public String dajFromSvi() {
        return "FROM stavkaRacuna";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaStavkaRacuna = new ArrayList<>();

        while (rs.next()) {
            int stavkaID = rs.getInt("StavkaID");
            int racunID = rs.getInt("RacunID");
            int kolicina = rs.getInt("Kolicina");
            int proizvodID = rs.getInt("Proizvod");

            StavkaRacuna stavkaRacuna = new StavkaRacuna(racunID, stavkaID, kolicina,
                    new Proizvod(proizvodID, null, null, 0.0, null));

            listaStavkaRacuna.add(stavkaRacuna);
        }
        return listaStavkaRacuna;
    }

    @Override
    public boolean jesteAutoIncrement() {
        return false;
    }

    @Override
    public String vratiParametreDelete() {
        return "DELETE FROM stavkaracuna";
    }

    @Override
    public String vratiVrednostiDelete() {
        return "WHERE RacunID = " + racunID + " AND StavkaID = " + stavkaID;
    }

    @Override
    public String dajUpdate() {
        return "UPDATE stavkaracuna";
    }

    @Override
    public String dajSet() {
        return "SET "
                + "StavkaID = " + stavkaID + ","
                + "Kolicina = " + kolicina + ","
                + "UkupanIznos = " + ukupanIznos + ","
                + "StatusStavke = " + "'" + status + "'";
    }

    @Override
    public String dajUslovZaUpdate() {
        return "WHERE Proizvod = " + proizvod.getProizvodID() + " AND RacunID = " + racunID;
    }

    @Override
    public String vratiMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajSelectMax() {
        return "SELECT MAX(StavkaID) AS MAX";
    }

    @Override
    public String dajFromMax() {
        return "FROM stavkaRacuna";
    }

    @Override
    public String dajWhereMax() {
        return "WHERE RacunID = " + racunID;
    }

}
