/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *
 * @author urosv
 */
public class KontrolerLogike {
    
    private static KontrolerLogike instanca;
    
    private KontrolerLogike(){
        
    }
    
    public static KontrolerLogike getInstanca(){
        if(instanca == null)
            instanca = new KontrolerLogike();
        return instanca;
    }
    
}
