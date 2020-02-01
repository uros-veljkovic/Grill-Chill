/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servis;

import domen.Mesto;
import java.sql.SQLException;
import java.util.List;
import skladiste.SkladisteMesto;

/**
 *
 * @author urosv
 */
public interface ServisMesto {
    
    List<Mesto> vratiMesta() throws SQLException;
    
}
