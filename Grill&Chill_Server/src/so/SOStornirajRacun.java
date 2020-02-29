/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Racun;

/**
 *
 * @author urosv
 */
public class SOStornirajRacun extends OpstaSO{

    public SOStornirajRacun(Racun racun) {
        super();
        odo = racun;
    }

    
    
    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        odo = db.obrisi(odo);
    }
    
}
