/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.Racun;
import domen.Zaposleni;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface SkladisteRacun {

    Racun kreirajNoviRacun(Racun racun) throws SQLException;

    boolean izmeniRacun(Racun racun) throws SQLException;

    Racun obradiRacun(Racun racun);

    List<Racun> pretraziRacune(Zaposleni zaposleni) throws SQLException;

    boolean stornirajRacun(Racun racun) throws SQLException;

    boolean obrisiStavke(Racun racun);

    public boolean dodajStavke(Racun racun);

}
