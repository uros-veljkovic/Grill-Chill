/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import baza.konekcija.FabrikaKonekcija;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servis.ServisZaposleni;
import skladiste.SkladisteZaposleni;
import skladiste.impl.SkladisteZaposleniImpl;

/**
 *
 * @author urosv
 */
public class ServisZaposleniImpl implements ServisZaposleni {

    private final SkladisteZaposleni skladisteZaposlenih;

    public ServisZaposleniImpl() {
        this.skladisteZaposlenih = new SkladisteZaposleniImpl();
    }

    //TODO: ZA SVAKU METODU NAPRAVITI DA PRVO PRIHVATA EXCEPTION, TU ODREDIMO DA LI CEMO COMMIT ILI ROLLBACK
    //PA ONDA OPET U CATCHU BACIMO EXCEPTION AKO JE USAO DA BISMO GA PROSLEDILI DO FORME
    //PO UZORU NA METODU kreirajZaposlenog
    @Override
    public Zaposleni prijaviZaposlenog(String username, String password) throws SQLException {
        return skladisteZaposlenih.prijaviZaposlenog(username, password);
    }

    @Override
    public Zaposleni kreirajZaposlenog(Zaposleni zaposleni) throws SQLException {
        Zaposleni z;
        try {
            z = skladisteZaposlenih.kreirajZaposlenog(zaposleni);
            FabrikaKonekcija.getInstance().getKonekcija().commit();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return z;

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

    @Override
    public ArrayList<Zaposleni> vratiZaposlene() throws SQLException {
        return skladisteZaposlenih.vratiZaposleneZaBrisanje();
    }

}
