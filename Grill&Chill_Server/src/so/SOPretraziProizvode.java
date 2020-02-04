/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Proizvod;
import java.util.ArrayList;

/**
 *
 * @author urosv
 */
public class SOPretraziProizvode extends OpstaSO {

    ArrayList<Proizvod> listaProizvoda;

    public SOPretraziProizvode(Proizvod proizvod) {
        super();
        odo = proizvod;
        listaProizvoda = new ArrayList<>();
    }

    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = db.pronadjiNeke(odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOdo) {
            listaProizvoda.add((Proizvod) opstiDomenskiObjekat);
        }
    }

    public ArrayList<Proizvod> getListaProizvoda() {
        return listaProizvoda;
    }

}
