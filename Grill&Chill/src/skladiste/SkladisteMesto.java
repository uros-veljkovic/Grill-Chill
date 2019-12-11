/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.Mesto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author urosv
 */
public interface SkladisteMesto {
    
    List<Mesto> vratiMesta() throws SQLException;
    
}
