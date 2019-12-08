/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.Proizvod;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface SkladisteProizvod {
    
    Proizvod kreirajNoviProizvod(Proizvod proizvod);

    Proizvod zapamtiProizvod(Proizvod proizvod);

    Proizvod obrisiProizvod(Proizvod proizvod);

    Proizvod pretraziProizvode(String kriterijum, List<Proizvod> proizvodi);


}
