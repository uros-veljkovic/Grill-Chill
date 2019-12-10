/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.impl;

import baza.konekcija.FabrikaKonekcija;
import domen.Mesto;
import domen.Zaposleni;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import skladiste.SkladisteZaposleni;

/**
 *
 * @author urosv
 */
public class SkladisteZaposleniImpl implements SkladisteZaposleni{

    @Override
    public Zaposleni prijaviZaposlenog(String username, String password) throws SQLException{
        String upit = "SELECT * FROM zaposleni WHERE username = ? AND password = ?";
        Zaposleni ulogovaniZaposleni= null;
        Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
        
        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        ulogovaniZaposleni = new Zaposleni();
        
        while(rs.next()){
            ulogovaniZaposleni.setZaposleniID(rs.getInt("ZaposleniID"));
            ulogovaniZaposleni.setImePrezime(rs.getString("ImePrezime"));
            ulogovaniZaposleni.setMenadzer(rs.getBoolean("Menadzer"));
            //TODO: Implementirati da se mesto boravka povuce iz baze da bi se napravio ceo zaposleni
            ulogovaniZaposleni.setMestoBoravista(null);
            ulogovaniZaposleni.setPassword(rs.getString("Password"));
            ulogovaniZaposleni.setUsername(rs.getString("Username"));
        }
        
        return ulogovaniZaposleni;
        
    }

    @Override
    public Zaposleni kreirajZaposlenog(Zaposleni zaposleni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zaposleni zapamtiZaposlenog(Zaposleni zaposleni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obrisiZaposlenog(Zaposleni zaposleni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zaposleni pretraziZaposlene(String kriterijum, List<Zaposleni> zaposleni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
