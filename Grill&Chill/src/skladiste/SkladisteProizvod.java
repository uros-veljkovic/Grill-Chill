/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.Proizvod;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface SkladisteProizvod {
    
    boolean kreirajNoviProizvod(Proizvod proizvod) throws SQLException;

    Proizvod zapamtiProizvod(Proizvod proizvod);

    boolean obrisiProizvod(Proizvod proizvod);

    List<Proizvod> pretraziProizvode(String kriterijum);


}
