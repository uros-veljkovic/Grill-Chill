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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.KontrolerGUI;
import skladiste.SkladisteZaposleni;

/**
 *
 * @author urosv
 */
public class SkladisteZaposleniImpl implements SkladisteZaposleni {

    @Override
    public Zaposleni prijaviZaposlenog(String username, String password) throws SQLException {

        String upit = "SELECT z.*, m.PostanskiBroj, m.Grad, m.Drzava FROM zaposleni z JOIN mesto m ON (z.MestoID = m.PostanskiBroj) WHERE z.Username = ? AND z.Password = ?";
        Zaposleni ulogovaniZaposleni = null;
        Connection konekcija = FabrikaKonekcija.getInstance().getKonekcija();

        PreparedStatement ps = konekcija.prepareStatement(upit);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        ulogovaniZaposleni = new Zaposleni();

        while (rs.next()) {
            ulogovaniZaposleni.setZaposleniID(rs.getInt("ZaposleniID"));
            ulogovaniZaposleni.setImePrezime(rs.getString("ImePrezime"));
            ulogovaniZaposleni.setMenadzer(rs.getBoolean("Menadzer"));
            ulogovaniZaposleni.setPassword(rs.getString("Password"));
            ulogovaniZaposleni.setUsername(rs.getString("Username"));

            Mesto mestoZaposlenog = new Mesto(rs.getInt("MestoID"), rs.getString("Grad"), rs.getString("Drzava"));
            ulogovaniZaposleni.setMestoBoravista(mestoZaposlenog);
        }

        return ulogovaniZaposleni;

    }

    //Zasto vracamo zaposlenog ako smo ga tek kreirali u bazi ?
    @Override
    public Zaposleni kreirajZaposlenog(Zaposleni zaposleni) throws SQLException{
        String upit = "INSERT INTO zaposleni (ImePrezime, Username, Password, Menadzer, MestoID)VALUES (?,?,?,?,?)";

        try {

            Connection konekConnection = FabrikaKonekcija.getInstance().getKonekcija();
            PreparedStatement ps = konekConnection.prepareStatement(upit);
            ps.setString(1, zaposleni.getImePrezime());
            ps.setString(2, zaposleni.getUsername());
            ps.setString(3, zaposleni.getPassword());
            ps.setBoolean(4, zaposleni.isMenadzer());
            ps.setInt(5, zaposleni.getMestoBoravista().getPostanskiBroj());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            zaposleni = null;
            throw new SQLException(ex.getMessage());
        }
        return zaposleni;
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

    @Override
    public ArrayList<Zaposleni> vratiZaposleneZaBrisanje() throws SQLException {

        ArrayList<Zaposleni> listaZaposlenih = null;
        String upit = "SELECT z.*, m.PostanskiBroj, m.Grad, m.Drzava FROM zaposleni z JOIN mesto m ON (z.MestoID = m.PostanskiBroj)";

        Connection konekcija;
        try {
            konekcija = FabrikaKonekcija.getInstance().getKonekcija();
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);

            listaZaposlenih = new ArrayList<>();
            while (rs.next()) {
                //Ako je zaposleni menadzer, nece se naci u padajucoj listi za brisanje
                if (rs.getBoolean("Menadzer")) {
                    continue;
                }
                Zaposleni z = new Zaposleni();
                z.setZaposleniID(rs.getInt("ZaposleniID"));
                z.setImePrezime(rs.getString("ImePrezime"));
                z.setMenadzer(rs.getBoolean("Menadzer"));
                z.setPassword(rs.getString("Password"));
                z.setUsername(rs.getString("Username"));
                Mesto mestoZaposlenog = new Mesto(rs.getInt("MestoID"), rs.getString("Grad"), rs.getString("Drzava"));
                z.setMestoBoravista(mestoZaposlenog);

                listaZaposlenih.add(z);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }

        return listaZaposlenih;
    }

}
