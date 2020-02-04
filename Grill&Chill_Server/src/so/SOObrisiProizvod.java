/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Proizvod;

/**
 *
 * @author urosv
 */
public class SOObrisiProizvod extends OpstaSO{

    public SOObrisiProizvod(Proizvod proizvod) {
        super();
        odo = proizvod;
    }
    
    @Override
    protected void proveriPreduslov() {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        odo = db.obrisi(odo);
    }
    
}
