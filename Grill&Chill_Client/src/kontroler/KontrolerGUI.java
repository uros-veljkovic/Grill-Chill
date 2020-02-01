/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import baza.konekcija.FabrikaKonekcija;
import domen.MernaJedinica;
import domen.Mesto;
import domen.Proizvod;
import domen.Racun;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servis.ServisMesto;
import servis.ServisProizvod;
import servis.ServisRacun;
import servis.ServisZaposleni;
import servis.impl.ServisMestoImpl;
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
    private final ServisMesto servisMesto;

    private KontrolerGUI(){
        servisRacun = new ServisRacunImpl();
        servisProizvod = new ServisProizvodImpl();
        servisZaposleni = new ServisZaposleniImpl();
        servisMesto = new ServisMestoImpl();
    }
    
    public static KontrolerGUI getInstanca(){
        if(instanca == null)
            instanca = new KontrolerGUI();
        return instanca;
    }

    public Zaposleni prijaviZaposlenog(String username, String password) throws SQLException {
        ulogovaniZaposleni = servisZaposleni.prijaviZaposlenog(username, password);
        return ulogovaniZaposleni;
    }
    
    public boolean obrisiZaposlenog(Zaposleni zaposleni) throws SQLException{
        return servisZaposleni.obrisiZaposlenog(zaposleni);
    }

    public ArrayList<Proizvod> pretraziProizvode(String nazivProizvoda) throws SQLException{
        return (ArrayList<Proizvod>) servisProizvod.pretraziProizvode(nazivProizvoda);
    }

    public boolean kreirajNoviProizvod(Proizvod proizvod) throws SQLException{
        return servisProizvod.kreirajNoviProizvod(proizvod);
    }

    public Zaposleni getUlogovaniZaposleni() {
        return ulogovaniZaposleni;
    }

    public ArrayList<Zaposleni> vratiSveZaposlene() throws SQLException{
        return servisZaposleni.vratiZaposlene();
    }

    public List<Mesto> vratiSvaMesta() throws SQLException{
        return servisMesto.vratiMesta();
    }

    public Zaposleni kreirajNovogZaposlenog(Zaposleni zaposleni) throws SQLException {
        return servisZaposleni.kreirajZaposlenog(zaposleni);
    }

    public boolean obrisiProizvod(Proizvod odabraniProizvod) {
        return servisProizvod.obrisiProizvod(odabraniProizvod);
    }

    public boolean izmeniProizvod(Proizvod proizvod) {
        return servisProizvod.zapamtiProizvod(proizvod);
    }

    public ArrayList<Proizvod> vratiSveProizvode() {
        return servisProizvod.vratiProizvode();
    }

    public Racun sacuvajRacun(Racun racun) {
        return servisRacun.kreirajNoviRacun(racun);
    }

    public ArrayList<Racun> pretraziRacune(Zaposleni zaposleni) {
        ArrayList<Racun> listaRacuna = new ArrayList<>();
        try {
            listaRacuna = (ArrayList<Racun>)(servisRacun.pretraziRacune(zaposleni));
        } catch (SQLException ex) {
            Logger.getLogger(KontrolerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return listaRacuna;
        }
    }

    public boolean stornirajRacun(Racun racun) {
        return servisRacun.stornirajRacun(racun);
    }

    public boolean izmeniRacun(Racun racun) {
        try {
            servisRacun.izmeniRacun(racun);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

}
