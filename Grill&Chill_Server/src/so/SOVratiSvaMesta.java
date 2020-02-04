/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;

/**
 *
 * @author urosv
 */
public class SOVratiSvaMesta extends OpstaSO {

    ArrayList<Mesto> listaMesta;

    public SOVratiSvaMesta(Mesto mesto) {
        super();
        odo = mesto;
        listaMesta = new ArrayList<>();
    }

    @Override
    protected void proveriPreduslov() {
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        ArrayList<OpstiDomenskiObjekat> listaOdo = db.pronadjiSve(odo);
        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaOdo) {
            listaMesta.add((Mesto) opstiDomenskiObjekat);
        }
    }

    public ArrayList<Mesto> getListaMesta() {
        return listaMesta;
    }
    
    

}
