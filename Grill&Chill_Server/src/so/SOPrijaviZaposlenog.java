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
public class SOPrijaviZaposlenog extends OpstaSO{

    public SOPrijaviZaposlenog(Zaposleni zaposleni) {
        super();
        odo = zaposleni;
    }
    
    @Override
    protected void proveriPreduslov() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void izvrsiOperaciju() throws Exception{
        odo = db.pronadji(odo);
    }
    
}
