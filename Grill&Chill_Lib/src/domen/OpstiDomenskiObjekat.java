/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author urosv
 */
public interface OpstiDomenskiObjekat extends Serializable{
    
    String vratiNazivTabele();
    String vratiAtributeZaInsert();
    String vratiVrednostiZaInsert();
    String vratiUslovZaNadjiSlog();
    String vratiID();
    String vratiSELECTjointUpita();
    String vratiFROMjointUpita();
    String vratiWHEREjointUpita();
    
}
