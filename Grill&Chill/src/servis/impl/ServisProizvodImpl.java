/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import baza.konekcija.FabrikaKonekcija;
import domen.Proizvod;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servis.ServisProizvod;
import skladiste.SkladisteProizvod;
import skladiste.impl.SkladisteProizvodImpl;

/**
 *
 * @author urosv
 */
public class ServisProizvodImpl implements ServisProizvod {

    private final SkladisteProizvod skladisteProizvoda;
    private Connection konekcija;

    public ServisProizvodImpl() {
        skladisteProizvoda = new SkladisteProizvodImpl();
    }

    @Override
    public boolean kreirajNoviProizvod(Proizvod proizvod) {
        try {
            boolean bezGreske = skladisteProizvoda.kreirajNoviProizvod(proizvod);
            if (bezGreske) {
                FabrikaKonekcija.getInstance().commit();
                return true;
            } else 
                FabrikaKonekcija.getInstance().rollback();
        } catch (SQLException ex) {
            try {
                FabrikaKonekcija.getInstance().rollback();
                return false;
            } catch (SQLException ex1) {
                Logger.getLogger(ServisProizvodImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(ServisProizvodImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public Proizvod zapamtiProizvod(Proizvod proizvod) {
        return skladisteProizvoda.zapamtiProizvod(proizvod);
    }

    @Override
    public boolean obrisiProizvod(Proizvod proizvod) {
        boolean obrisan = skladisteProizvoda.obrisiProizvod(proizvod);
        if(obrisan){
            try {
                FabrikaKonekcija.getInstance().commit();
                return obrisan;
            } catch (SQLException ex) {
                Logger.getLogger(ServisProizvodImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                FabrikaKonekcija.getInstance().rollback();
                return obrisan;
            } catch (SQLException ex) {
                Logger.getLogger(ServisProizvodImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return obrisan;
    }

    @Override
    public List<Proizvod> pretraziProizvode(String kriterijum) {
        return skladisteProizvoda.pretraziProizvode(kriterijum);

    }

}
