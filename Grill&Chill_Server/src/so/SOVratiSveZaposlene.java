/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Zaposleni;
import java.util.ArrayList;

/**
 *
 * @author urosv
 */
public class SOVratiSveZaposlene extends OpstaSO{

    ArrayList<Zaposleni> listaZaposlenih;
    
    public SOVratiSveZaposlene(Zaposleni zaposleni) {
        super();
        odo = zaposleni;
        listaZaposlenih = new ArrayList<>();
    }
    
    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = db.pronadjiSve(odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOdo) {
            listaZaposlenih.add((Zaposleni) opstiDomenskiObjekat);
        }
    }

    public ArrayList<Zaposleni> getListaZaposlenih() {
        return listaZaposlenih;
    }
    
    
    
}
