/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Zaposleni;

/**
 *
 * @author urosv
 */
public class SOObrisiZaposlenog extends OpstaSO{

    public SOObrisiZaposlenog(Zaposleni zaposleni) {
        super();
        odo = zaposleni;
    }

    
    
    @Override
    protected void proveriPreduslov() {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        odo = db.obrisi(odo);
    }
    
}
