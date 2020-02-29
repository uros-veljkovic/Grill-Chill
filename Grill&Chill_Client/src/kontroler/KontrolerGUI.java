/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Mesto;
import domen.Proizvod;
import domen.Racun;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import komunikacija.Komunikator;
import konstante.Operacija;
import konstante.Status;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author urosv
 */
public class KontrolerGUI {

    private static KontrolerGUI instanca;
    private Zaposleni ulogovaniZaposleni;

    private KontrolerGUI() {

    }

    public static KontrolerGUI getInstanca() {
        if (instanca == null) {
            instanca = new KontrolerGUI();
        }
        return instanca;
    }

    //Metode vezane za klasu Zaposleni
    public Zaposleni prijaviZaposlenog(String username, String password) throws SQLException, Exception {
        Zaposleni zaposleni = new Zaposleni();
        zaposleni.setUsername(username);
        zaposleni.setPassword(password);

        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.PRIJAVI_ZAPOSLENOG, zaposleni);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        }

        zaposleni = (Zaposleni) odgovor.getObject();
        ulogovaniZaposleni = zaposleni;

        return zaposleni;

    }

    public boolean obrisiZaposlenog(Zaposleni zaposleni) throws SQLException, Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.OBRISI_ZAPOSLENOG, zaposleni);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        zaposleni = (Zaposleni) odgovor.getObject();
        if (zaposleni == null) {
            throw new Exception(odgovor.getPoruka());
        }

        return true;
    }

    public ArrayList<Zaposleni> vratiSveZaposlene() throws SQLException, Exception {
        ArrayList<Zaposleni> listaZaposlenih = new ArrayList<>();
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.DAJ_SVE_ZAPOSLENE, new Zaposleni());

        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        }

        listaZaposlenih = (ArrayList<Zaposleni>) odgovor.getObject();

        return listaZaposlenih;
    }

    public ArrayList<Mesto> vratiSvaMesta() throws SQLException, Exception {
        ArrayList<Mesto> listaMesta = new ArrayList<>();
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.DAJ_SVA_MESTA, new Mesto());

        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        }

        listaMesta = (ArrayList<Mesto>) odgovor.getObject();

        return listaMesta;
    }

    public Zaposleni kreirajZaposlenog(Zaposleni zaposleni) throws SQLException, Exception {

        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.KREIRAJ_ZAPOSLENOG, zaposleni);

        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        }

        return (Zaposleni) odgovor.getObject();

    }

    public Zaposleni getUlogovaniZaposleni() {
        return ulogovaniZaposleni;
    }

    //Metode vezane za klasu Proizvod
    public ArrayList<Proizvod> pretraziProizvode(String nazivProizvoda) throws Exception {

        Proizvod proizvod = new Proizvod();
        proizvod.setNaziv(nazivProizvoda);

        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.PRETRAZI_PROIZVODE, proizvod);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        }

        return (ArrayList<Proizvod>) odgovor.getObject();

    }

    public boolean izmeniProizvod(Proizvod proizvod) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.IZMENI_PROIZVOD, proizvod);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.USPESNO) {
            return true;
        } else {
            throw new Exception(odgovor.getPoruka());
        }
    }

    public Proizvod kreirajNoviProizvod(Proizvod proizvod) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.KREIRAJ_PROIZVOD, proizvod);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.USPESNO) {
            return (Proizvod) odgovor.getObject();
        } else {
            throw new Exception(odgovor.getPoruka());
        }
    }

    public boolean obrisiProizvod(Proizvod odabraniProizvod) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.OBRISI_PROIZVOD, odabraniProizvod);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.USPESNO) {
            return true;
        }else{
            throw new Exception(odgovor.getPoruka());
        }
    }

    public ArrayList<Proizvod> vratiSveProizvode() throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.DAJ_SVE_PROIZVODE, new Proizvod());
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        } else {
            return (ArrayList<Proizvod>) odgovor.getObject();
        }

    }

    //Metode vezane za klasu Racun
    public Racun kreirajRacun(Racun racun) throws Exception {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.KREIRAJ_RACUN, racun);
        Komunikator.getInstance().posaljiZahtev(zahtev);

        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if (odgovor.getStatus() == Status.NEUSPESNO) {
            throw new Exception(odgovor.getPoruka());
        } else {
            return (Racun) odgovor.getObject();
        }
    }

    public boolean stornirajRacun(Racun racun) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.STORNIRAJ_RACUN, racun);
        Komunikator.getInstance().posaljiZahtev(zahtev);
        
        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        return (odgovor.getStatus() == Status.USPESNO);
            
    }

    public ArrayList<Racun> pretraziRacune(Racun racun) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.PRETRAZI_RACUNE, racun);
        Komunikator.getInstance().posaljiZahtev(zahtev);
        
        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if(odgovor.getStatus() == Status.USPESNO)
            return (ArrayList<Racun>) odgovor.getObject();
        else
            return null;
    }

    public boolean izmeniRacun(Racun racun) {
        KlijentskiZahtev zahtev = new KlijentskiZahtev(Operacija.IZMENI_RACUN, racun);
        Komunikator.getInstance().posaljiZahtev(zahtev);
        
        ServerskiOdgovor odgovor = Komunikator.getInstance().primiOdgovor();
        if(odgovor.getStatus() == Status.USPESNO)
            return true;
        else
            return false;
    }

}
