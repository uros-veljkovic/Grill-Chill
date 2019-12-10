/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import baza.konekcija.FabrikaKonekcija;
import domen.MernaJedinica;
import domen.Proizvod;
import domen.Zaposleni;
import java.util.ArrayList;
import servis.ServisProizvod;
import servis.ServisRacun;
import servis.ServisZaposleni;
import servis.impl.ServisProizvodImpl;
import servis.impl.ServisRacunImpl;
import servis.impl.ServisZaposleniImpl;

/**
 *
 * @author urosv
 */
public class KontrolerGUI {
    
    private static KontrolerGUI instanca;
    private Zaposleni ulogovaniZaposleni;
    private final ServisProizvod servisProizvod;
    private final ServisRacun servisRacun;
    private final ServisZaposleni servisZaposleni;

    private KontrolerGUI(){
        servisRacun = new ServisRacunImpl();
        servisProizvod = new ServisProizvodImpl();
        servisZaposleni = new ServisZaposleniImpl();
    }
    
    public static KontrolerGUI getInstanca(){
        if(instanca == null)
            instanca = new KontrolerGUI();
        return instanca;
    }

    public Zaposleni prijaviZaposlenog(String username, String password) {
        ulogovaniZaposleni = servisZaposleni.prijaviZaposlenog(username, password);
        return ulogovaniZaposleni;
    }

    public ArrayList<Proizvod> pretraziProizvode(String nazivProizvoda) {
        return (ArrayList<Proizvod>) servisProizvod.pretraziProizvode(nazivProizvoda);
    }

    public boolean kreirajNoviProizvod(Proizvod noviProizvod) {
        return servisProizvod.kreirajNoviProizvod(noviProizvod);
    }

    public Zaposleni getUlogovaniZaposleni() {
        return ulogovaniZaposleni;
    }

}
