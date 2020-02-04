/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Proizvod;

/**
 *
 * @author urosv
 */
public class SOIzmeniProizvod extends OpstaSO{

    public SOIzmeniProizvod(Proizvod proizvod) {
        super();
        odo = proizvod;
    }

    
    
    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        odo = db.izmeni(odo);
    }

}
