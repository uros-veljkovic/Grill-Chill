/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import db.DBBroker;
import domen.Mesto;
import domen.Proizvod;
import domen.Racun;
import domen.StavkaRacuna;
import domen.Zaposleni;
import forme.FGlavnaForma;
import java.util.ArrayList;
import java.util.List;
import niti.NitKlijenta;
import so.SOIzmeniProizvod;
import so.SOIzmeniRacun;
import so.SOKreirajProizvod;
import so.SOKreirajRacun;
import so.SOKreirajZaposlenog;
import so.SOObrisiProizvod;
import so.SOObrisiZaposlenog;
import so.SOPretraziProizvod;
import so.SOPretraziProizvode;
import so.SOPretraziRacune;
import so.SOPretraziStavkeRacuna;
import so.SOPrijaviZaposlenog;
import so.SOStornirajRacun;
import so.SOVratiSvaMesta;
import so.SOVratiSveProizvode;
import so.SOVratiSveZaposlene;

/**
 *
 * @author urosv
 */
public class Kontroler {

    private DBBroker db;
    private static Kontroler instance;
    List<NitKlijenta> listaKlijenata;
    FGlavnaForma forma;

    private Kontroler() {
        db = new DBBroker();
        db.ucitajDrajver();
        listaKlijenata = new ArrayList<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public DBBroker getDb() {
        return db;
    }

    public List<NitKlijenta> getListaKlijenata() {
        return listaKlijenata;
    }

    public void dodajKlijenta(NitKlijenta klijent) {
        listaKlijenata.add(klijent);
        forma.dodajKlijentaUTabelu(klijent);
    }

    public void izbaciKlijenta(NitKlijenta klijent) {
        listaKlijenata.remove(klijent);
    }

    public void dodajFormu(FGlavnaForma forma) {
        this.forma = forma;
    }

    public void dodajKlijentaUTabelu() {
        //TODO
    }

    public Zaposleni prijaviZaposlenog(Zaposleni zaposleni) throws Exception {
        SOPrijaviZaposlenog so = new SOPrijaviZaposlenog(zaposleni);
        so.izvrsenjeSO();
        return (Zaposleni) so.getOpstiDomenskiObjekat();
    }

    public ArrayList<Zaposleni> dajSveZaposlene(Zaposleni zaposleni) throws Exception {
        SOVratiSveZaposlene so = new SOVratiSveZaposlene(zaposleni);
        so.izvrsenjeSO();
        return so.getListaZaposlenih();
    }

    public ArrayList<Mesto> dajSvaMesta(Mesto mesto) throws Exception {
        SOVratiSvaMesta so = new SOVratiSvaMesta(mesto);
        so.izvrsenjeSO();
        return so.getListaMesta();
    }

    public Zaposleni kreirajZaposlenog(Zaposleni zaposleni) throws Exception {
        SOKreirajZaposlenog so = new SOKreirajZaposlenog(zaposleni);
        so.izvrsenjeSO();
        return (Zaposleni) so.getOpstiDomenskiObjekat();
    }

    public Zaposleni obrisiZaposlenog(Zaposleni zaposleni) throws Exception {
        SOObrisiZaposlenog so = new SOObrisiZaposlenog(zaposleni);
        so.izvrsenjeSO();
        return (Zaposleni) so.getOpstiDomenskiObjekat();
    }

    public ArrayList<Proizvod> pretraziProizvode(Proizvod proizvod) throws Exception {
        SOPretraziProizvode so = new SOPretraziProizvode(proizvod);
        so.izvrsenjeSO();
        return so.getListaProizvoda();
    }

    public Proizvod izmeniProizvod(Proizvod proizvod) throws Exception {
        SOIzmeniProizvod so = new SOIzmeniProizvod(proizvod);
        so.izvrsenjeSO();
        return (Proizvod) so.getOpstiDomenskiObjekat();
    }

    public Proizvod kreirajProizvod(Proizvod proizvod) throws Exception {
        SOKreirajProizvod so = new SOKreirajProizvod(proizvod);
        so.izvrsenjeSO();
        return (Proizvod) so.getOpstiDomenskiObjekat();
    }

    public Proizvod obrisiProizvod(Proizvod proizvod) throws Exception {
        SOObrisiProizvod so = new SOObrisiProizvod(proizvod);
        so.izvrsenjeSO();
        return (Proizvod) so.getOpstiDomenskiObjekat();
    }

    public ArrayList<Proizvod> dajSveProizvode(Proizvod proizvod) throws Exception {
        SOVratiSveProizvode so = new SOVratiSveProizvode(proizvod);
        so.izvrsenjeSO();
        return so.getListaProizvoda();
    }

    public Racun kreirajRacun(Racun racun) throws Exception {
        SOKreirajRacun so = new SOKreirajRacun(racun);
        so.izvrsenjeSO();
        return (Racun) so.getOpstiDomenskiObjekat();
    }

    public Racun stornirajRacun(Racun racun) throws Exception {
        SOStornirajRacun so = new SOStornirajRacun(racun);
        so.izvrsenjeSO();
        return (Racun) so.getOpstiDomenskiObjekat();
    }

    public ArrayList<Racun> pretraziRacune(Racun racun) throws Exception {
        SOPretraziRacune so = new SOPretraziRacune(racun);
        so.izvrsenjeSO();
        return so.getListaRacuna();
    }

    public ArrayList<StavkaRacuna> pretraziStavkeRacuna(Racun racun) throws Exception {
        SOPretraziStavkeRacuna so = new SOPretraziStavkeRacuna(racun);
        so.izvrsenjeSO();
        return so.getListaStavki();
    }

    public Proizvod pretraziProizvod(Proizvod proizvod) throws Exception {
        SOPretraziProizvod so = new SOPretraziProizvod(proizvod);
        so.izvrsenjeSO();
        return (Proizvod) so.getOpstiDomenskiObjekat();
    }

    public Racun izmeniRacun(Racun racun) throws Exception {
        SOIzmeniRacun so = new SOIzmeniRacun(racun);
        so.izvrsenjeSO();
        return (Racun) so.getOpstiDomenskiObjekat();
    }
}
