/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    String vratiNazivTabele();
    String vratiAtributeZaInsert();
    String vratiVrednostiZaInsert();
    String vratiParametreDelete();
    String vratiVrednostiDelete();
    String vratiUslovZaNadjiSlog();
    String vratiID();
    
    String dajSelectJedan();
    String dajFromJedan();
    String dajWhereJedan();
    
    String dajSelectSvi();
    String dajFromSvi();
    String dajWhereSvi(); //Koristimo kada filtriramo, ako ne koristimo, vracamo sve objekte
    
    String dajUpdate();
    String dajSet();
    String dajUslovZaUpdate();
    
    void postaviObjektaID(int id);
    boolean jesteAutoIncrement();
    OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws Exception;
    List<OpstiDomenskiObjekat> ucitajSve(ResultSet rs) throws Exception;
    
}
