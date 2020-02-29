/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Racun;
import domen.StavkaRacuna;

/**
 *
 * @author urosv
 */
public class SOKreirajRacun extends OpstaSO{

    public SOKreirajRacun(Racun racun) {
        super();
        odo = racun;
    }

    

    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        odo = db.kreiraj(odo);
        
        Racun racun = (Racun) odo;
        for (StavkaRacuna stavkaRacuna : racun.getStavke()) {
            stavkaRacuna.setRacunID(racun.getRacunID());
            stavkaRacuna.setStavkaID(db.vratiMaxID(stavkaRacuna));
            db.kreiraj(stavkaRacuna);
        }
        
    }
    
}
