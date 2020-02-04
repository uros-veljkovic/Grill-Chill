/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste.impl;

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
    public boolean kreirajNoviProizvod(Proizvod proizvod) throws SQLException {
        int rezultat = 0;
//        try {
//            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
//
//            String upit = "INSERT INTO proizvod (Naziv, Opis, Cena, MernaJedinica) VALUES (?,?,?,?)";
//            PreparedStatement ps = konekcija.prepareStatement(upit);
//            ps.setString(1, proizvod.getNaziv());
//            ps.setString(2, proizvod.getOpis());
//            ps.setDouble(3, proizvod.getCena());
//            ps.setString(4, proizvod.getMernaJedinica().toString());
//
//            rezultat = ps.executeUpdate();
//        } catch (SQLException ex) {
//            throw new SQLException(ex.getMessage());
//        }
        return rezultat == 1;
    }

    @Override
    public boolean zapamtiProizvod(Proizvod proizvod) throws SQLException {
        //Za svaki upit idi ovom logikom.
        int zapamcen = 0;
//        String upit = "UPDATE proizvod SET Naziv = ?, Cena = ?, Opis = ?, MernaJedinica = ? WHERE ProizvodID = ?";
//
//        Connection konekcija;
//        try {
//            konekcija = FabrikaKonekcija.getInstance().getKonekcija();
//            PreparedStatement ps = konekcija.prepareStatement(upit);
//            ps.setString(1, proizvod.getNaziv());
//            ps.setDouble(2, proizvod.getCena());
//            ps.setString(3, proizvod.getOpis());
//            ps.setString(4, proizvod.getMernaJedinica().toString());
//            ps.setInt(5, proizvod.getProizvodID());
//
//            zapamcen = ps.executeUpdate();
//        } catch (Exception ex) {
//            System.err.println(ex.getMessage());
//            throw new SQLException(ex.getMessage());
//        }

        return zapamcen == 1;

    }

    @Override
    public boolean obrisiProizvod(Proizvod proizvod) {
//        try {
//            String upit = "DELETE FROM proizvod WHERE ProizvodID = ?";
//
//            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
//            PreparedStatement ps = konekcija.prepareStatement(upit);
//            ps.setInt(1, proizvod.getProizvodID());
//
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
        return false;//NE TREBA OVAKO
    }

    @Override
    public List<Proizvod> pretraziProizvode(String kriterijum) {
        ArrayList<Proizvod> pronadjeniProizvodi = new ArrayList<>();
//        try {
//
//            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
//
//            String upit = "SELECT * FROM proizvod WHERE Naziv='" + kriterijum + "'";
//            Statement stat = konekcija.createStatement();
//            ResultSet rs = stat.executeQuery(upit);
//
//            while (rs.next()) {
//                pronadjeniProizvodi.add(new Proizvod(rs.getInt("ProizvodID"),
//                        rs.getString("Naziv"),
//                        rs.getString("Opis"),
//                        rs.getDouble("Cena"),
//                        MernaJedinica.valueOf(rs.getString("MernaJedinica"))));
//
//            }
//            for (Proizvod proizvod : pronadjeniProizvodi) {
//                System.out.println(proizvod);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(SkladisteProizvodImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return pronadjeniProizvodi;
    }

    @Override
    public ArrayList<Proizvod> vratiProizvode() {
        ArrayList<Proizvod> listaProizvoda = null;
//
//        String upit = "SELECT * FROM proizvod";
//
//        try {
//
//            Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();
//            Statement stat = konekcija.createStatement();
//            ResultSet rs = stat.executeQuery(upit);
//
//            listaProizvoda = new ArrayList<>();
//
//            while (rs.next()) {
//                listaProizvoda.add(new Proizvod(rs.getInt("ProizvodID"),
//                        rs.getString("Naziv"),
//                        rs.getString("Opis"),
//                        rs.getDouble("Cena"),
//                        MernaJedinica.valueOf(rs.getString("MernaJedinica"))));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(SkladisteProizvodImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return listaProizvoda;
    }


}
