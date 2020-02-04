/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import kontroler.Kontroler;

/**
 *
 * @author urosv
 */
public abstract class OpstaSO {

    protected DBBroker db;
    protected OpstiDomenskiObjekat odo;

    public OpstaSO() {
        db = Kontroler.getInstance().getDb();
    }
    
    public OpstiDomenskiObjekat getOpstiDomenskiObjekat(){
        return odo;
    }

    public final void izvrsenjeSO() throws Exception{
        try {
            otvoriKonekciju();
            proveriPreduslov();
            izvrsiOperaciju();
            potvrdiTransakciju();
        } catch (Exception ex) {
            ponistiTransakciju();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
    }

    private void otvoriKonekciju() {
        db.otvoriKonekciju();
    }

    protected abstract void proveriPreduslov();

    protected abstract void izvrsiOperaciju() throws Exception;

    private void potvrdiTransakciju() {
        db.commit();
    }

    private void ponistiTransakciju() {
        db.rollback();
    }

    private void zatvoriKonekciju() {
        db.zatvoriKonekciju();
    }

}
