/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import domen.Zaposleni;
import java.util.List;
import servis.ServisZaposleni;
import skladiste.SkladisteZaposleni;
import skladiste.impl.SkladisteZaposleniImpl;

/**
 *
 * @author urosv
 */
public class ServisZaposleniImpl implements ServisZaposleni{

    private final SkladisteZaposleni skladisteZaposlenih;

    public ServisZaposleniImpl() {
        this.skladisteZaposlenih = new SkladisteZaposleniImpl();
    }
    
    @Override
    public Zaposleni prijaviZaposlenog(String username, String password) {
        return skladisteZaposlenih.prijaviZaposlenog(username, password);
    }

    @Override
    public Zaposleni kreirajZaposlenog(Zaposleni zaposleni) {
        return skladisteZaposlenih.kreirajZaposlenog(zaposleni);
    }

    @Override
    public Zaposleni zapamtiZaposlenog(Zaposleni zaposleni) {
        return skladisteZaposlenih.zapamtiZaposlenog(zaposleni);
    }

    @Override
    public void obrisiZaposlenog(Zaposleni zaposleni) {
        skladisteZaposlenih.obrisiZaposlenog(zaposleni);;
    }

    @Override
    public Zaposleni pretraziZaposlene(String kriterijum, List<Zaposleni> zaposleni) {
        return skladisteZaposlenih.pretraziZaposlene(kriterijum, zaposleni);
    }
    
}
