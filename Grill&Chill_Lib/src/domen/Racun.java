/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author urosv
 */
public class Racun implements OpstiDomenskiObjekat{
    
    private int racunID;
    private Zaposleni kreiraoZaposleni;
    private Date datumIzrade;
    private double ukupanIznos;
    private boolean obradjen;
    private boolean storniran;
    private List<StavkaRacuna> stavke;

    //TODO: Da li smem da napravim racun koji nema referenciranog Zaposlenog kroz prazan konstruktor?
    
    public Racun() {
        stavke = new ArrayList<StavkaRacuna>();
        obradjen = false;
        storniran = false;
        ukupanIznos = 0;
    }
    public Racun(int racunID, Zaposleni kreiraoZaposleni, Date datumIzrade, double ukupanIznos, boolean obradjen, boolean storniran, List<StavkaRacuna> stavke) {
        this.racunID = racunID;
        this.kreiraoZaposleni = kreiraoZaposleni;
        this.datumIzrade = datumIzrade;
        this.ukupanIznos = ukupanIznos;
        this.obradjen = obradjen;
        this.storniran = storniran;
        this.stavke = stavke;
    }
    

    public int getRacunID() {
        return racunID;
    }
    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Zaposleni getKreiraoZaposleni() {
        return kreiraoZaposleni;
    }
    public void setKreiraoZaposleni(Zaposleni kreiraoZaposleni) {
        this.kreiraoZaposleni = kreiraoZaposleni;
    }

    public Date getDatumIzrade() {
        return datumIzrade;
    }
    public void setDatumIzrade(Date datumIzrade) {
        this.datumIzrade = datumIzrade;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }
    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public boolean isObradjen() {
        return obradjen;
    }
    public void setObradjen(boolean obradjen) {
        this.obradjen = obradjen;
    }

    public boolean isStorniran() {
        return storniran;
    }
    public void setStorniran(boolean storniran) {
        this.storniran = storniran;
    }

    public List<StavkaRacuna> getStavke() {
        return stavke;
    }
    public void setStavke(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }

    //TODO: Da li je uredu sto sam poredio racune i po ID-u i po Zaposlenom ?
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
        final Racun other = (Racun) obj;
        if (!Objects.equals(this.racunID, other.racunID)) {
            return false;
        }
        if (!Objects.equals(this.kreiraoZaposleni, other.kreiraoZaposleni)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public String vratiAtributeZaInsert() {
        return "(UkupanIznos, Obradjen, Storniran, KreiraoZaposleni, DatumIzrade)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return "("
                + this.getUkupanIznos() + ","
                + this.isObradjen() + ","
                + this.isStorniran() + ","
                + this.getKreiraoZaposleni().getZaposleniID() + ","
                + this.getDatumIzrade()
                + ")";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "RacunID";
    }

    @Override
    public String vratiID() {
        return String.valueOf(this.racunID);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajSelectSvi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String dajFromSvi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
