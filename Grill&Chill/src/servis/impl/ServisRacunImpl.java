/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import domen.Racun;
import java.util.List;
import servis.ServisRacun;
import skladiste.SkladisteRacun;
import skladiste.impl.SkladisteRacunImpl;

/**
 *
 * @author urosv
 */
public class ServisRacunImpl implements ServisRacun {

    private final SkladisteRacun skladisteRacuna;

    public ServisRacunImpl() {
        this.skladisteRacuna = new SkladisteRacunImpl();
    }

    @Override
    public Racun kreirajNoviRacun(Racun racun) {
        return skladisteRacuna.kreirajNoviRacun(racun);
    }

    @Override
    public Racun zapamtiRacun(Racun racun) {
        return skladisteRacuna.zapamtiRacun(racun);
    }

    @Override
    public Racun obradiRacun(Racun racun) {
        return skladisteRacuna.obradiRacun(racun);
    }

    @Override
    public Racun pretraziRacune(String kriterijum, List<Racun> racuni) {
        return skladisteRacuna.pretraziRacune(kriterijum, racuni);
    }

    @Override
    public Racun stornirajRacun(Racun racun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
