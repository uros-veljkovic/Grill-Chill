/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis.impl;

import domen.Mesto;
import java.sql.SQLException;
import java.util.List;
import servis.ServisMesto;
import skladiste.impl.SkladisteMestoImpl;
import skladiste.SkladisteMesto;

/**
 *
 * @author urosv
 */
public class ServisMestoImpl implements ServisMesto{
    
    SkladisteMesto skladisteMesta;

    public ServisMestoImpl() {
        skladisteMesta = new SkladisteMestoImpl();
    }

    @Override
    public List<Mesto> vratiMesta() throws SQLException{
        return skladisteMesta.vratiMesta();
    }

    
}
