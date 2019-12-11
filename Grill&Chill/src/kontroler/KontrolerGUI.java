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
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

}
