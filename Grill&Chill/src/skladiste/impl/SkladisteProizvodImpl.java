/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.impl;

import baza.konekcija.FabrikaKonekcija;
import domen.MernaJedinica;
import domen.Proizvod;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import skladiste.SkladisteProizvod;

/**
 *
 * @author urosv
 */
public class SkladisteProizvodImpl implements SkladisteProizvod {

    @Override
    public boolean kreirajNoviProizvod(Proizvod proizvod) throws SQLException{
        int rezultat = 0;
        try {
            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            
            String upit = "INSERT INTO proizvod (ProizvodID, Naziv, Opis, Cena, MernaJedinica) VALUES (?,?,?,?,?)";
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setInt(1, proizvod.getProizvodID());
            ps.setString(2, proizvod.getNaziv());
            ps.setString(3, proizvod.getOpis());
            ps.setDouble(4, proizvod.getCena());
            ps.setString(5, proizvod.getMernaJedinica().toString());
            
            rezultat = ps.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
        return rezultat == 1;
    }

    @Override
    public Proizvod zapamtiProizvod(Proizvod proizvod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean obrisiProizvod(Proizvod proizvod) {
        try {
            String upit = "DELETE FROM proizvod WHERE ProizvodID = ?";
            
            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            PreparedStatement ps = konekcija.prepareStatement(upit);
            ps.setInt(1, proizvod.getProizvodID());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Proizvod> pretraziProizvode(String kriterijum) {
        ArrayList<Proizvod> pronadjeniProizvodi = new ArrayList<>();
        try {
            
            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            
            String upit = "SELECT * FROM proizvod WHERE Naziv='" + kriterijum + "'";
            Statement stat = konekcija.createStatement();
            ResultSet rs = stat.executeQuery(upit);
            
            while(rs.next()){
                pronadjeniProizvodi.add(new Proizvod(rs.getInt("ProizvodID"),
                                                    rs.getString("Naziv"),
                                                    rs.getString("Opis"),
                                                    rs.getDouble("Cena"),
                                                    MernaJedinica.valueOf(rs.getString("MernaJedinica"))));
                
            }
            for (Proizvod proizvod : pronadjeniProizvodi) {
                System.out.println(proizvod);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SkladisteProizvodImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return pronadjeniProizvodi;
    }

}
