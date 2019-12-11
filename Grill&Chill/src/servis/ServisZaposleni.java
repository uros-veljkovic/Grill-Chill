/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Zaposleni;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface ServisZaposleni {

    Zaposleni prijaviZaposlenog(String username, String password) throws SQLException;

    Zaposleni kreirajZaposlenog(Zaposleni zaposleni) throws SQLException;

    Zaposleni zapamtiZaposlenog(Zaposleni zaposleni);

    void obrisiZaposlenog(Zaposleni zaposleni);

    Zaposleni pretraziZaposlene(String kriterijum, List<Zaposleni> zaposleni);

    public ArrayList<Zaposleni> vratiZaposlene() throws SQLException;

}
