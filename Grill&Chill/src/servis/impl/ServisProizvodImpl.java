/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import domen.Proizvod;
import java.util.List;
import servis.ServisProizvod;
import skladiste.SkladisteProizvod;
import skladiste.impl.SkladisteProizvodImpl;

/**
 *
 * @author urosv
 */
public class ServisProizvodImpl implements ServisProizvod{

    private final SkladisteProizvod skladisteProizvoda;

    public ServisProizvodImpl() {
        skladisteProizvoda = new SkladisteProizvodImpl();
    }
    
    @Override
    public Proizvod kreirajNoviProizvod(Proizvod proizvod) {
        return skladisteProizvoda.kreirajNoviProizvod(proizvod);
    }

    @Override
    public Proizvod zapamtiProizvod(Proizvod proizvod) {
        return skladisteProizvoda.zapamtiProizvod(proizvod);
    }

    @Override
    public Proizvod obrisiProizvod(Proizvod proizvod) {
        return skladisteProizvoda.obrisiProizvod(proizvod);
    }

    @Override
    public Proizvod pretraziProizvode(String kriterijum, List<Proizvod> proizvodi) {
        return skladisteProizvoda.pretraziProizvode(kriterijum, proizvodi);
    }
    
}
