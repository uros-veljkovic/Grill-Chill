/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Racun;
import java.util.ArrayList;

/**
 *
 * @author urosv
 */
public class SOPretraziRacune extends OpstaSO{
    
    ArrayList<Racun> listaRacuna;

    public SOPretraziRacune(Racun racun) {
        super();
        odo = racun;
        listaRacuna = new ArrayList<Racun>();
    }

    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = db.pronadjiNeke(odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOdo) {
            listaRacuna.add((Racun) opstiDomenskiObjekat);
        }
    }

    public ArrayList<Racun> getListaRacuna() {
        return listaRacuna;
    }
    
    
    
    
}
