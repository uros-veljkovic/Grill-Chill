/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.Zaposleni;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface SkladisteZaposleni {

    Zaposleni prijaviZaposlenog(String username, String password);

    Zaposleni kreirajZaposlenog(Zaposleni zaposleni);

    Zaposleni zapamtiZaposlenog(Zaposleni zaposleni);

    void obrisiZaposlenog(Zaposleni zaposleni);

    Zaposleni pretraziZaposlene(String kriterijum, List<Zaposleni> zaposleni);

}
