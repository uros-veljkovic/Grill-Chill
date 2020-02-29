/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.StavkaRacuna;
import java.util.ArrayList;

/**
 *
 * @author urosv
 */
public class SOPretraziStavkeRacuna extends OpstaSO{

    ArrayList<StavkaRacuna> listaStavki;
    Racun racun;
    
    public SOPretraziStavkeRacuna(Racun racun) {
        super();
        odo = racun;
        this.racun = racun;
        listaStavki = new ArrayList<>();
    }
    
    @Override
    protected void proveriPreduslov() {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        StavkaRacuna stavkaRacuna = new StavkaRacuna();
        stavkaRacuna.setRacunID(racun.getRacunID());
        ArrayList<OpstiDomenskiObjekat> listaOdo = db.pronadjiNeke(stavkaRacuna);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOdo) {
            listaStavki.add((StavkaRacuna) opstiDomenskiObjekat);
        }
    }

    public ArrayList<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }
}
