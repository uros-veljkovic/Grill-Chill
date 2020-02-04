/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.impl;

import domen.Mesto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import skladiste.SkladisteMesto;

/**
 *
 * @author urosv
 */
public class SkladisteMestoImpl implements SkladisteMesto {

    @Override
    public List<Mesto> vratiMesta() throws SQLException {
        
        ArrayList<Mesto> listaMesta = new ArrayList<Mesto>();
//        String upit = "SELECT * FROM mesto";
//
//        try {
//            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
//            Statement s = konekcija.createStatement();
//            ResultSet rs = s.executeQuery(upit);
//            
//            while(rs.next()){
//                Mesto m = new  Mesto(rs.getInt("PostanskiBroj"),
//                                    rs.getString("Grad"),
//                                    rs.getString("Drzava"));
//                listaMesta.add(m);
//            }
//        } catch (SQLException ex) {
//            throw new SQLException(ex.getMessage());
//        }

        return listaMesta;
    }

}
