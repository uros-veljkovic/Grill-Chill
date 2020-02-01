/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import baza.konekcija.FabrikaKonekcija;
import domen.Racun;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        try {
            racun = skladisteRacuna.kreirajNoviRacun(racun);
            FabrikaKonekcija.getInstance().getKonekcija().commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                FabrikaKonekcija.getInstance().getKonekcija().rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }
        return racun;
    }

    @Override
    public boolean izmeniRacun(Racun racun) throws SQLException {
        boolean uspesnoIzmenjenRacun = skladisteRacuna.izmeniRacun(racun);
        boolean uspesnoObrisaniRedovi = false;
        boolean uspesnoDodatiRedovi = false;
        
        if (uspesnoIzmenjenRacun) {
            uspesnoObrisaniRedovi = skladisteRacuna.obrisiStavke(racun);
            uspesnoDodatiRedovi = skladisteRacuna.dodajStavke(racun);
            if (uspesnoDodatiRedovi && uspesnoObrisaniRedovi) {
                FabrikaKonekcija.getInstance().commit();
                return true;
            } else {
                FabrikaKonekcija.getInstance().rollback();
                return false;
            }
        } else {
            FabrikaKonekcija.getInstance().rollback();
            return false;
        }
    }

    @Override
    public Racun obradiRacun(Racun racun) {
        return skladisteRacuna.obradiRacun(racun);
    }

    @Override
    public List<Racun> pretraziRacune(Zaposleni zaposleni) throws SQLException {
        return skladisteRacuna.pretraziRacune(zaposleni);
    }

    @Override
    public boolean stornirajRacun(Racun racun) {
        try {
            boolean uspesno = skladisteRacuna.stornirajRacun(racun);
            FabrikaKonekcija.getInstance().commit();
            return uspesno;
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                FabrikaKonekcija.getInstance().rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(ServisRacunImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

}
