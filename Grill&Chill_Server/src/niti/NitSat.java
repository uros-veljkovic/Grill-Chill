/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import forme.FGlavnaForma;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author urosv
 */
public class NitSat extends Thread {

    FGlavnaForma forma;
    Date time;

    public NitSat(FGlavnaForma forma) {
        this.forma = forma;
    }

    @Override
    public void run() {
        while (true) {
            
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String vreme = sdf.format(new Date());
            
            forma.postaviVreme(vreme);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
