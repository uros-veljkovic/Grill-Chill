/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Proizvod;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface ServisProizvod {

    boolean kreirajNoviProizvod(Proizvod proizvod);

    Proizvod zapamtiProizvod(Proizvod proizvod);

    Proizvod obrisiProizvod(Proizvod proizvod);

    List<Proizvod> pretraziProizvode(String kriterijum);

}
