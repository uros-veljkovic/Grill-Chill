/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Racun;
import domen.StatusStavke;
import domen.StavkaRacuna;
import java.util.ArrayList;

/**
 *
 * @author urosv
 */
public class SOIzmeniRacun extends OpstaSO {

    public SOIzmeniRacun(Racun racun) {
        super();
        odo = racun;
    }

    @Override
    protected void proveriPreduslov() {

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        odo = db.izmeni(odo);

        Racun racun = (Racun) odo;
        for (StavkaRacuna stavka : racun.getStavke()) {
            switch (stavka.getStatus()) {
                case NOVA:
                    db.kreiraj(stavka);
                    break;
                case IZMENJENA:
                    db.izmeni(stavka);
                    break;
                case OBRISANA:
                    db.obrisi(stavka);
                    break;
                default:
                    continue;
            }
        }
    }

}
