/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author urosv
 */
public class ServerskiOdgovor implements Serializable {
    
    private int status;
    private String poruka;
    private Object odgovor;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(int status, String poruka, Object odgovor) {
        this.status = status;
        this.poruka = poruka;
        this.odgovor = odgovor;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }
    
    
    
}
