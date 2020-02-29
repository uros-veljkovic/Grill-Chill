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
import konstante.Status;

/**
 *
 * @author urosv
 */
public class Racun implements OpstiDomenskiObjekat {

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

    public ArrayList<StavkaRacuna> getNeobrisaneStavke() {
        ArrayList<StavkaRacuna> listaNeobrisanih = new ArrayList<>();
        for (StavkaRacuna stavkaRacuna : stavke) {
            if (stavkaRacuna.getStatus() != StatusStavke.OBRISANA) {
                listaNeobrisanih.add(stavkaRacuna);
            }
        }
        return listaNeobrisanih;
    }

    public ArrayList<StavkaRacuna> getObrisaneStavke() {
        ArrayList<StavkaRacuna> lisatObrisanih = new ArrayList<>();
        for (StavkaRacuna stavkaRacuna : stavke) {
            if (stavkaRacuna.getStatus() == StatusStavke.OBRISANA) {
                lisatObrisanih.add(stavkaRacuna);
            }
        }
        return lisatObrisanih;
    }

    public ArrayList<StavkaRacuna> getIzmenjeneStavke() {
        ArrayList<StavkaRacuna> listaIzmenjenih = new ArrayList<>();

        for (StavkaRacuna stavkaRacuna : stavke) {
            if (stavkaRacuna.getStatus() == StatusStavke.IZMENJENA || stavkaRacuna.getStatus() == StatusStavke.OBRISANA) {
                listaIzmenjenih.add(stavkaRacuna);
            }
        }
        return listaIzmenjenih;
    }

    public ArrayList<StavkaRacuna> getNoveStavke() {
        ArrayList<StavkaRacuna> listaIzmenjenih = new ArrayList<>();

        for (StavkaRacuna stavkaRacuna : stavke) {
            if (stavkaRacuna.getStatus() == StatusStavke.NOVA) {
                listaIzmenjenih.add(stavkaRacuna);
            }
        }
        return listaIzmenjenih;
    }

    public void dodajStavku(StavkaRacuna stavka) {
        stavke.add(stavka);
    }

    public void obrisiStavku(StavkaRacuna stavka) {
        for (StavkaRacuna stavkaRacuna : stavke) {
            if (stavkaRacuna.equals(stavka)) {
                stavkaRacuna.setStatus(StatusStavke.OBRISANA);
                break;
            }
        }
        ucitajUkupanIznos();
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
        return "INSERT INTO racun (UkupanIznos, Obradjen, Storniran, KreiraoZaposleni, DatumIzrade)";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        java.sql.Date date = new java.sql.Date(datumIzrade.getTime());
        return "("
                + this.getUkupanIznos() + ","
                + this.isObradjen() + ","
                + this.isStorniran() + ","
                + this.getKreiraoZaposleni().getZaposleniID() + ","
                + "'" + date + "'" + ")";
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
        String neStorniran = "";
        if (kreiraoZaposleni == null) {
            return "WHERE Storniran = 0";
        }
        return "WHERE KreiraoZaposleni = " + kreiraoZaposleni.getZaposleniID() + " AND Storniran = 0";
    }

    @Override
    public String dajSelectSvi() {
        return "SELECT r.*, sr.StavkaID, sr.Kolicina, sr.Proizvod, sr.UkupanIznos, sr.StatusStavke, p.Naziv, p.Opis, p.Cena, p.MernaJedinica";

    }

    @Override
    public String dajFromSvi() {
        return "FROM racun r JOIN stavkaracuna sr ON (r.RacunID = sr.RacunID) JOIN proizvod p ON (sr.Proizvod = p.ProizvodID)";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = new ArrayList<>();

        boolean prosaoPrviRed = false;
        int spori = -1;

        if (rs.isBeforeFirst()) {                 //VRACA FALSE AKO NE POSTOJI NI JEDAN RED U REZULTUJUCOJ TABELI
            Racun racun = new Racun();

            while (rs.next()) {
                if (!prosaoPrviRed) {             //AKO NIJE PROSAO PRVI RED NOVOG RACUNA
                    spori = rs.getInt("RacunID");//POSTAVI POKAZATELJ NA PRVU STAVKU (samo prvi put se izvrsava)
                    prosaoPrviRed = true;       //I POSLE NE DIRAJ, JER SI USPEO DA POSTAVIS SPOROG NA POCETAK TABELE
                }
                int brzi = rs.getInt("RacunID");
                if (spori != brzi) {
                    spori = brzi;
                    listaOdo.add(racun);
                    racun = new Racun();
                }

                racun.setRacunID(rs.getInt("RacunID"));
                racun.setDatumIzrade(rs.getDate("DatumIzrade"));
                racun.setUkupanIznos(rs.getDouble("UkupanIznos"));
                racun.setObradjen(rs.getBoolean("Obradjen"));
                racun.setStorniran(rs.getBoolean("Storniran"));
                racun.setKreiraoZaposleni(new Zaposleni(rs.getInt("KreiraoZaposleni"), null, null, null, false, null));

                Proizvod proizvod = new Proizvod();
                proizvod.setProizvodID(rs.getInt("Proizvod"));
                proizvod.setCena(rs.getDouble("Cena"));
                proizvod.setNaziv(rs.getString("Naziv"));
                proizvod.setOpis(rs.getString("Opis"));
                proizvod.setMernaJedinica(MernaJedinica.valueOf(rs.getString("MernaJedinica")));

                StavkaRacuna stavka = new StavkaRacuna();
                stavka.setRacunID(racun.getRacunID());
                stavka.setStavkaID(rs.getInt("StavkaID"));
                stavka.setProizvod(proizvod);
                stavka.setKolicina(rs.getInt("Kolicina"));
                stavka.setUkupanIznos(rs.getDouble("UkupanIznos"));
                stavka.setStatus(StatusStavke.STARA);

                racun.dodajStavku(stavka);
            }
            //Cim while petlja prodje posledju ntorku, nece se uci u if i necemo moci da dodamo racun u listaOdo, zbog toga
            listaOdo.add(racun);
            return listaOdo;

        }else{
            return null;
        }
    }

    public boolean ucitajStavkeRacuna(ResultSet rs) {
        //TODO implementirati
        return true;
    }

    @Override
    public boolean jesteAutoIncrement() {
        return true;
    }

    @Override
    public String vratiParametreDelete() {
        return "UPDATE racun SET Storniran = " + storniran;
    }

    @Override
    public String vratiVrednostiDelete() {
        return "WHERE RacunID = " + racunID;
    }

    @Override
    public String dajUpdate() {
        return "UPDATE racun";
    }

    @Override
    public String dajSet() {
        java.sql.Date date = new java.sql.Date(datumIzrade.getTime());
        return "SET UkupanIznos = " + this.getUkupanIznos() + ","
                + "Obradjen = " + this.isObradjen() + ","
                + "KreiraoZaposleni = " + this.getKreiraoZaposleni().getZaposleniID() + ","
                + "DatumIzrade = " + "'" + date + "'";
    }

    @Override
    public String dajUslovZaUpdate() {
        return "WHERE RacunID = " + racunID;
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

    public void postaviStavkeNaNovo() {
        for (StavkaRacuna stavkaRacuna : stavke) {
            stavkaRacuna.setStatus(StatusStavke.NOVA);
        }
    }

    public void ucitajUkupanIznos() {
        ukupanIznos = 0;
        for (StavkaRacuna stavkaRacuna : stavke) {
            if (stavkaRacuna.getStatus() != StatusStavke.OBRISANA) {
                ukupanIznos += stavkaRacuna.getKolicina() * stavkaRacuna.getProizvod().getCena();
            }
        }
    }

    public void postaviIDSvimStavkama(int racunID) {
        for (StavkaRacuna stavkaRacuna : stavke) {
            stavkaRacuna.setRacunID(racunID);
        }
    }

}
