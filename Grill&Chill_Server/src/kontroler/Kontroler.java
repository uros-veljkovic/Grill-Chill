/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import db.DBBroker;
import domen.Mesto;
import domen.Proizvod;
import domen.Zaposleni;
import forme.FGlavnaForma;
import java.util.ArrayList;
import java.util.List;
import niti.NitKlijenta;
import so.SOIzmeniProizvod;
import so.SOKreirajZaposlenog;
import so.SOObrisiZaposlenog;
import so.SOPretraziProizvode;
import so.SOPrijaviZaposlenog;
import so.SOVratiSvaMesta;
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
}
