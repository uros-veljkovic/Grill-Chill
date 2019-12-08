/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Racun;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface ServisRacun {

    Racun kreirajNoviRacun(Racun racun);

    Racun zapamtiRacun(Racun racun);

    Racun obradiRacun(Racun racun);

    Racun pretraziRacune(String kriterijum, List<Racun> racuni);

    Racun stornirajRacun(Racun racun);

}
