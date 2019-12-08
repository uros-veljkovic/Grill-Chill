/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import baza.konekcija.FabrikaKonekcija;
import servis.ServisProizvod;
import servis.ServisRacun;
import servis.ServisZaposleni;
import servis.impl.ServisProizvodImpl;
import servis.impl.ServisRacunImpl;
import servis.impl.ServisZaposleniImpl;

/**
 *
 * @author urosv
 */
public class KontrolerLogike {
    
    private static KontrolerLogike instanca;
    private final ServisProizvod servisProizvod;
    private final ServisRacun servisRacun;
    private final ServisZaposleni servisZaposleni;

    private KontrolerLogike(){
        servisRacun = new ServisRacunImpl();
        servisProizvod = new ServisProizvodImpl();
        servisZaposleni = new ServisZaposleniImpl();
    }
    
    public static KontrolerLogike getInstanca(){
        if(instanca == null)
            instanca = new KontrolerLogike();
        return instanca;
    }
    
}
